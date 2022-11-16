package com.crud.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.demo.security.JwtAuthRequest;
import com.crud.demo.security.JwtAuthResponse;
import com.crud.demo.security.JwtTokenHelper;

@RestController
@RequestMapping("/api/auth/")
public class LoginController {
	
	@Autowired
	private JwtTokenHelper jwtTokenHelper;
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/login")
	public ResponseEntity<JwtAuthResponse> createToken(
			@RequestBody JwtAuthRequest req){
		
		this.authenticate(req.getUserId(),req.getPassword());
		UserDetails userDetails = this.userDetailsService.loadUserByUsername(req.getUserId());
		String token = this.jwtTokenHelper.generateToken(userDetails);
		JwtAuthResponse response = new JwtAuthResponse();
		response.setToken(token);
		return new ResponseEntity<JwtAuthResponse>(response,HttpStatus.OK);
		
	}

	private void authenticate(String userId, String password) {
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =  new UsernamePasswordAuthenticationToken(userId, password);
		this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);
		
	}
}
