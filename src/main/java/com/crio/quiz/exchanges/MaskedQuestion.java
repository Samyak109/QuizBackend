package com.crio.quiz.exchanges;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NonNull;

import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MaskedQuestion {

    @NonNull
    private String questionId;

    @NonNull
    private String title;

    @NonNull
    private String type;

    private Map<String,String> options;
}
