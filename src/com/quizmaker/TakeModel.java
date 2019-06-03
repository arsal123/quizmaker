package com.quizmaker;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class TakeModel
{
  private TakeQuiz quizView;
  public Scanner in = Prompt.getInputScanner("File.txt");
  private String [] stringArray = new String[1000];
  private int x = 0;
  public int theAnswer = 0;
  
  public TakeModel()
  {
    super();
  }
  public void getMenu()
  {
    QuizMaker.getMain(QuizMaker.f);
  }
  public void update()
  {
    this.quizView.update();
  }
  public void stringArray()
  {
    while(in.hasNextLine())
    {
        stringArray[x] = (in.nextLine());
        x++;
    }
  }
  public String wrongAnswer()
  {
    return("Answer: Correct!");
  }
  public String rightAnswer(String answer)
  {
    return("Answer: Incorrect!");
  }
  public void setGUI(TakeQuiz currentGUI)
  {
    this.quizView = currentGUI;
  }
  public String returnTitle(int questionNum)
  {
    return stringArray[0+((questionNum-1)*6)];
  }
  public String returnAnswer(int questionNum)
  {
    return stringArray[1+((questionNum-1)*6)];
  }
  public String returnQuestion1(int questionNum)
  {
    return stringArray[2+((questionNum-1)*6)];
  }
  public String returnQuestion2(int questionNum)
  {
    return stringArray[3+((questionNum-1)*6)];
  }
  public String returnQuestion3(int questionNum)
  {
    return stringArray[4+((questionNum-1)*6)];
  }
  public String returnQuestion4(int questionNum)
  {
    return stringArray[5+((questionNum-1)*6)];
  }
}