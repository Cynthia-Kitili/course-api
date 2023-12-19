package com.main.model;

import jakarta.persistence.*;

@Entity
public class CourseModel {

    @Id
    protected String id;
    protected String name;
    protected String description;

    @ManyToOne
    protected TopicModel topicModel;

    public TopicModel getTopicModel() {
        return topicModel;
    }

    public void setTopicModel(TopicModel topicModel) {
        this.topicModel = topicModel;
    }

    public CourseModel() {
    }

    public CourseModel(String id, String name, String description,String topicId) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.topicModel = new TopicModel(topicId, "","");
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
