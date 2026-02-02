package com.spring.smartservice.service;

import com.spring.smartservice.entity.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);
    List<User> getAllUsers();
}
