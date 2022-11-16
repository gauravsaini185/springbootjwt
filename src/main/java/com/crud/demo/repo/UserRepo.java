package com.crud.demo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.demo.entity.LoginUser;

@Repository
public interface UserRepo extends JpaRepository<LoginUser, Integer>{

	Optional<LoginUser> findByUserId(String username);

}
