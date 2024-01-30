package com.quiz.services;

import com.quiz.entites.QuizEntity;

import java.util.List;

public interface QuizService {

    QuizEntity add(QuizEntity quizEntity);
    List<QuizEntity> getAll();
    QuizEntity getById(Long id);
}
