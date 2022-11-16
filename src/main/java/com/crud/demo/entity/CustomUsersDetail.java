package com.crud.demo.entity;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUsersDetail implements UserDetails{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LoginUser user;
	

	public CustomUsersDetail(LoginUser user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	/*	HashSet<SimpleGrantedAuthority> set = new HashSet<>();
		set.add(new SimpleGrantedAuthority(this.user.getRole()));
		return set; */
		return Collections.emptyList();
	}

	@Override
	public String getPassword() {
		return this.user.getPassword();
	}

	@Override
	public String getUsername() {
		return this.user.getUserId();
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}

}
