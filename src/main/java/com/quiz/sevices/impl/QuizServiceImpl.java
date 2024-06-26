package com.quiz.sevices.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.quiz.entities.Quiz;
import com.quiz.repositories.QuizRepository;
import com.quiz.sevices.QuestionClient;
import com.quiz.sevices.QuizService;

@Service
public class QuizServiceImpl implements QuizService{
	
	private QuizRepository quizRepository;
	private QuestionClient questionClient;

	public QuizServiceImpl(QuizRepository quizRepository, QuestionClient questionClient) {
		super();
		this.quizRepository = quizRepository;
		this.questionClient = questionClient;
	}

	@Override
	public Quiz add(Quiz quiz) {
		return quizRepository.save(quiz);
	}

	@Override
	public List<Quiz> getQuizs() {
		List<Quiz> quizs= quizRepository.findAll();
		
		List<Quiz> newQuizs=quizs.stream().map(quiz ->{
		quiz.setQuestions(questionClient.getQuestionsOfQuiz(quiz.getQuizId()));
		return quiz;
		}).collect(Collectors.toList());
		
		return newQuizs;		
	}

	@Override
	public Quiz getQuiz(Long id) {
		Quiz quiz= quizRepository.findById(id).orElseThrow(()-> new RuntimeException("Quez not found"));
		quiz.setQuestions(questionClient.getQuestionsOfQuiz(quiz.getQuizId()));
		return quiz;
	}

}
