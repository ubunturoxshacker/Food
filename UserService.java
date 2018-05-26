package com.foodhotelics.demo.service;


import org.springframework.security.core.userdetails.UserDetailsService;

import com.foodhotelics.demo.DTO.UserRegistrationDTO;
import com.foodhotelics.demo.model.User;


public interface UserService extends UserDetailsService {

    User findByEmail(String email);
     
    User save(UserRegistrationDTO registration);
}
