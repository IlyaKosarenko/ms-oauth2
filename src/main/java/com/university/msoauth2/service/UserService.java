package com.university.msoauth2.service;

import com.university.msoauth2.request.UserRegisterRequest;
import com.university.msoauth2.response.UserRegisterResponse;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final JdbcUserDetailsManager jdbcUserDetailsManager;


    public UserService(JdbcUserDetailsManager jdbcUserDetailsManager) {
        this.jdbcUserDetailsManager = jdbcUserDetailsManager;
    }

    public UserRegisterResponse registerUser(UserRegisterRequest request) {
        return null;

    }

}
