package com.lee.interview.user.service;

import com.lee.interview.user.domain.UserInfo;
import com.lee.interview.user.request.CreateUserReq;

public interface UserService {

	public UserInfo getUserInfo(Integer userId);

	public void create(CreateUserReq req);
}
