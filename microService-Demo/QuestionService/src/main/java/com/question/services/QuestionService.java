package com.question.services;

import com.question.entities.QuestionEntity;

import java.util.List;

public interface QuestionService {

    QuestionEntity add(QuestionEntity questionEntity);

    List<QuestionEntity> getAll();

    QuestionEntity getById(Long id);

    List<QuestionEntity> findByQuizId(Long quizId);
}
