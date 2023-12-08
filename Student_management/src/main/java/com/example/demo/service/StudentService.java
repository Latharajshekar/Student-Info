package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Student;

public interface StudentService {
Student addstudent(Student s);
List<Student>getStudents();
Student updateStudent(Student s,Long id);
Student getStudentByID(long id);
void deletestudent(long id);

}
