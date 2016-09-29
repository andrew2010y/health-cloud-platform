package com.nant.crm.member.service.domain;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nant.crm.member.model.Member;
import com.nant.crm.member.service.dao.MemberDao;



@Service
@Transactional
public class MemberService {
	
	@Autowired
	private MemberDao userDao;
	
	public List<Member> searchAll(){
		List<Member> list = userDao.findAll();
		return list;
	}
	
	int save(Member user){
		return userDao.save(user);
	}

	Member selectById(Integer id){
		return userDao.selectById(id);
	}

	int updateById(Member user){
		return userDao.updateById(user);
	}

	int deleteById(Integer id){
		return userDao.deleteById(id);
	}
}
