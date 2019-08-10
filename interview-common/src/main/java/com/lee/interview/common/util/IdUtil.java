package com.lee.interview.common.util;

import java.util.UUID;

public class IdUtil {

	
	public static String randomId()
	{
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
}
