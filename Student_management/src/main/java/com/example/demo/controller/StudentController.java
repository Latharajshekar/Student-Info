package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/students")
@RequiredArgsConstructor
@Data
public class StudentController {
@Autowired
private final  StudentService service;
@GetMapping
public ResponseEntity<List<Student>> getStudents(){
	return new ResponseEntity<>(service.getStudents(),HttpStatus.FOUND);
}
@PostMapping
public Student addStudent(@RequestBody Student s) {
	 return service.addstudent(s);
}
@PutMapping("/update/{id}")
public Student updateStudent(@RequestBody Student s, @PathVariable Long id) {
	return service.updateStudent(s, id);
}

@GetMapping("/student/{id}")
public Student getStudentByID( @PathVariable Long id)
{
	return service.getStudentByID(id);
}

@DeleteMapping("/delete/{id}")
public void deletestudent(@PathVariable Long id) {
	
	 service.deletestudent(id);
}

}