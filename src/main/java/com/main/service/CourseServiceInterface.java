package com.main.service;


import com.main.model.CourseModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseServiceInterface {
    public List<CourseModel> getAllCourses (String id);

    public CourseModel getCourse(String id);

    public void addCourse(CourseModel courseModel);
    public void updateCourse(CourseModel courseModel);

    public void deleteCourse(String id);
}
