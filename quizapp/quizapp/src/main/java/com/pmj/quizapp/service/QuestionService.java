package com.pmj.quizapp.service;

import com.pmj.quizapp.dao.QuestionDao;
import com.pmj.quizapp.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;
    public List<Question> getAllQuestions() {
        return questionDao.findAll();
    }


    public List<Question> getQuestionByCategory(String category) {
        return questionDao.findByCategory(category);
    }

    public String addQuestion(Question question) {
        questionDao.save(question);
        return "saved";
    }

    public String deleteQuestion(int questionId) {
        questionDao.deleteById(questionId);
        return "deleted";
    }
    public String updateQuestion(Question question) {
        questionDao.save(question);
        return "updated";
    }

}

