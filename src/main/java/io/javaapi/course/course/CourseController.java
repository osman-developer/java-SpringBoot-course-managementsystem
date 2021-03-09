package io.javaapi.course.course;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Logger;

@RestController
public class CourseController {
	//it is the api
	
	// this annotation is used for dependency injection
	@Autowired
	private CourseService courseService;

	// get all topics
	@RequestMapping(value = "/topics/{id}/courses", method = RequestMethod.GET)
	public List<Course> getAllCourses(@PathVariable String id) {
		return courseService.getAllCourses(id);
	}

	// get a certain topic
	@RequestMapping(value = "/topics/{topicId}/courses/{id}", method = RequestMethod.GET)
	public Course getCourse(@PathVariable String id) {
		return courseService.getCourse(id);

	}

	// add a certain topic read from body
	@RequestMapping(value = "/topics/{topicId}/courses/{id}", method = RequestMethod.POST)
	public void addCourse(@RequestBody Course course) {
		courseService.addCourse(course);

	}

	// update a certain topic read from body
	@RequestMapping(value = "/Courses/{id}", method = RequestMethod.PUT)
	public void updateCourse(@RequestBody Course course, @PathVariable String id) {
		courseService.updateCourse(id, course);

	}

	// delete a certain topic
	@RequestMapping(value = "/Courses/{id}", method = RequestMethod.DELETE)
	public void deleteCourse(@PathVariable String id) {
		courseService.deleteCourse(id);

	}

}
