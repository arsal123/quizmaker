package com.quizmaker;
import javax.swing.*;
import java.awt.event.*;

public class TakeController extends Object implements ActionListener 
{
  //model linked to the controller
  private TakeModel quiz;
  private TakeQuiz theView;
  
  //components linked to the controller
  private String answer1 = ""; 
  private String answer2 = "";
  private String answer3 = "";
  private String answer4 = "";
  
  //constructor
  //links components to model
  //@para model       model for quiz
  //@para question    user inputted question that has multiple answers to chose form
  //@para answer1     first choice to user inputted question
  //@para answer2     second choice to user inputted question
  //@para answer3     third choice to user inputted question
  public TakeController(TakeQuiz theView, TakeModel quiz, String answer1, String answer2, String answer3, String answer4)
  {
    super();
    this.theView = theView;
    this.quiz = quiz;
    this.answer1 = answer1;
    this.answer2 = answer2;
    this.answer3 = answer3;
    this.answer4 = answer4;
  }
  
  //allows user to input the question and answers
  public void actionPerformed(ActionEvent e)
  {
    if ((e.getActionCommand()).equals("Next"))
    {
      this.quiz.update();
    }
    if ((e.getActionCommand()).equals("Main Menu"))
    {
      this.quiz.in.close();
      this.quiz.getMenu();
    }
    if ((e.getActionCommand()).equals("Close"))
    {
      this.quiz.in.close();
      this.quiz.getMenu();
    }
    if ((e.getActionCommand()).equals("Done"))
    {
      //this.quiz.createQuiz(this.title,this.rightAnswer,this.question,this.answer1,this.answer2,this.answer3);
    }
    if ((e.getActionCommand()).equals(answer1))
    {
      if (this.quiz.theAnswer==1)
      {
        this.theView.updateLittle("true");
      }
      else
        this.theView.updateLittle("false");
    }
    if ((e.getActionCommand()).equals(answer2))
    {
      if (this.quiz.theAnswer==2)
      {
        this.theView.updateLittle("true");
      }
      else
        this.theView.updateLittle("false");
    }
    if ((e.getActionCommand()).equals(answer3))
    {
      if (this.quiz.theAnswer==3)
      {
        this.theView.updateLittle("true");
      }
      else
        this.theView.updateLittle("false");
    }
    if ((e.getActionCommand()).equals(answer4))
    {
      if (this.quiz.theAnswer==4)
      {
        this.theView.updateLittle("true");
      }
      else
        this.theView.updateLittle("false");
    }
  }
}