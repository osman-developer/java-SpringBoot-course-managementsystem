package io.javaapi.course.course;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import io.javaapi.course.topic.Topic;

@Entity
public class Course {
	//it is the entity class
	//that's how you tell JPA that this is the primary key
	@Id
	private String id;
	private String name;
	private String description;
	
	@ManyToOne
	private Topic topic;

	
	public Course() {

	}

	public Course(String id, String name, String description,String topicID) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.topic = new Topic(topicID, "", "");
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
