package com.pmj.questionservice.controller;


import com.pmj.questionservice.model.Question;
import com.pmj.questionservice.model.QuestionWrapper;
import com.pmj.questionservice.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;
    @GetMapping("/allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions() ;
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category){
        return questionService.getQuestionByCategory(category);
    }

    @PostMapping("/addQuestion")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }

    @PutMapping("/updateQuestion/{questionId}")
    public ResponseEntity<String> updateQuestion(@PathVariable int questionId,@RequestBody Question question){
        return questionService.updateQuestion(questionId,question);
    }
    @DeleteMapping("/deleteData/{questionId}")
    public ResponseEntity<String> deleteQuestion(@PathVariable int questionId){
        return questionService.deleteQuestion(questionId);
    }

    @GetMapping("/generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz
            (@RequestParam String categoryName,@RequestParam Integer numQuestions){
        return questionService.getQuestionsForQuiz(categoryName, numQuestions);
    }

    @PostMapping("getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionFromId(@RequestBody List<Integer> quesionIds){
        return questionService.getQuestionsFromId(quesionIds);
    }

    // generate
    // getQuestion (questionId)
    // get Score
}
