package com.lee.interview.user.domain;

import java.sql.Timestamp;

import com.lee.interview.common.util.DateUtil;
import com.lee.interview.common.util.IdUtil;
import com.lee.interview.user.request.CreateUserReq;

import lombok.Data;

@Data
public class User {

	private String userId;

	private String username;
	
	private String password;
	
	private String sex;
	
	private Integer age;
	
	private String address;
	
	private String mobile;
	
	private String email;
	
	private Timestamp createtime;
	
	private String creatorId;
	
	private Timestamp updatetime;
	
	private String updateId;

	public static User tranfer(CreateUserReq req)
	{
		User user = new User();
		user.setUserId(IdUtil.randomId());
		user.setCreatetime(DateUtil.currentTimestamp());
		user.setUsername(req.getUsername());
		user.setAddress(req.getAddress());
		user.setAge(req.getAge());
		user.setEmail(req.getEmail());
		user.setMobile(req.getMobile());
		user.setSex(req.getSex());
		return user;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public String getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	public Timestamp getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public String getUpdateId() {
		return updateId;
	}

	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}
	
	
}
