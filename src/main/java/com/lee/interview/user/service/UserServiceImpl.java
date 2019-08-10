package com.lee.interview.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lee.interview.user.domain.User;
import com.lee.interview.user.domain.UserInfo;
import com.lee.interview.user.mapper.UserMapper;
import com.lee.interview.user.request.CreateUserReq;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public UserInfo getUserInfo(Integer userId) {
		return userMapper.getUserById(userId);
	}

	@Override
	public void create(CreateUserReq req) 
	{
		User user = User.tranfer(req);
		userMapper.create(user);
	}

}
