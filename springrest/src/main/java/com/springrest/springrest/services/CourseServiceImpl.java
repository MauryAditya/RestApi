package com.springrest.springrest.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;

@Service
public class CourseServiceImpl implements  CourseService{
	
	@Autowired
    private	CourseDao courseDao;
	
	//List<Course>list;
	public CourseServiceImpl() {
		
//		list =new ArrayList<>();
//		list.add(new Course(101,"java","About the java"));
//		list.add(new Course(102,"spring boot ", "Iplement spring boot"));
	}

	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		
		return courseDao.findAll();
	}

	@Override
	public Course getCourse(long courseId) {
		// TODO Auto-generated method stub
		
//			Course c=null;
//			for(Course course:list) {
//				
//				if(course.getId()==courseId) {
//					c=course;
//					break;
//				}
//			}
//				
			return courseDao.getOne(courseId);
	
	}

	@Override
	public Course addCourse(Course course) {
		// TODO Auto-generated method stub
	//	list.add(course);
		
		courseDao.save(course);
		return course;
	}

	@Override
	public void deleteById(long cid) {
		courseDao.deleteById(cid);
		
	}

	@Override
	public void updateCourse(Course course, long cid) {
		course.setId(cid);
		courseDao.save(course);
		
	}

	

	

}
