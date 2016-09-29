/*
 * Copyright 2012-2020 the original author or authors.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * @author lzhoumail@126.com/zhouli
 * Git http://git.oschina.net/zhou666/spring-cloud-7simple
 */
package com.nant.crm.member.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nant.crm.member.model.Member;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
//import cloud.simple.service.UserServiceProvider.FeignUserService;

@Service
public class UserService {
	 @Autowired	 
	 RestTemplate restTemplate;
	
	/* @Autowired
	 FeignUserService feignUserService;*/
	 
	 final String SERVICE_NAME="crm-member-service";
	 
	 @HystrixCommand(fallbackMethod = "fallbackSearchAll")
	 public List<Member> readUserInfo() {
	        return restTemplate.getForObject("http://"+SERVICE_NAME+"/user", List.class);
		 //return feignUserService.readUserInfo();
	 }	 
	 private List<Member> fallbackSearchAll() {
		 System.out.println("HystrixCommand fallbackMethod handle!");
		 List<Member> ls = new ArrayList<Member>();
		 Member user = new Member();
		 user.setUsername("TestHystrixCommand");
		 ls.add(user);
		 return ls;
	 }
}
