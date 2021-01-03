package com.crio.quiz.exchanges;

import java.util.List;
import java.util.Map;

import lombok.*;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Data
public class ValidatedQuestion {

    @NonNull
    private String questionId;
    @NonNull
    private String title;
    @NonNull
    private String description;
    @NonNull
    private String type;
    private Map<String, String> options;
    private List<String> userAnswer;
    private List<String> correct;
    private String explanation;
    private boolean answerCorrect;
}
