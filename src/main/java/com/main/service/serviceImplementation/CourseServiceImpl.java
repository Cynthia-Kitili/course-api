package com.main.service.serviceImplementation;

import com.main.model.CourseModel;
import com.main.model.TopicModel;
import com.main.repo.CourseRepo;
import com.main.service.CourseServiceInterface;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseServiceInterface {
    private CourseRepo courseRepo;
    public CourseServiceImpl(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }
    @Override
    public List<CourseModel> getAllCourses(String topicId) {
        List<CourseModel> courseModels = new ArrayList<>();
        courseRepo.findByTopicModel_Id(topicId)
                .forEach(courseModels::add);
        return courseModels;
    }

    @Override
    public CourseModel getCourse(String id) {
        Optional<CourseModel> courseModelOptional = courseRepo.findById(id);
        return courseModelOptional.orElseThrow(
                () -> new NoSuchElementException("Topic not found with id: " + id));
    }

    @Override
    public void addCourse(CourseModel courseModel) {
        courseRepo.save(courseModel);
    }

    @Override
    public void updateCourse(CourseModel courseModel) {
        courseRepo.save(courseModel);
    }

    @Override
    public void deleteCourse(String id) {
        courseRepo.deleteById(id);
    }
}
