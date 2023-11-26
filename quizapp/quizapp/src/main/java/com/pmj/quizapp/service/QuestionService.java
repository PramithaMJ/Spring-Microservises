package com.pmj.quizapp.service;

import com.pmj.quizapp.dao.QuestionDao;
import com.pmj.quizapp.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
//    public String updateQuestion(int questionId,Question question) {
//        questionDao.findAllById(questionId) {
//            questionDao.save(question);
//
//        }
//        return "updated";
//    }

    public String updateQuestion(int questionId, Question updatedQuestion) {
        Optional<Question> existingQuestionOptional = questionDao.findById(questionId);

        if (((Optional<?>) existingQuestionOptional).isPresent()) {
            Question existingQuestion = existingQuestionOptional.get();

            // Update the fields of the existing question with the values from the updatedQuestion
            existingQuestion.setCategory(updatedQuestion.getCategory());
            existingQuestion.setDifficultylevel(updatedQuestion.getDifficultylevel());
            existingQuestion.setOption1(updatedQuestion.getOption1());
            existingQuestion.setOption2(updatedQuestion.getOption2());
            existingQuestion.setOption3(updatedQuestion.getOption3());
            existingQuestion.setOption4(updatedQuestion.getOption4());
            existingQuestion.setQuestionTitle(updatedQuestion.getQuestionTitle());
            existingQuestion.setRightAnswer(updatedQuestion.getRightAnswer());

            // Save the updated question
            questionDao.save(existingQuestion);

            return "updated";
        } else {
            return "Question not found";
        }
    }

}

