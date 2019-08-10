package com.lee.interview.user.mapper;

import org.apache.ibatis.annotations.*;

import com.lee.interview.user.domain.User;
import com.lee.interview.user.domain.UserInfo;

@Mapper
public interface UserMapper {
	
	@Select("SELECT user_id,user_name,user_birth FROM tb_user WHERE user_id = #{userId}")
	public UserInfo getUserById(@Param(value = "userId") Integer userId);

	@Insert("INSERT INTO t_user_user"
	+ "(userId, username, password, sex, age, address, mobile, email, createtime, creatorId, updatetime, updateId)"
	+ " VALUES(#{userId}, #{username}, #{password}, #{sex}, #{age}, #{address}, #{mobile}, #{email}, #{createtime}, #{creatorId}, #{updatetime}, #{updateId})")                                
	public void create(User user);

}
