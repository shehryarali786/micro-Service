package com.quiz.controller;

import com.quiz.entites.QuizEntity;
import com.quiz.services.QuizService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    private QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    //create
    @PostMapping
    public QuizEntity create(@RequestBody QuizEntity quizEntity){
        return quizService.add(quizEntity);
    }

    @GetMapping
    public List<QuizEntity> getAll(){
        return quizService.getAll();
    }

    @GetMapping("/{id}")
    public QuizEntity getById(@PathVariable Long id){
        return quizService.getById(id);
    }
}
