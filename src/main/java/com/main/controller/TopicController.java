package com.main.controller;

import com.main.model.TopicModel;
import com.main.service.TopicServiceInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {
    private TopicServiceInterface topicServiceInterface;

    public TopicController(TopicServiceInterface topicServiceInterface) {
        this.topicServiceInterface = topicServiceInterface;
    }

    @RequestMapping("/topics")
    public List<TopicModel> getAllTopics(){
        return topicServiceInterface.getAllTopics();
    }

    @RequestMapping("/topics/{id}")
    public TopicModel getTopic(@PathVariable String id){
        return topicServiceInterface.getTopic(id);
    }
    @RequestMapping(method = RequestMethod.POST, value= "/topics")
    public void addTopic(@RequestBody TopicModel topicModel){
        topicServiceInterface.addTopic(topicModel);
    }
    @RequestMapping(method = RequestMethod.PUT, value= "/topics/{id}")
    public void updateTopic(@RequestBody TopicModel topicModel, @PathVariable String id){
        topicServiceInterface.updateTopic(topicModel, id);
    }
    @RequestMapping(method = RequestMethod.DELETE , value= "/topics/{id}")
    public void deleteTopic( @PathVariable String id){
        topicServiceInterface.deleteTopic(id);
    }

}
