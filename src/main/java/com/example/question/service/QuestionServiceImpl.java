package com.example.question.service;


import com.example.question.form.Question;
import com.example.question.repository.QuestionRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class QuestionServiceImpl implements QuestionService {

    private QuestionRepository questionRepository;

    public void setQuestionRepo(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }


    @Override
    @Transactional
    public void addQuestion(Question question) {
        this.questionRepository.addQuestion(question);
    }

    @Override
    @Transactional
    public void updateQuestion(Question question) {
        this.questionRepository.updateQuestion(question);
    }

    @Override
    @Transactional
    @Cacheable("question")
    public Question getQuestionById(Long id) {
        return this.questionRepository.getQuestionById(id);
    }

    @Override
    @Transactional
    @CacheEvict("question")
    public void delete(Long id) {
        this.questionRepository.delete(id);
    }
}
