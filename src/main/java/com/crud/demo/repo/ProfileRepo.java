package com.crud.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.demo.entity.Profile;

@Repository
public interface ProfileRepo extends JpaRepository<Profile, Integer>{

}
