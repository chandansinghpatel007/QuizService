package com.quiz.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.entities.Quiz;
import com.quiz.sevices.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {
	
	private QuizService quizService;

	public QuizController(QuizService quizService) {
		super();
		this.quizService = quizService;
	}
	
	//Create
	@PostMapping
	private Quiz createQuiz(@RequestBody Quiz quiz) {
		return quizService.add(quiz);
	}

	//Get All
	@GetMapping
	private List<Quiz> getQuizs(){
		return quizService.getQuizs();
	}
	
	//Get By ID
	@GetMapping("/{id}")
	private Quiz getQuiz(@PathVariable Long id){
		return quizService.getQuiz(id);
	}
}
