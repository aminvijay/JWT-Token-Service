package com.vijay.jwt.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vijay.jwt.demo.db.pojo.User;
import com.vijay.jwt.demo.db.repository.AppUserRepository;

@Service("VijayUserService")
public class AppUserService {
	
	@Autowired
	private AppUserRepository userRepo;
	
	public User findByUsername(String username) {
	
		return userRepo.findByUsername(username);
	}

}
