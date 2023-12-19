package com.main.controller;

import com.main.model.CourseModel;
import com.main.model.TopicModel;
import com.main.service.CourseServiceInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    private CourseServiceInterface courseServiceInterface;

    public CourseController(CourseServiceInterface courseServiceInterface) {
        this.courseServiceInterface = courseServiceInterface;
    }

    @RequestMapping("/topics/{id}/courses")
    public List<CourseModel> getAllCourses(@PathVariable String id){
        return courseServiceInterface.getAllCourses(id);
    }

    @RequestMapping("/topics/{topicId}/courses/{id}")
    public CourseModel getCourse(@PathVariable String id){
        return courseServiceInterface.getCourse(id);
    }


    @RequestMapping(method = RequestMethod.POST, value= "/topics/{topicId}/courses")
    public void addCourse(@RequestBody CourseModel courseModel,@PathVariable String topicId){
        courseModel.setTopicModel(new TopicModel(topicId, "",""));
        courseServiceInterface.addCourse(courseModel);
    }


    @RequestMapping(method = RequestMethod.PUT, value= "/topics/{topicId}/courses/{id}")
    public void updateCourse(@RequestBody CourseModel courseModel, @PathVariable String id,@PathVariable String topicId){
        courseModel.setTopicModel(new TopicModel(topicId, "",""));
        courseServiceInterface.updateCourse(courseModel);
    }
    @RequestMapping(method = RequestMethod.DELETE , value= "/topics/{topicId}/courses/{id}")
    public void deleteCourse( @PathVariable String id){
        courseServiceInterface.deleteCourse(id);
    }

}
