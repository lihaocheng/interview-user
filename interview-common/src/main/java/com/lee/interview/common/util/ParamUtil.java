package com.lee.interview.common.util;

import java.util.Map;
import java.util.Set;

public class ParamUtil {

	public static String paramConcat(Map<String, ?> paramMap)
	{
		if(paramMap.isEmpty())
		{
			return "";
		}
		StringBuilder sb = new StringBuilder();
		Set<String> keySet = paramMap.keySet();
		sb.append('?');
		for (String key : keySet) 
		{
			if(key == null || key.trim().length() == 0 
					|| paramMap.get(key) == null || paramMap.get(key).equals(""))
			{
				continue;
			}
			sb.append(key).append('=').append(paramMap.get(key)).append('&');
		}
		return sb.toString().substring(0, sb.lastIndexOf("&"));
	}
	
}
