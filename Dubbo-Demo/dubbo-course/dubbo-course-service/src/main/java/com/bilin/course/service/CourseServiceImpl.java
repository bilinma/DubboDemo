package com.bilin.course.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bilin.course.bo.Course;
import com.bilin.course.dao.ICourseMapper;
import com.bilin.course.service.ICourseService;

@Service
@Transactional(readOnly=true)
public class CourseServiceImpl implements ICourseService {
	
	@Resource
	private ICourseMapper courseMapper;
	
	
	@Override
    public String sayHello(String name) {
        return "Hello " + name;
    }

	@Override
	public Course queryCourseById(int id) {
		Course Course = new Course();
		Course.setId(id);
		return courseMapper.selectOne(Course);
	}

	@Override
	@Transactional(readOnly=false,rollbackFor=Exception.class)
	public void insertCourse(Course Course) {
		courseMapper.insert(Course);
	}
}