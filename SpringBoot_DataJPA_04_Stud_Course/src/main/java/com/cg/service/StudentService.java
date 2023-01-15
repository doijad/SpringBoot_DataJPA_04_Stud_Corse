package com.cg.service;

import java.util.List;

import com.cg.entity.Student;
import com.cg.exception.NoSuchStudentFoundException;

public interface StudentService {

	public Student createStudent(Student student);
	
	public List<Student> findAllStudent();
	
	public Student findStudentById(int id)throws NoSuchStudentFoundException;
	
	public Student updateStudent(int id,Student data)throws NoSuchStudentFoundException;
	
	public boolean deleteStudent(int id);
	
	public Student findByRoll(int roll);
	
	public List<Student> findByCourseName(String courseName);
}
