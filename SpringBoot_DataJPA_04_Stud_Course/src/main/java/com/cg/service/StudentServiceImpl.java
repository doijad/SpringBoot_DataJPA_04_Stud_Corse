package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.dao.StudentRepo;
import com.cg.entity.Student;
import com.cg.exception.NoSuchStudentFoundException;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepo sRepo;
	
	
	@Override
	@Transactional
	public Student createStudent(Student student) {
		return sRepo.save(student);
	}

	@Override
	public List<Student> findAllStudent() {
		return sRepo.findAll();
	}

	@Override
	public Student findStudentById(int id) throws NoSuchStudentFoundException {
		Optional<Student> stud=sRepo.findById(id);
		if(stud.isPresent())
			return stud.get();
		else
			throw new NoSuchStudentFoundException("Student Not Found with id "+id);
	}

	@Override
	@Transactional
	public Student updateStudent(int id, Student data) throws NoSuchStudentFoundException {
		Student student = findStudentById(id);
		student.setRoll(student.getRoll());
		student.setName(data.getName());
		student.setCourses(data.getCourses());
		return sRepo.save(student);
	}

	@Override
	@Transactional
	public boolean deleteStudent(int id) {
		sRepo.deleteById(id);
		Optional<Student> find = sRepo.findById(id);
		return !(find.isEmpty());
	}

	@Override
	public Student findByRoll(int roll) {
		return sRepo.findByRoll(roll);
	}

	@Override
	public List<Student> findByCourseName(String courseName) {
		return sRepo.findByCourseName(courseName);
	}

}
