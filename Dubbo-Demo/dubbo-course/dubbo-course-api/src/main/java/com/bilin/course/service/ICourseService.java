package com.bilin.course.service;

import com.bilin.course.bo.Course;

public interface ICourseService {
	
	public String sayHello(String name);
	
	public Course queryCourseById(int id);
	
	public void insertCourse(Course Course);
}
