package com.example.productcategoryservice.mapper;

import com.example.productcategoryservice.dto.CreateUserDto;
import com.example.productcategoryservice.dto.UserDto;
import com.example.productcategoryservice.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

//    @Mapping(target = "role", defaultValue = "USER")
    User map(CreateUserDto createUserDto);
    UserDto map(User user);
}
