package com.quiz.sevices;

import java.util.List;

import com.quiz.entities.Quiz;

public interface QuizService {
	//Adding
	Quiz add(Quiz quiz);
	
	//Getting 
	List<Quiz> getQuizs();
	
	//Get One By ID 
	Quiz getQuiz(Long id);

}
