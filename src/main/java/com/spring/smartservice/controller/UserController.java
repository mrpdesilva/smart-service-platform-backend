package com.spring.smartservice.controller;

import com.spring.smartservice.dto.UserRequestDto;
import com.spring.smartservice.dto.UserResponseDto;
import com.spring.smartservice.entity.User;
import com.spring.smartservice.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserResponseDto createUser(@Valid @RequestBody UserRequestDto dto) {
        return userService.createUser(dto);
    }

    @GetMapping
    public List<UserResponseDto> getUsers() {
        return userService.getAllUsers();
    }
}
