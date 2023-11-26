package com.pmj.questionservice.service;

import com.pmj.questionservice.dao.QuestionDao;
import com.pmj.questionservice.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;
    public ResponseEntity<List<Question>> getAllQuestions() {
        try{
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getQuestionByCategory(String category) {
        try {
            return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK) ;
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.OK) ;
    }

    public ResponseEntity<String> addQuestion(Question question) {
        questionDao.save(question);
        return new ResponseEntity<>("saved",HttpStatus.CREATED);
    }

    public ResponseEntity<String> deleteQuestion(int questionId) {
        questionDao.deleteById(questionId);
        return new ResponseEntity<>("deleted",HttpStatus.OK);
    }

  /*
  public String updateQuestion(int questionId,Question question) {
        questionDao.findAllById(questionId) {
            questionDao.save(question);

        }
        return "updated";
    }
    */

    public ResponseEntity<String> updateQuestion(int questionId, Question updatedQuestion) {
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

            return new ResponseEntity<>("updated",HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Question not found",HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<List<Integer>> getQuestionsForQuiz(String categoryName, Integer numQuestions) {
        List<Integer> questions = questionDao.findRandomQuestionByCategory(categoryName,numQuestions);

      return new ResponseEntity<>(questions,HttpStatus.OK);
    }
}

