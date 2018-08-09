package com.yangbingdong.admin.config;

import de.codecentric.boot.admin.server.config.AdminServerProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

/**
 * @author ybd
 * @date 18-7-19
 * @contact yangbingdong1994@gmail.com
 */
@Configuration
public class SecuritySecureConfig extends WebSecurityConfigurerAdapter {

	private final String adminContextPath;

	public SecuritySecureConfig(AdminServerProperties adminServerProperties) {
		this.adminContextPath = adminServerProperties.getContextPath();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
		successHandler.setTargetUrlParameter("redirectTo");
		http.authorizeRequests()
//			.antMatchers("/actuator", "/actuator/health", "/actuator/info").permitAll()
			.antMatchers(adminContextPath + "/assets/**").permitAll()
			.antMatchers(adminContextPath + "/login").permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin().loginPage(adminContextPath + "/login").successHandler(successHandler).and()
			.logout().logoutUrl(adminContextPath + "/logout").and()
			.httpBasic()
			.and()
			.csrf().disable();
	}

}
