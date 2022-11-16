package com.crud.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.demo.entity.Profile;
import com.crud.demo.entity.Profile2;
import com.crud.demo.service.ProfileService;

@RestController
@RequestMapping("/profile")
public class ProfileController {

	@Autowired
	private ProfileService profileService;

@GetMapping("/list")	
public List<Profile> getAll(){
	
	return profileService.list();
}

@PostMapping("/save")
public void save(@RequestBody Profile2 p ) {
	profileService.save(p);
}


}

