package com.example.productcategoryservice.endpoint;

import com.example.productcategoryservice.entity.Product;
import com.example.productcategoryservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ProductEndpoint {

    private final ProductRepository productRepository;


    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductsById(@PathVariable("id") int id) {
        Optional<Product> byId = productRepository.findById(id);
        if (byId.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(byId.get());
    }

    @GetMapping("/products/{category_id}")
    public ResponseEntity<Product> getProductsByCategory(@PathVariable("category_id") int id) {
        Optional<Product> byCategory = productRepository.findByCategory(String.valueOf(id));
        if (byCategory.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(byCategory.get());
    }

    @PostMapping("/products")
    public ResponseEntity<?> createProduct(@RequestBody Product product){
        productRepository.save(product);
        return ResponseEntity.noContent().build();
    }
}
