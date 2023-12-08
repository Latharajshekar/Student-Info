package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.StudenNotFoundException;
import com.example.demo.exception.StudentAlreadyExistsException;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepo;
import com.example.demo.service.StudentService;

import lombok.RequiredArgsConstructor;



@Service
@RequiredArgsConstructor
public class StudentserviceImp implements StudentService {
												
@Autowired
	 StudentRepo repo;
	@Override
	public Student addstudent(Student s) {
		if(StudentAlreadyExists(s.getEmail()))
		{
			throw new StudentAlreadyExistsException(s.getEmail()+"already Exists!!");
			
		}
		return repo.save(s);
			}

	



	@Override
	public List<Student> getStudents() {
		return repo.findAll();
		
	}

	@Override
	public Student updateStudent(Student s, Long id) {
		return repo.findById(id).map(st -> {
			st.setFirstName(s.getFirstName());
			st.setLastName(s.getLastName());
			st.setEmail(s.getEmail());
            st.setDepartment(s.getDepartment());
            return repo.save(st);	
		}).orElseThrow(()->new StudenNotFoundException(s.getId()+" Student not Exists"));
					
		}

	@Override
	public Student getStudentByID(long id) {
		
		return repo.findById(id).orElseThrow(()-> new StudenNotFoundException("Student Not found :"+id));
	}

	@Override
	public void deletestudent(long id) {
		if(!repo.existsById(id)) {
		throw new StudenNotFoundException("Student Not found !!");
		}
		else {
			repo.deleteById(id);
		}
		
	}
private boolean StudentAlreadyExists(String email) {
		
		return repo.findByEmail(email).isPresent() ;
	}

}
