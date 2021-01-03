package com.crio.quiz.exchanges;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ValidateAnswersRequest {
    private List<UserResponse> userResponseList;
}
