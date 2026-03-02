package com.example.miniquiz.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "questions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String questionText;

    private String option0;
    private String option1;
    private String option2;
    private String option3;

    private int correctIndex;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
