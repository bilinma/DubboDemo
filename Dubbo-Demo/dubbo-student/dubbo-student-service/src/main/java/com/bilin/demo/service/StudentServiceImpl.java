package com.bilin.demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bilin.course.bo.Course;
import com.bilin.course.service.ICourseService;
import com.bilin.demo.bo.Student;
import com.bilin.demo.dao.IStudentMapper;
import com.bilin.demo.service.IStudentService;

@Service
@Transactional(readOnly=true)
public class StudentServiceImpl implements IStudentService {
	
	@Resource
	private IStudentMapper studentMapper;
	
	@Autowired
	private ICourseService courseService;
	
	
	@Override
    public String sayHello(String name) {
        return "Hello " + name;
    }

	@Override
	public Student queryStudentById(int id) {
		Student student = new Student();
		student.setId(id);
		return studentMapper.selectOne(student);
	}

	@Override
	@Transactional(readOnly=false,rollbackFor=Exception.class)
	public void insertStudent(Student student) {
		studentMapper.insert(student);
	}
	
	/**
	 *	
	 */
	@Override
	@Transactional(readOnly=false,rollbackFor=Exception.class)
	public void saveStudentInfo(Student student, List<Course> courseList) {
		for(Course course :courseList){
			courseService.insertCourse(course);
		}
		String a = null;
		a.toString();
		studentMapper.insert(student);
	}
}