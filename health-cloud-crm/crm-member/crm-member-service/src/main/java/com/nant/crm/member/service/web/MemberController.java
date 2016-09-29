package com.nant.crm.member.service.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nant.crm.member.model.Member;
import com.nant.crm.member.service.domain.MemberService;

@RestController
@RequestMapping(value = "/member")
public class MemberController {

	@Autowired
	MemberService memberService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public List<Member> list(){
		List<Member> ls = memberService.searchAll();		
		
		return ls;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public Member save(@RequestBody String username) {
		Member p = new Member();
		p.setUsername(username);
		
		memberService.save(p);
       
		return p;
    }
	 	
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(@RequestParam Integer[] userId) {
		memberService.deleteById(userId[0]);
    }
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void update(@RequestBody Member member) {
		memberService.updateById(member);
    }
}
