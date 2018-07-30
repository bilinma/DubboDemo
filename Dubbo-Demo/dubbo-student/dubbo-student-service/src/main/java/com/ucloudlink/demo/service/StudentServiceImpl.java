package com.ucloudlink.demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ucloudlink.course.bo.Course;
import com.ucloudlink.course.service.ICourseService;
import com.ucloudlink.demo.bo.Student;
import com.ucloudlink.demo.dao.IStudentMapper;

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