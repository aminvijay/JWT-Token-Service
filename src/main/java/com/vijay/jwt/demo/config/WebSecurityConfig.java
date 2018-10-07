package com.vijay.jwt.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@Configuration
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
public class WebSecurityConfig {
	
	//https://springframework.guru/using-the-h2-database-console-in-spring-boot-with-spring-security/
	//http://localhost:8080/console/
	/*
	@Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
        		//.authorizeRequests().antMatchers("/").permitAll().and()
                .authorizeRequests().antMatchers("/console/**").permitAll();

        httpSecurity.csrf().disable();
       httpSecurity.headers().frameOptions().disable();
    }	
    */

}
