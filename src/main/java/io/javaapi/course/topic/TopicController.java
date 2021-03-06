package io.javaapi.course.topic;

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
public class TopicController {
	//it is the api
	
	// this annotation is used for dependency injection
	@Autowired
	private TopicService topicService;

	// get all topics
	@RequestMapping(value = "/Topics", method = RequestMethod.GET)
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}

	// get a certain topic
	@RequestMapping(value = "/Topics/{id}", method = RequestMethod.GET)
	public Topic getTopic(@PathVariable String id) {
		return topicService.getTopic(id);

	}

	// add a certain topic read from body
	@RequestMapping(value = "/Topics", method = RequestMethod.POST)
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);

	}

	// update a certain topic read from body
	@RequestMapping(value = "/Topics/{id}", method = RequestMethod.PUT)
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		topicService.updateTopic(id, topic);

	}

	// delete a certain topic
	@RequestMapping(value = "/Topics/{id}", method = RequestMethod.DELETE)
	public void deleteTopic(@PathVariable String id) {
		topicService.deleteTopic(id);

	}

}
