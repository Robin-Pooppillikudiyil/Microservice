package com.microservice.phoneapp.api.users.sercurity;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
	
	protected void configure(HttpSecurity httpsecurity) throws Exception{
		httpsecurity.csrf().disable();
		httpsecurity.authorizeRequests().antMatchers("/users/**").permitAll();
		httpsecurity.headers().frameOptions().disable();
	}

}
