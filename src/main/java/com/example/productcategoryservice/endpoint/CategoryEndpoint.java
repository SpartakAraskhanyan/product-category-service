package com.example.productcategoryservice.endpoint;

import com.example.productcategoryservice.dto.CategoryResponseDto;
import com.example.productcategoryservice.dto.CreateCategoryDto;
import com.example.productcategoryservice.entity.Category;
import com.example.productcategoryservice.mapper.CategoryMapper;
import com.example.productcategoryservice.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CategoryEndpoint {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;


    @GetMapping("/categories")
    public List<CategoryResponseDto> getAllCategories() {
        return categoryMapper.map(categoryRepository.findAll());
    }


    @PostMapping("/categories")
    public ResponseEntity<?> createCategory(@RequestBody CreateCategoryDto createCategoryDto){
        Category savedCategory = categoryRepository.save(categoryMapper.map(createCategoryDto));
        return ResponseEntity.ok(savedCategory);
    }

}
