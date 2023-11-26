package com.pmj.quizapp.controller;

import com.pmj.quizapp.entity.Question;
import com.pmj.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;
    @GetMapping("/allQuestions")
    public List<Question> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("/category/{category}")
    public List<Question> getQuestionByCategory(@PathVariable String category){
        return questionService.getQuestionByCategory(category);
    }

    @PostMapping("/addQuestion")
    public String addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }

    @PutMapping("/updateQuestion/{questionId}")
    public String updateQuestion(@PathVariable int questionId,@RequestBody Question question){
        return questionService.updateQuestion(questionId,question);
    }
    @DeleteMapping("/deleteData/{questionId}")
    public String deleteQuestion(@PathVariable int questionId){
        return questionService.deleteQuestion(questionId);
    }
}
