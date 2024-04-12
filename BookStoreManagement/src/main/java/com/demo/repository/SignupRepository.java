package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.Entity.Signup;

@Repository
public interface SignupRepository extends JpaRepository<Signup, Integer>{
	
	Signup findByUname(String uname);

}
