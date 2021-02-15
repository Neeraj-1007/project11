package com.rays.test.studentRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rays.test.dto.Student;

public interface StudentRepository extends JpaRepository<Student,Long>{

}
