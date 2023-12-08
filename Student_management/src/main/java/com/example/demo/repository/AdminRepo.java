package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer> {
	@Query(value="select * from admin where email=?1 or password=?2",nativeQuery=true)
		Admin vadlidate(String data, String password);

}
