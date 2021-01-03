package com.crio.quiz.services;


import com.crio.quiz.exchanges.GetQuestionsResponse;
import com.crio.quiz.exchanges.Question;
import com.crio.quiz.exchanges.ValidateAnswersRequest;
import com.crio.quiz.exchanges.ValidateAnswersResponse;

import java.util.List;

public interface QuizService {
    GetQuestionsResponse getQuestions(String moduleId);
    ValidateAnswersResponse validateAnswers(String moduleId, ValidateAnswersRequest validateAnswersRequest);
    void putQuestions(String moduleId, List<Question> questionList);
}
