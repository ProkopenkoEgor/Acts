package com.example.ActsBack.mapper;

import com.example.ActsBack.Model.DTO.SignUpDto;
import com.example.ActsBack.Model.DTO.UserDto;
import com.example.ActsBack.Model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(UserModel user);

    @Mapping(target = "password", ignore = true)
    UserModel signUpToUser(SignUpDto signUpDto);
}
