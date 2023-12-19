package com.main.service.serviceImplementation;

import com.main.model.TopicModel;
import com.main.repo.TopicRepository;
import com.main.service.TopicServiceInterface;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TopicServiceImpl implements TopicServiceInterface {
    private TopicRepository topicRepository;
    public TopicServiceImpl(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }
    @Override
    public List<TopicModel> getAllTopics() {
        List<TopicModel> topicModels = new ArrayList<>();
        topicRepository.findAll()
        .forEach(topicModels::add);
        return topicModels;
    }

    @Override
    public TopicModel getTopic(String id) {
        Optional<TopicModel> topicModelOptional = topicRepository.findById(id);
        return topicModelOptional.orElseThrow(
                () -> new NoSuchElementException("Topic not found with id: " + id));
    }

    @Override
    public void addTopic(TopicModel topicModel) {
        topicRepository.save(topicModel);
    }

    @Override
    public void updateTopic(TopicModel topicModel, String id) {
        topicRepository.save(topicModel);
    }

    @Override
    public void deleteTopic(String id) {
        topicRepository.deleteById(id);
    }
}
