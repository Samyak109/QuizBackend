package com.crio.quiz.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Question {
    private String questionId;
    private String title;
    private String description;
    private String type;
    private List<String> options;
    private List<String> correctAnswer;
}
