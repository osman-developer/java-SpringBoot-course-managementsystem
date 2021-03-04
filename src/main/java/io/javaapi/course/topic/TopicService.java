package io.javaapi.course.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class TopicService {
	// when you add = new arraylist so it's mutable now so you can add to it, if
	// don't do = new arraylist you will not be able to add to it

	@Autowired
	private TopicRepository topicRepository;
	// it will inject topicrepo in topicservice instance

	private List<Topic> topics = new ArrayList<>(
			Arrays.asList(new Topic("spring", "java springboot", "java springboot description"),
					new Topic("javascript", "javascriot", "javascriot description")));

	public List<Topic> getAllTopics() {
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}

	public Topic getTopic(String id) {
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		
		return topicRepository.findById(id).orElse(null);
	
	}

	public void addTopic(Topic topic) {
		topicRepository.save(topic);

	}

	public void updateTopic(String id, Topic topic) {
		for (int i = 0; i < topics.size(); i++) {
			Topic t = topics.get(i);
			if (t.getId().equals(id)) {
				topics.set(i, topic);
				return;
			}

		}

	}

	public void deleteTopic(String id) {
		topics.removeIf(t -> t.getId().equals(id));

	}
}
