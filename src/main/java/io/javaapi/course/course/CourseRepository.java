package io.javaapi.course.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course,String> {
	// it is the DALC
	// a built in crud operations
	//you can add how the method looks like and JPA will implement it, it sounds crazy
	//since interface so abstract method
	//custom find method should start with Find
	
	//this is a custom method to find courses by name, JPA is smart enough to read it and know what you want
	public List<Course> findByName(String topicId);
}
