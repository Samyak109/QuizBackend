package com.crio.quiz.respositoryservices;

import com.crio.quiz.models.QuestionEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuestionRepositoryService {
    List<QuestionEntity> findAllQuestionsByModuleId(String moduleId);

    void saveQuestions(List<QuestionEntity> entities);

}
