package com.nant.crm.demo.service.dao;

import java.util.List;

import com.nant.crm.demo.model.User;


public interface UserDao {

	List<User> findAll();
}
