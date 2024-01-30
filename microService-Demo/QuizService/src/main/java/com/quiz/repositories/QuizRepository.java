package com.quiz.repositories;

import com.quiz.entites.QuizEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository  extends JpaRepository<QuizEntity, Long> {

}
