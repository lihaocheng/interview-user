package com.lee.interview.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lee.interview.user.domain.UserInfo;
import com.lee.interview.user.request.CreateUserReq;
import com.lee.interview.user.response.UserRsp;
import com.lee.interview.user.resultcode.UserResultCode;
import com.lee.interview.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping("/get/{userId}")
	public UserInfo getUser(@PathVariable Integer userId) {
		return userService.getUserInfo(userId);
	}
	
	@RequestMapping("/create")
	public UserRsp create(@RequestBody CreateUserReq req) 
	{
		userService.create(req);
		return new UserRsp(UserResultCode.SUCCESS);
	}
	
	
}
