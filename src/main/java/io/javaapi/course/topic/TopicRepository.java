package io.javaapi.course.topic;

import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic,String> {
	// it is the DALC
	// a built in crud operations

}
