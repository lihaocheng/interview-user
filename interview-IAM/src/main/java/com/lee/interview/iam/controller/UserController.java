package com.lee.interview.iam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.lee.interview.iam.entity.User;
import com.lee.interview.iam.mapper.UserMapper;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;
    
    @GetMapping(value="/user/{username}")
    public Object getUserByName(@PathVariable String username) {
        User user = userMapper.findByName(username);
        return user;    
    }
}
