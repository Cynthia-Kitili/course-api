package com.main.service;

import com.main.model.TopicModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TopicServiceInterface {
    public List<TopicModel> getAllTopics ();

    public TopicModel getTopic(String id);

    public void addTopic(TopicModel topicModel);
    public void updateTopic(TopicModel topicModel, String id);

    public void deleteTopic(String id);
}
