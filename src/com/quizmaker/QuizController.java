//QuizController
//Vidhvat Anand
//5/9/2019
//Controller for inputting questions and answers

package com.quizmaker;

import javax.swing.*;
import java.awt.event.*;

public class QuizController extends Object implements ActionListener 
{
  //model linked to the controller
  private QuizModel quiz;
  
  //components linked to the controller
  private JTextField title = new JTextField();
  private JTextField rightAnswer = new JTextField();
  private JTextField question = new JTextField(); 
  private JTextField answer1 = new JTextField();
  private JTextField answer2 = new JTextField();
  private JTextField answer3 = new JTextField();
  
  //constructor
  //links components to model
  //@para model       model for quiz
  //@para question    user inputted question that has multiple answers to chose form
  //@para answer1     first choice to user inputted question
  //@para answer2     second choice to user inputted question
  //@para answer3     third choice to user inputted question
  public QuizController(QuizModel quiz, JTextField title, JTextField rightAnswer, JTextField question, JTextField answer1, JTextField answer2, JTextField answer3)
  {
    super();
    this.quiz = quiz;
    this.title = title;
    this.rightAnswer = rightAnswer;
    this.question = question;
    this.answer1 = answer1;
    this.answer2 = answer2;
    this.answer3 = answer3;
  }
  
  //allows user to input the question and answers
  public void actionPerformed(ActionEvent e)
  {
    //variable delcaration
    String question; //question to be answered
    String answer1; //first choice 
    String answer2; //second choice
    String answer3; //third choice
    if ((e.getActionCommand()).equals("Next"))
    {
      this.quiz.doNext(this.title,this.rightAnswer,this.question,this.answer1,this.answer2,this.answer3);
    }
    if ((e.getActionCommand()).equals("Main Menu"))
    {
      askToSave();
      this.quiz.getMenu();
    }
    if ((e.getActionCommand()).equals("Upload Picture"))
    {
      this.quiz.uploadPictures();
    }
    if ((e.getActionCommand()).equals("Close"))
    {
      this.quiz.getMenu();
    }
    if ((e.getActionCommand()).equals("Done"))
    {
      this.quiz.createQuiz(this.title,this.rightAnswer,this.question,this.answer1,this.answer2,this.answer3);
    }
  }
  public void askToSave()
  {
    String answer = Prompt.getString("Would you like to save this? (y/n)");
    if (answer.equals("y"))
    {
      this.quiz.createQuiz(this.title,this.rightAnswer,this.question,this.answer1,this.answer2,this.answer3);
    }
    else
    {
      this.quiz.getMenu();
    }
  }
}