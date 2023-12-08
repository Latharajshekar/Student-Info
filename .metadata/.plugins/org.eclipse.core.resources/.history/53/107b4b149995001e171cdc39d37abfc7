package com.example.demo.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.Invalidcredential;
import com.example.demo.model.Admin;
import com.example.demo.repository.AdminRepo;
import com.example.demo.service.AdminService;
@Service
public class AdminServiceImp implements AdminService   {
@Autowired
AdminRepo repo;
	@Override
	
	public Admin login(String data, String password) {
		Admin a =repo.vadlidate(data,password);
		if(a!=null) {
			if(data.equals(a.getEmail())&&password.equals(a.getPassword())) {
				return a;
			}
			else{
				 throw new Invalidcredential();
				}
			}
		else{
			 throw new Invalidcredential();
			}
	}

}
