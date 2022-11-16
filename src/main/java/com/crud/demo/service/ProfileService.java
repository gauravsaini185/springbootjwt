package com.crud.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.demo.entity.Profile;
import com.crud.demo.entity.Profile2;
import com.crud.demo.repo.ProfileRepo;



@Service
public class ProfileService {
	
	@Autowired
	private ProfileRepo profileRepo;
	
	public List<Profile> list(){
	List<Profile> profile = new ArrayList<Profile>();
			profile = profileRepo.findAll();
		return profile;	
	}

	public void save(Profile2 p) {
		Profile p2 = new Profile();
		p2.setAddress(p.getAddress());
		p2.setPhone(p.getPhone());
		profileRepo.save(p2);
	}

}
