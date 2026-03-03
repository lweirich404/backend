package com.example.miniquiz.service;

import com.example.miniquiz.dto.AnswerResultDTO;
import com.example.miniquiz.dto.QuestionDTO;
import com.example.miniquiz.model.Question;
import com.example.miniquiz.model.UserAnswer;
import com.example.miniquiz.repository.QuestionRepository;
import com.example.miniquiz.repository.UserAnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final UserAnswerRepository userAnswerRepository;

    public Optional<QuestionDTO> getNextQuestion(Long categoryId) {
        var questions = questionRepository.findByCategoryId(categoryId);

        for (Question q : questions) {
            boolean alreadyAnswered = userAnswerRepository.existsByQuestionId(q.getId());
                System.out.println("Frage id=" + q.getId() + " alreadyAnswered=" + alreadyAnswered); 

            if (!alreadyAnswered) {
                return Optional.of(new QuestionDTO(
                    q.getId(),
                    q.getQuestionText(),
                    List.of(q.getOption0(), q.getOption1(), q.getOption2(), q.getOption3())
                ));
            }
        }
        return Optional.empty();
    }

    public AnswerResultDTO answerQuestion(Long questionId, int selectedIndex) {
        var question = questionRepository.findById(questionId)
            .orElseThrow(() -> new RuntimeException("Frage nicht gefunden"));

        boolean correct = question.getCorrectIndex() == selectedIndex;

        boolean alreadyAnswered = userAnswerRepository.existsByQuestionId(questionId);

        if (!alreadyAnswered) {
            userAnswerRepository.save(new UserAnswer(null, questionId, correct));
        }

        return new AnswerResultDTO(correct,
            correct ? "Richtig! 🎉" : "Leider falsch. Versuch es nochmal!");
    }
}