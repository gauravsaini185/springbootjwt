package com.crud.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.crud.demo.security.JwtAuthenticationEntryPoint;
import com.crud.demo.security.JwtAuthenticationFilter;
import com.crud.demo.service.CustomUserDetailService;



@Configuration
@EnableWebSecurity
public class MyConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private CustomUserDetailService service;
	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
			.csrf()
			.disable()
			.authorizeRequests()
			.antMatchers("/api/auth/login").permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.exceptionHandling()
			.authenticationEntryPoint(this.jwtAuthenticationEntryPoint)
			.and()
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.addFilterBefore(this.jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
				
		
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(service)
			.passwordEncoder(passEncoder());
			
	}
	
	@Bean
	public BCryptPasswordEncoder passEncoder() {
		return new BCryptPasswordEncoder(10);
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	
	
	
	
	
	

}
