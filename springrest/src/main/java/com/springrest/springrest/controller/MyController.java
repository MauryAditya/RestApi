package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseService;

@RestController
public class MyController {
	@Autowired
	private CourseService courseService;
	
//	@GetMapping("/home")
//	public String home() {
//		return "This is the page";
//	} 
	
	//get the course
	
	@GetMapping("/courses")
	public List<Course> getCourses(){
		
		return this.courseService.getCourses();
	}
	
	//Get Single Course
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		
		return this.courseService.getCourse(Long.parseLong(courseId));
	}
	
	
	//add course
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course ) {
		return this.courseService.addCourse(course);
		
	}
	
	//delete the course
	@DeleteMapping("/deleteBooks/{cid1}")
	public String deleteBook(@PathVariable("cid1") long cid) {
		courseService.deleteById(cid);
	
		return "the id of deleted course is :"+cid;
	}
	
	//Updating Course
	@PutMapping("/updateBook/{cid}")
	public String UpdateBooks(@RequestBody Course course,@PathVariable("cid") long cid) {
		courseService.updateCourse(course, cid);
		return "updated course id is :"+cid+" "+"After update course is:"+course;
	}

}
