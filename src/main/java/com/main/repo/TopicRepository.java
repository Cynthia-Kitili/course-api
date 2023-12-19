package com.main.repo;

import com.main.model.TopicModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends CrudRepository<TopicModel, String> {

}
