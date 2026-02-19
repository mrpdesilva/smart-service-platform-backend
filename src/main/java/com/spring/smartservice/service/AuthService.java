package com.spring.smartservice.service;

import com.spring.smartservice.dto.LoginRequestDto;
import com.spring.smartservice.dto.LoginResponseDto;

public interface AuthService {
    LoginResponseDto login(LoginRequestDto dto);
}
