package com.stone.security.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDetailService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(userDetailService).passwordEncoder(encode());
		
		
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		
		http
			.csrf().disable();
		http
			.authorizeRequests()
			.antMatchers("/admin/**")
			.authenticated()
			.anyRequest()
			.hasRole("ADMIN")
			.and()
			.authorizeRequests()
			.antMatchers("/user/**")
			.authenticated()
			.anyRequest()
			.hasAnyRole("USER","ADMIN")
			.and()
			.formLogin()
			.permitAll();
		
		/*http
			.authorizeRequests()
			.antMatchers("/admin/**").hasRole("ADMIN")
			.antMatchers("/user/**").hasAnyRole("USER","ADMIN")
			.anyRequest()
			.authenticated()
			.and()
			.formLogin()
			.permitAll();*/
			
	}
	
	@Bean
	public BCryptPasswordEncoder encode() {
		return new BCryptPasswordEncoder();
	}

}
