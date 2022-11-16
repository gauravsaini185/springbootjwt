package com.crud.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.crud.demo.entity.CustomUsersDetail;
import com.crud.demo.entity.LoginUser;
import com.crud.demo.repo.UserRepo;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<LoginUser> user = repo.findByUserId(username);
		LoginUser user1 = null;
		if(user.isPresent()) {
			user1 = user.get();
			}
		else {
			throw new UsernameNotFoundException("Not found");
		}
		
		return new CustomUsersDetail(user1);
		
	}

}
