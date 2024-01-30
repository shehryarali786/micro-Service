package com.quiz.serviceImpl;

import com.quiz.entites.QuizEntity;
import com.quiz.repositories.QuizRepository;
import com.quiz.services.QuestionClient;
import com.quiz.services.QuizService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {

    private QuizRepository quizRepository;

    private QuestionClient questionClient;


    public QuizServiceImpl(QuizRepository quizRepository, QuestionClient questionClient) {
        this.quizRepository = quizRepository;
        this.questionClient = questionClient;
    }

    @Override
    public QuizEntity add(QuizEntity quizEntity) {
        return quizRepository.save(quizEntity);
    }

    @Override
    public List<QuizEntity> getAll() {
        List<QuizEntity> quizzes= quizRepository.findAll();
       List<QuizEntity> newQuizList= quizzes.stream().map(quiz ->{
            quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getQuizId()));
            return quiz;
        }).collect(Collectors.toList());
        return newQuizList;
    }

    @Override
    public QuizEntity getById(Long id) {
       QuizEntity quizEntity= quizRepository.findById(id).
                orElseThrow(()-> new RuntimeException("Quiz Not Found"));
       quizEntity.setQuestions(questionClient.getQuestionOfQuiz(quizEntity.getQuizId()));
        return quizEntity;
    }
}
