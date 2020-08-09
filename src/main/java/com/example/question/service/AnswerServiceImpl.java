package com.example.question.service;

import com.example.question.form.Answer;
import com.example.question.repository.AnswerRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceImpl implements AnswerService{

    private AnswerRepository answerRepository;

    public void setAnswerRepository(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    @Override
    public void addAnswer(Answer answer) {
        this.answerRepository.addAnswer(answer, answerRepository.setQId()); //не верно! еще не создан вопрос
        // и не известен его ИД
    }

    @Override
    public void updateAnswer(Answer answer) {
        this.answerRepository.updateAnswer(answer,answerRepository.setQId());
    }

    @Override
    @Cacheable("answer")
    public Answer getAnswerById(Long id) {
        return this.answerRepository.getAnswerById(id);
    }

    @Override
    @CacheEvict("answer")
    public void delete(Long id) {
        this.answerRepository.removeAnswer(id); // учесть каскадное удаление отсюда
    }

    @Override
    public void setRightAnswer(Long id) {
        this.answerRepository.setRightAnswer(id); //установка верного варианта ответа по ИД ответа
    }
}
