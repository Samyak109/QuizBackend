package com.crio.quiz.exchanges;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ValidateAnswersResponse {
    private List<ValidatedQuestion> validatedQuestions;
    private ValidationSummary validationSummary;
}
