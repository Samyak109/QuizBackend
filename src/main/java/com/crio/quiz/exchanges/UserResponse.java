package com.crio.quiz.exchanges;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
public class UserResponse {
    private String questionId;
    private List<String> userResponse;
}
