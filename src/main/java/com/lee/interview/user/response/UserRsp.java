package com.lee.interview.user.response;

import com.lee.interview.user.resultcode.UserResultCode;

import lombok.Data;
@Data
public class UserRsp{

	private String retCode;
	
	private String retDesc;
	
	public UserRsp(UserResultCode resultCode)
	{
		this.retCode = resultCode.getRetCode();
		this.retDesc = resultCode.getRetDesc();
	}

	public String getRetCode() {
		return retCode;
	}

	public void setRetCode(String retCode) {
		this.retCode = retCode;
	}

	public String getRetDesc() {
		return retDesc;
	}

	public void setRetDesc(String retDesc) {
		this.retDesc = retDesc;
	}

	
}
