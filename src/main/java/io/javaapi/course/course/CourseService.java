package io.javaapi.course.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class CourseService {
	// it is the BLC
	@Autowired
	private CourseRepository courseRepository;
	// it will inject topicrepo in topicservice instance

	public List<Course> getAllCourses(String id) {
		List<Course> courses = new ArrayList<>();
		courseRepository.findAll().forEach(courses::add);
		return courses;
	}

	public Course getCourse(String id) {
		return courseRepository.findById(id).orElse(null);

	}

	public Course getCourseByName(String name) {
		return (Course) courseRepository.findByName(name);

	}

	public void addCourse(Course course) {
		courseRepository.save(course);

	}

	public void updateCourse(Course course) {
		courseRepository.save(course); // it will check if it has the id, if yes it updates it

	}

	public void deleteCourse(String id) {
		courseRepository.deleteById(id);

	}
}
