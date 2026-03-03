package com.example.miniquiz.repository;

import com.example.miniquiz.model.UserAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface UserAnswerRepository extends JpaRepository<UserAnswer, Long> {
    List<UserAnswer> findByQuestionIdIn(List<Long> questionIds);
    Optional<UserAnswer> findByQuestionIdAndCorrect(Long questionId, boolean correct);
}