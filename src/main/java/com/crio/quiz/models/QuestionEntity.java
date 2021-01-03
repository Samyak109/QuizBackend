package com.crio.quiz.models;

import lombok.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Data
@Document(collection = "questions")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class QuestionEntity {
    @Id
    private String id;
    @NonNull
    private String questionId;
    @NonNull
    private String moduleId;
    @NonNull
    private String title;
    @NonNull
    private String description;
    @NonNull
    private String type;
    private Map<String, String> options;
    @NonNull
    private List<String> correctAnswer;
    @NonNull
    private String explanation;

}
