package com.quizmaker;
import com.quizmaker.common.Values;

import javax.swing.*;
import java.awt.event.*;
import java.util.Enumeration;

public class TakeController implements ActionListener
{
  //model linked to the controller
  private TakeModel quiz;
  private TakeQuizView theView ;
  
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
  public TakeController(TakeModel quiz, String answer1, String answer2, String answer3, String answer4)
  {
    super();
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
    if((e.getActionCommand()).equals(Values.CHECK)){
//        Print the sel option
      ButtonGroup buttonGroup = QuizMaker.getTakeQuizView().getButtonGroup();
      Enumeration<AbstractButton> btns = buttonGroup.getElements();
      AbstractButton btn = btns.nextElement();
      ButtonModel sel = QuizMaker.getTakeQuizView().getSelection();
//      System.out.println("VALUE:" + btn.getText());
//      compare it with the right option
//      display output in the answer
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