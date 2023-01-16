package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.CourseRepo;
import com.cg.entity.Course;
import com.cg.exception.NoSuchCourseFoundException;

@Service
public class CourseserviceImp implements CourseService{

	@Autowired
	private CourseRepo repo;
	
	@Override
	public Course createCourse(Course course) {
		return repo.save(course);
	}

	@Override
	public List<Course> findAllCourse() {
		return repo.findAll();
	}

	@Override
	public Course findCourseById(int id) throws NoSuchCourseFoundException {
		return repo.findById(id).orElseThrow(()->new NoSuchCourseFoundException("Invalid course id"));
	}

	@Override
	public Course update(int id, Course course) throws NoSuchCourseFoundException {
		Course find = findCourseById(id);
		find.setCourseName(course.getCourseName());
		find.setCourseFees(course.getCourseFees());
		return repo.save(find);
	}

	@Override
	public boolean deleteCourse(int id) {
		repo.deleteById(id);
		Optional<Course> find = repo.findById(id);
		return !(find.isEmpty());
	}

	
}
