package com.ucloudlink.demo.service;

import java.util.List;

import com.ucloudlink.course.bo.Course;
import com.ucloudlink.demo.bo.Student;

public interface IStudentService {
	
	public String sayHello(String name);
	
	public Student queryStudentById(int id);
	
	public void insertStudent(Student student);
	
	public void saveStudentInfo(Student student,List<Course> courseList);
}
