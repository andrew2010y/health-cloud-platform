package com.nant.crm.member.service.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nant.crm.member.model.Member;
import com.nant.crm.member.service.domain.MemberService;

@RestController
public class MemberController {

	@Autowired
	MemberService memberService;
	
	@RequestMapping(value="/user",method=RequestMethod.GET)
	public List<Member> readUserInfo(){
		List<Member> ls = memberService.searchAll();		
		
		return ls;
	}
}
