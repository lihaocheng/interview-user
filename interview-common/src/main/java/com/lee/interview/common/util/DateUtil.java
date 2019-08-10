package com.lee.interview.common.util;

import java.sql.Timestamp;

public class DateUtil {

	public static Timestamp currentTimestamp()
	{
		return new Timestamp(System.currentTimeMillis());
	}
}
