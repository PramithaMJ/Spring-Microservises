package com.pmj.quizapp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data // Lombok annotation to generate getters, setters, constructors, toString, hash, equals, etc.
@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int questionId;

    private String category;

    private String difficultylevel;

    private String option1;

    private String option2;

    private String option3;

    private String option4;

    private String questionTitle;

    private String rightAnswer;

}
