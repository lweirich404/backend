package com.example.miniquiz.controller;

import com.example.miniquiz.dto.AnswerResultDTO;
import com.example.miniquiz.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/questions")
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;

    @PostMapping("/{id}/answer")
    public AnswerResultDTO answerQuestion(
            @PathVariable Long id,
            @RequestBody Map<String, Integer> body) {
        return questionService.answerQuestion(id, body.get("answerIndex"));
    }
}