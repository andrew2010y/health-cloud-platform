package com.nant.crm.member.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UiController {
/*	@Autowired
	private SomeHystrixService someHystrixService;
	
	@Autowired
	private PersonHystrixService personHystrixService;*/

	@RequestMapping("/dispatch")
	public List<Person> sendMessage(@RequestBody String personName) {
		return null;//personHystrixService.save(personName);
	}
	
	@RequestMapping(value = "/getsome",produces={MediaType.TEXT_PLAIN_VALUE})
	public String getSome(){
		return null;//someHystrixService.getSome();
	}
}
