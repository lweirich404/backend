package com.example.miniquiz.service;

import com.example.miniquiz.dto.CategoryProgressDTO;
import com.example.miniquiz.model.UserAnswer;
import com.example.miniquiz.repository.CategoryRepository;
import com.example.miniquiz.repository.QuestionRepository;
import com.example.miniquiz.repository.UserAnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final QuestionRepository questionRepository;
    private final UserAnswerRepository userAnswerRepository;

    public List<CategoryProgressDTO> getAllCategoriesWithProgress() {
        return categoryRepository.findAll().stream().map(category -> {
            var questions = questionRepository.findByCategoryId(category.getId());
            var questionIds = questions.stream().map(q -> q.getId()).collect(Collectors.toList());
            var correctAnswers = userAnswerRepository.findByQuestionIdIn(questionIds)
                .stream().filter(UserAnswer::isCorrect).count();

            return new CategoryProgressDTO(
                category.getId(),
                category.getName(),
                questions.size(),
                (int) correctAnswers
            );
        }).collect(Collectors.toList());
    }
}