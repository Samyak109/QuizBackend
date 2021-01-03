package com.crio.quiz.exchanges;

import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
public class GetQuestionsResponse {
    private List<MaskedQuestion> questionList;
}
