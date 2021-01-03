package com.crio.quiz.respositoryservices;

import com.crio.quiz.models.QuestionEntity;
import com.crio.quiz.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class QuestionRepositoryServiceImpl implements QuestionRepositoryService {
    @Autowired
    QuestionRepository questionRepository;
    @Override
    public List<QuestionEntity> findAllQuestionsByModuleId(String moduleId) {
        return questionRepository.findByModuleId(moduleId);
    }

    @Override
    public void saveQuestions(List<QuestionEntity> entities) {
        questionRepository.saveAll(entities);
    }
}
