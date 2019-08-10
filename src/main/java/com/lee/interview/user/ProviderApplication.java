package com.lee.interview.user;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lee.interview.user.domain.UserInfo;

@SpringBootApplication
@RestController
public class ProviderApplication {
	
	@Value("${spring.application.name}")
	private String applicationName;

	public static void main(String[] args) {
		SpringApplication.run(ProviderApplication.class, args);
	}
	
	@RequestMapping("/")
	public String home() {
		return "hello aniu application name : " + applicationName;
	}
	
	@RequestMapping("/userinfo/")
	public UserInfo userInfo() {
		UserInfo userInfo = new UserInfo();
		userInfo.setUserId(1);
		userInfo.setUserName("zhangsan");
		return userInfo;
	}
}
