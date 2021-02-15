package com.rays.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.test.dto.Student;
import com.rays.test.studentRepository.StudentRepository;

@RestController
@RequestMapping("Student")
public class StudentCtl {

	@Autowired
	StudentRepository studentRepository;
	
	 @PostMapping("save")
	 ResponseEntity<Student> createStudent(@RequestBody Student student) {
		    try {
		    	Student _student = studentRepository
		          .save(new Student(student.getStudentName()));
		      return new ResponseEntity<>(_student, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
		  }
	 
	 
	 @DeleteMapping("/studentDelete")
	  public ResponseEntity<HttpStatus> deleteAllTutorials() {
	    try {
	      studentRepository.deleteAll();
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }

	  }
}
