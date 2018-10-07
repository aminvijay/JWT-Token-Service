package com.vijay.jwt.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vijay.jwt.demo.db.pojo.User;
import com.vijay.jwt.demo.service.AppUserService;

@RestController
@RequestMapping("/users")
public class AppUserController {
	
	@Autowired()
	@Qualifier("VijayUserService")
	private AppUserService appUserService;
	

	@RequestMapping(value="/user/{username}", method=RequestMethod.GET)
	@PreAuthorize("hasAuthority('STANDARD_USER')")
	public ResponseEntity<User> getMessage(@PathVariable("username") String username) {
		return new ResponseEntity<> (appUserService.findByUsername(username), HttpStatus.OK);
	}

}
