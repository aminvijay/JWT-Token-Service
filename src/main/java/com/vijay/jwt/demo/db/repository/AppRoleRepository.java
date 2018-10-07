package com.vijay.jwt.demo.db.repository;

import org.springframework.data.repository.CrudRepository;

import com.vijay.jwt.demo.db.pojo.Role;

public interface AppRoleRepository extends CrudRepository <Role, Long>{

	Role findByRolename(String rolename);
}
