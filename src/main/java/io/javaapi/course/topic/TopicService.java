package io.javaapi.course.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	// it will inject topicrepo in topicservice instance

	public List<Topic> getAllTopics() {
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}

	public Topic getTopic(String id) {
		return topicRepository.findById(id).orElse(null);

	}

	public void addTopic(Topic topic) {
		topicRepository.save(topic);

	}

	public void updateTopic(String id, Topic topic) {
		topicRepository.save(topic); // it will check if it has the id, if yes it updates it

	}

	public void deleteTopic(String id) {
		topicRepository.deleteById(id);

	}
}
