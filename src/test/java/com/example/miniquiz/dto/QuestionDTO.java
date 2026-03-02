package com.example.miniquiz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class QuestionDTO {
    private Long id;
    private String questionText;
    private List<String> options;
}