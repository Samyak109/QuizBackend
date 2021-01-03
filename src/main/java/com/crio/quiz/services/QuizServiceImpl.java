package com.crio.quiz.services;

import com.crio.quiz.exchanges.*;
import com.crio.quiz.models.QuestionEntity;
import com.crio.quiz.respositoryservices.QuestionRepositoryService;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;

import org.modelmapper.ModelMapper;

import javax.inject.Provider;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class QuizServiceImpl implements QuizService{
    @Autowired
    QuestionRepositoryService questionRepositoryService;

    @Autowired
    private Provider<ModelMapper> modelMapperProvider;

    @Override
    public GetQuestionsResponse getQuestions(String moduleId) {
        List<QuestionEntity> questionEntities = questionRepositoryService.findAllQuestionsByModuleId(moduleId);
        List<MaskedQuestion> maskedQuestions = modelMapperProvider.get().map(questionEntities,
                new TypeToken<List<MaskedQuestion>>(){}.getType()) ;
        GetQuestionsResponse getQuestionsResponse = new GetQuestionsResponse();
        getQuestionsResponse.setQuestionList(maskedQuestions);
        return getQuestionsResponse;
    }

    @Override
    public void putQuestions(String moduleId, List<Question> questionList) {
        List<QuestionEntity> entities = questionList.stream().map(question -> {
            return QuestionEntity.builder()
                    .correctAnswer(question.getCorrectAnswer())
                    .description(question.getDescription())
                    .questionId(question.getQuestionId())
                    .explanation(question.getExplanation())
                    .options(question.getOptions())
                    .title(question.getTitle())
                    .type(question.getType())
                    .build();
        }).collect(Collectors.toList());
        questionRepositoryService.saveQuestions(entities);
    }

    @Override
    public ValidateAnswersResponse validateAnswers(String moduleId, ValidateAnswersRequest validateAnswersRequest) {
        //user response list qid->userresponse
        // get question entity , see correct answer map with question id
        List<QuestionEntity> questionList = questionRepositoryService.findAllQuestionsByModuleId(moduleId);
        Map<String, QuestionEntity> questionEntityMap = new HashMap<>();
        for (QuestionEntity questionEntity:questionList) {
            questionEntityMap.put(questionEntity.getQuestionId(),questionEntity);
        }
        List<UserResponse> userResponseList = validateAnswersRequest.getUserResponseList();
        List<ValidatedQuestion> validatedAnswers = userResponseList.stream().map(userResponse ->
        this.validateAnswer(userResponse,questionEntityMap.get(userResponse.getQuestionId())))
        .collect(Collectors.toList());
        return null;
    }

    private ValidatedQuestion validateAnswer(UserResponse userResponse, QuestionEntity questionEntity) {
        ValidatedQuestion validatedQuestion = ValidatedQuestion.builder()
                .answerCorrect(false)
                .description(questionEntity.getDescription())
                .explanation(questionEntity.getExplanation())
                .options(questionEntity.getOptions())
                .questionId(questionEntity.getQuestionId())
                .title(questionEntity.getTitle())
                .type(questionEntity.getType())
                .userAnswer(userResponse.getUserResponse())
                .correct(questionEntity.getCorrectAnswer())
                .build();
        String type = questionEntity.getType();
        switch (type) {
            case "objective-single" :
            case  "objective-multiple" :
                Collections.sort(userResponse.getUserResponse());
                Collections.sort(questionEntity.getCorrectAnswer());
                validatedQuestion.setAnswerCorrect(questionEntity.getCorrectAnswer()
                        .equals(userResponse.getUserResponse()));
                break;
            default:
                validatedQuestion.setAnswerCorrect(true);
        }
        return  validatedQuestion;

    }
}