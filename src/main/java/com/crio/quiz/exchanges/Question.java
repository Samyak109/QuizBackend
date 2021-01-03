package com.crio.quiz.exchanges;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NonNull;

import java.util.List;
import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Question {

    @NonNull
    private String questionId;

    @NonNull
    private String title;

    @NonNull
    private String description;

    @NonNull
    private String type;

    private Map<String,String> options;
    private List<String> correctAnswer;
    private String explanation;
}
