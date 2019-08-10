package com.lee.interview.iam.rest.customer.controller;


import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.lee.interview.common.util.ParamUtil;

@RestController
@RequestMapping("/customer")
public class CustomerRestController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${provider.customer.url}")
	private String customerUrl;

	@RequestMapping(path = "/members", method = RequestMethod.GET)
	public ResponseEntity<String> getUser(@RequestParam(required = false) String startTime, 
						   @RequestParam(required = false) String endTime, 
						   @RequestParam(required = false) String memberName, 
						   @RequestParam(required = false, defaultValue = "1") Integer pageNo,
						   @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("startTime", startTime);
		paramMap.put("endTime", endTime);
		paramMap.put("memberName", memberName);
		paramMap.put("pageNo", pageNo);
		paramMap.put("pageSize", pageSize);
		String paramStr = ParamUtil.paramConcat(paramMap);
		String url = customerUrl + "/members" + paramStr;
		return restTemplate.getForEntity(url, String.class);
	}
	
	@RequestMapping(path = "/member/create", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> createMember(@RequestBody JSONObject jsonParam) {
		String url = customerUrl + "/member/create";
		return restTemplate.postForEntity(url, jsonParam, JSONObject.class);
	}
}
