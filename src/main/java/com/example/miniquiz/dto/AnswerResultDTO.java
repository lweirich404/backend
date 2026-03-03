package com.example.miniquiz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AnswerResultDTO {
    private boolean correct;
    private String message;
}