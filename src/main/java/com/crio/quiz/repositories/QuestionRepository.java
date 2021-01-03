package com.crio.quiz.repositories;

import com.crio.quiz.models.QuestionEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends MongoRepository<QuestionEntity,String> {
    List<QuestionEntity> findByModuleId(String moduleId);
}
