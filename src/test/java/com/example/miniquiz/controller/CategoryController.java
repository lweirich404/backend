package com.example.miniquiz.controller;

import com.example.miniquiz.dto.CategoryProgressDTO;
import com.example.miniquiz.service.CategoryService;
import com.example.miniquiz.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    private final QuestionService questionService;

    @GetMapping
    public List<CategoryProgressDTO> getAllCategories() {
        return categoryService.getAllCategoriesWithProgress();
    }

    @GetMapping("/{id}/next-question")
    public ResponseEntity<?> getNextQuestion(@PathVariable Long id) {
        return questionService.getNextQuestion(id)
            .<ResponseEntity<?>>map(ResponseEntity::ok)
            .orElse(ResponseEntity.ok(
                Map.of("message", "🏆 Alle Fragen dieser Kategorie richtig beantwortet!")
            ));
    }
}