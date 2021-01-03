package com.crio.quiz.controller;

import com.crio.quiz.exchanges.Question;
import com.crio.quiz.exchanges.ValidateAnswersRequest;
import com.crio.quiz.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(QuizController.QUIZ_API_ENDPOINT)
public class QuizController {
    public static final String QUIZ_API_ENDPOINT = "/quiz/{moduleId}";

    @Autowired
    QuizService quizService;

    @GetMapping
    public ResponseEntity getQuestions(@PathVariable String moduleId) {
        return ResponseEntity.ok().body(quizService.getQuestions(moduleId));
    }

    @PostMapping
    public ResponseEntity validateAnswers(@PathVariable String moduleId, @RequestBody ValidateAnswersRequest validateAnswersRequest) {
        return ResponseEntity.ok().body(quizService.validateAnswers(moduleId, validateAnswersRequest));
    }

    @PutMapping
    public ResponseEntity putQuestions(@PathVariable String moduleId, List<Question> questionList) {
        quizService.putQuestions(moduleId,questionList);
        return ResponseEntity.ok().build();
    }

}
