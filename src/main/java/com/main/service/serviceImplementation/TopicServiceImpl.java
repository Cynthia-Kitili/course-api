package com.main.service.serviceImplementation;

import com.main.model.TopicModel;
import com.main.service.TopicServiceInterface;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicServiceImpl implements TopicServiceInterface {

    private List<TopicModel> topics = new ArrayList<>(Arrays.asList(
                new TopicModel("spring1","spdhfdh1", "hdhdsjsds"),
                new TopicModel("spring2","spdhfdh2", "hdhdsjsds"),
                new TopicModel("spring3","spdhfdh3", "hdhdsjsds"))
    );


    @Override
    public List<TopicModel> getAllTopics() {
        return topics;
    }

    @Override
    public TopicModel getTopic(String id) {
        return topics.stream()
                .filter (t -> t.getId().equals(id))
                .findFirst().get();
    }

    @Override
    public void addTopic(TopicModel topicModel) {
        topics.add(topicModel);
    }

    @Override
    public void updateTopic(TopicModel topicModel, String id) {
        for(int i = 0;i < topics.size(); i++ ){
            TopicModel t = topics.get(i);
            if(t.getId().equals(id)){
                topics.set(i, topicModel);
                return ;
            }
        }
    }

    @Override
    public void deleteTopic(String id) {
        topics.removeIf(t -> t.getId().equals(id));
    }
}
