package com.quizmaker;

import javax.swing.*;
import java.awt.event.*;

public class MenuController extends Object implements ActionListener 
{
  private MainModel menuView;
  
  public MenuController(MainModel menu)
  {
    super();
    this.menuView = menu;
  }
  
  //allows user to input the question and answers
  public void actionPerformed(ActionEvent e)
  {
    if ((e.getActionCommand()).equals("Menu"))
    {
      QuizMaker.getMenu(QuizMaker.f);
    }
    if ((e.getActionCommand()).equals("Play"))
    {
      QuizMaker.getQuiz(QuizMaker.f);
    }
    if ((e.getActionCommand()).equals("Create"))
    {
      this.menuView.restart();
      QuizMaker.getCreate(QuizMaker.f);
    }
  }
}
