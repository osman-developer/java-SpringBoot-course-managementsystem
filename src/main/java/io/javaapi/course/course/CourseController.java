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
import io.javaapi.course.topic.Topic;

@RestController
public class CourseController {
	// it is the api

	// this annotation is used for dependency injection
	@Autowired
	private CourseService courseService;

	// get all courses
	@RequestMapping(value = "/topics/{id}/courses", method = RequestMethod.GET)
	public List<Course> getAllCourses(@PathVariable String id) {
		return courseService.getAllCourses(id);
	}

	// get a certain course
	@RequestMapping(value = "/topics/{topicId}/courses/{id}", method = RequestMethod.GET)
	public Course getCourse(@PathVariable String id) {
		return courseService.getCourse(id);

	}

	// get a certain course by name
	@RequestMapping(value = "/topics/{topicId}/courses/{name}", method = RequestMethod.GET)
	public Course getCourseByName(@PathVariable String name) {
		return courseService.getCourseByName(name);

	}

	@RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.addCourse(course);

	}

	// update a certain course read from body
	@RequestMapping(value = "/topics/{topicId}/courses/{id}", method = RequestMethod.PUT)
	public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String id) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.updateCourse(course);

	}

	// delete a certain course
	@RequestMapping(value = "/topics/{topicId}/courses/{id}", method = RequestMethod.DELETE)
	public void deleteCourse(@PathVariable String id) {
		courseService.deleteCourse(id);

	}

}
