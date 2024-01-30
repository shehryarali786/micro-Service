package com.question.controller;

import com.question.entities.QuestionEntity;
import com.question.services.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    private QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    //create
    @PostMapping
    public QuestionEntity create(@RequestBody QuestionEntity questionEntity){
        return questionService.add(questionEntity);
    }

    //GetBy id
    @GetMapping("/{id}")
    public QuestionEntity GetById(@PathVariable Long id){
        return questionService.getById(id);
    }

    //getAll
    @GetMapping
    public List<QuestionEntity> getAllQuestions(){
        return questionService.getAll();
    }

    // get Questions of the Quiz
    @GetMapping("/quiz/{quizId}")
    public List<QuestionEntity> getQuestionOfQuiz(@PathVariable Long quizId){
        return questionService.findByQuizId(quizId);
    }
}
