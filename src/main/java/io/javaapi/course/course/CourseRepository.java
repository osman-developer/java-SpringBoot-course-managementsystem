package io.javaapi.course.course;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course,String> {
	// it is the DALC
	// a built in crud operations

}
