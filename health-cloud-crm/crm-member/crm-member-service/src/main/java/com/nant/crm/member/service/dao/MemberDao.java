package com.nant.crm.member.service.dao;

import java.util.List;

import com.nant.crm.member.model.Member;


public interface MemberDao {

	List<Member> findAll();
	
	int save(Member user);

	Member selectById(Integer id);

	int updateById(Member user);

	int deleteById(Integer id);

	List<Member> queryAll();
}
