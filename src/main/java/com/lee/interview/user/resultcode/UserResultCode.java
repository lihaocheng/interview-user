package com.lee.interview.user.resultcode;

import lombok.Data;

@Data
public enum UserResultCode 
{
	
	SUCCESS("0", "success");
	
	private String retCode;
	
	private String retDesc;

	private UserResultCode(String retCode, String retDesc) 
	{
		this.retCode = retCode;
		this.retDesc = retDesc;
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
