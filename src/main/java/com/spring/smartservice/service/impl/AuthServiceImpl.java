package com.spring.smartservice.service.impl;

import com.spring.smartservice.dto.LoginRequestDto;
import com.spring.smartservice.dto.LoginResponseDto;
import com.spring.smartservice.entity.User;
import com.spring.smartservice.exception.ResourceNotFoundException;
import com.spring.smartservice.repository.UserRepository;
import com.spring.smartservice.security.JwtUtil;
import com.spring.smartservice.service.AuthService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public LoginResponseDto login(LoginRequestDto dto) {

        User user = userRepository.findByEmail(dto.getEmail())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Invalid email or password")
                );

        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new ResourceNotFoundException("Invalid email or password");
        }

        String token = jwtUtil.generateToken(user.getEmail());

        LoginResponseDto response = new LoginResponseDto();
        response.setToken(token);
        return response;
    }
}
