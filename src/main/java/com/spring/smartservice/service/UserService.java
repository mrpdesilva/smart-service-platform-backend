package com.spring.smartservice.service;

import com.spring.smartservice.dto.UserRequestDto;
import com.spring.smartservice.dto.UserResponseDto;
import com.spring.smartservice.entity.User;

import java.util.List;

public interface UserService {

    UserResponseDto createUser(UserRequestDto dto);

    List<UserResponseDto> getAllUsers();

    UserResponseDto getUserById(Long id);
}
