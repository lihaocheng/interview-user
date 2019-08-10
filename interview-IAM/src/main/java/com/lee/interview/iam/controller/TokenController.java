package com.lee.interview.iam.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lee.interview.iam.annotation.NoneAuth;
import com.lee.interview.iam.constant.MessageConstant;
import com.lee.interview.iam.constant.NormalConstant;
import com.lee.interview.iam.entity.JsonData;
import com.lee.interview.iam.entity.User;
import com.lee.interview.iam.enums.HttpStatusEnum;
import com.lee.interview.iam.mapper.UserMapper;
import com.lee.interview.iam.request.LoginReq;
import com.lee.interview.iam.token.TokenHelper;
import com.lee.interview.iam.token.TokenModel;

@RestController
@RequestMapping("/token")
public class TokenController {
    
    @Autowired
    private UserMapper userMapper;
    
    @Autowired
    private TokenHelper tokenHelper;
	
    @NoneAuth
	@PostMapping
	public Object login(@RequestBody LoginReq req) {
	    User user = userMapper.findByName(req.getUsername());
	    if(user == null || !user.getPassword().equals(req.getPassword())) {
	        return JsonData.buildError(HttpStatusEnum.NOT_FOUND.getCode(), MessageConstant.USERNAME_OR_PASSWORD_ERROR);
	    }
	    
	    TokenModel model = tokenHelper.create(user.getId());
	    return JsonData.buildSuccess(model);    
	}
	
	@DeleteMapping
	public Object logout(HttpServletRequest request) {
	    Integer userId = (Integer) request.getAttribute(NormalConstant.CURRENT_USER_ID);
	    if(userId != null) {
	        tokenHelper.delete(userId);
	    }
	    return JsonData.buildSuccess();
	}

}
