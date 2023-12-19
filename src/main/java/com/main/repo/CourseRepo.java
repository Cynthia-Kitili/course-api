package com.main.repo;

import com.main.model.CourseModel;
import com.main.model.TopicModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepo extends CrudRepository<CourseModel, String> {
    public List<CourseModel> findByTopicModel_Id(String topicId);

}
