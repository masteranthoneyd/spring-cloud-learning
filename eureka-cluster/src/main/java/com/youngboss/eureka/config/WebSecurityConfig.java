package com.youngboss.eureka.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author ybd
 * @date 18-7-18
 * @contact yangbingdong1994@gmail.com
 */
@EnableWebSecurity
class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private static final String EUREKA = "/eureka/**";

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().ignoringAntMatchers(EUREKA);
		super.configure(http);
	}
}
