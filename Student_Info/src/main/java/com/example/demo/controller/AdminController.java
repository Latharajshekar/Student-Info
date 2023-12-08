package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Admin;
import com.example.demo.serviceimpl.AdminServiceImp;

@RestController
@CrossOrigin
public class AdminController {
@Autowired
AdminServiceImp ser;
@GetMapping("/admin")
ResponseEntity<Admin>admin(@RequestHeader String data,@RequestHeader String password){
	return new ResponseEntity<Admin>(ser.login(data, password),HttpStatus.FOUND);
	
}
}
