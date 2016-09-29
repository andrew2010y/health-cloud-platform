/*
 * Copyright 2012-2020 the original author or authors.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * @author lzhoumail@126.com/zhouli
 * Git http://git.oschina.net/zhou666/spring-cloud-7simple
 */

package com.nant.crm.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nant.crm.member.model.Member;
import com.nant.crm.member.service.UserService;

@RestController
public class MemberController {
		
	@Autowired
	UserService userService;
	
	/*@Autowired
	FeignUserService feignUserService;*/
	
	@RequestMapping(value="/users")
	public ResponseEntity<List<Member>> readUserInfo(){
		List<Member> users=userService.readUserInfo();		
		
		return new ResponseEntity<List<Member>>(users,HttpStatus.OK);
	}
	
}
