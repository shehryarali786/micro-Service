package com.question.serviceImpl;

import com.question.entities.QuestionEntity;
import com.question.repositories.QuestionRepository;
import com.question.services.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl  implements QuestionService {

   private QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public QuestionEntity add(QuestionEntity questionEntity) {
        return questionRepository.save(questionEntity);
    }

    @Override
    public List<QuestionEntity> getAll() {
        return questionRepository.findAll();
    }

    @Override
    public QuestionEntity getById(Long id) {
        return questionRepository.findById(id).orElseThrow(()-> new RuntimeException("Question not found"));
    }

    @Override
    public List<QuestionEntity> findByQuizId(Long quizId) {
        return questionRepository.findByQuizId(quizId);
    }
}
