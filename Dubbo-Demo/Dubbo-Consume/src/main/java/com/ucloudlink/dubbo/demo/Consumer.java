package com.ucloudlink.dubbo.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ucloudlink.course.bo.Course;
import com.ucloudlink.demo.bo.Student;
import com.ucloudlink.demo.service.IStudentService;

public class Consumer {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"META-INF/spring/applicationContext-dubbo.xml"});
        context.start();

        /*IStudentService demoService = (IStudentService)context.getBean("studentService");
        Student student = demoService.queryStudentById(1); 
        System.out.println(student.getName());
        
        ICourseService courseService = (ICourseService)context.getBean("courseService");
        Course course = courseService.queryCourseById(1); 
        System.out.println(course.getName());*/
        
        IStudentService demoService = (IStudentService)context.getBean("studentService");
        Student student = new Student();
        student.setName("李伟");
        student.setAge(30);
        
        List courseList = new ArrayList();
        Course course = new Course();
        course.setsId(2);
        course.setName("语文*");
        course.setScore(80);
        courseList.add(course);
        demoService.saveStudentInfo(student, courseList); 
    }
}