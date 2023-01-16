package com.cg.service;

import java.util.List;

import com.cg.entity.Course;
import com.cg.exception.NoSuchCourseFoundException;

public interface CourseService {

	public Course createCourse(Course course);
	
	public List<Course> findAllCourse();
	
	public Course findCourseById(int id) throws NoSuchCourseFoundException;
	
	public Course update(int id,Course course) throws NoSuchCourseFoundException;
	
	boolean deleteCourse(int id);
}
