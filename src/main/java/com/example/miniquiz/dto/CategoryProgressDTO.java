package com.example.miniquiz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategoryProgressDTO {
    private Long id;
    private String name;
    private int totalQuestions;
    private int correctAnswers;
}