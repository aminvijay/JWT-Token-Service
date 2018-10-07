package com.vijay.jwt.demo.db.repository;

import org.springframework.data.repository.CrudRepository;

import com.vijay.jwt.demo.db.pojo.User;

public interface AppUserRepository extends CrudRepository <User, Long>{

	User findByUsername(String username);
}
