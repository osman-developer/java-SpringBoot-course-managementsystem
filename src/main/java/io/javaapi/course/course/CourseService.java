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
	private CourseRepository topicRepository;
	// it will inject topicrepo in topicservice instance

	public List<Course> getAllTopics() {
		List<Course> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}

	public Course getTopic(String id) {
		return topicRepository.findById(id).orElse(null);

	}

	public void addTopic(Course topic) {
		topicRepository.save(topic);

	}

	public void updateTopic(String id, Course topic) {
		topicRepository.save(topic); // it will check if it has the id, if yes it updates it

	}

	public void deleteTopic(String id) {
		topicRepository.deleteById(id);

	}
}
