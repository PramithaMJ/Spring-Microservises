package com.pmj.quizapp.dao;

import com.pmj.quizapp.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

}
