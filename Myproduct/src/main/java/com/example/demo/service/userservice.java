package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.userRepo;
import com.example.demo.model.user;

@Service
public class userservice {
	
	@Autowired
	userRepo userre;
	
	public user getNameAndPassword(String name,String password) {
		return userre.findByNameAndPassword(name,password);
	}
}
