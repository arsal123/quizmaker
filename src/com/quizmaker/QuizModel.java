package com.quizmaker;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class QuizModel
{
  private QuizGUI quizView;
  
  private String titleText;
  private String correctAnswer;
  private String firstAnswer;
  private String secondAnswer;
  private String thirdAnswer;
  private String fourthAnswer;
  private PrintWriter out = new PrintWriter(Prompt.printWriter("File.txt"));
  
  public QuizModel()
  {
    super();
  }
  
  public void setGUI(QuizGUI currentGUI)
  {
    this.quizView = currentGUI;
  }
  
  public void createQuiz(JTextField title, JTextField rightAnswer, JTextField answer,JTextField answer1,JTextField answer2,JTextField answer3)
  {
    doNext(title, rightAnswer, answer, answer1, answer2, answer3);
    out.close();
    getMenu();
  }
  public void clear()
  {
    this.quizView.update();
  }
  public void getMenu()
  {
    QuizMaker.getMain(QuizMaker.f);
  }
  public void uploadPictures()
  {
    JFileChooser chooser = new JFileChooser();
    chooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
    int result = chooser.showOpenDialog(null);
    if (result == JFileChooser.APPROVE_OPTION)
    {  
      JComponent imageComp = new ImageComponent(chooser.getSelectedFile().getPath());
      PrintWriter out = new PrintWriter(Prompt.printWriter("Picture.txt"));
      out.print(imageComp);
      out.close();
    }
  }
  public void doNext(JTextField title, JTextField rightAnswer, JTextField answer,JTextField answer1,JTextField answer2,JTextField answer3)
  {
    this.titleText = title.getText();
    this.correctAnswer = rightAnswer.getText();
    this.firstAnswer = answer.getText();
    this.secondAnswer = answer1.getText();
    this.thirdAnswer = answer2.getText();
    this.fourthAnswer = answer3.getText();
    
    out.println(this.titleText);
    out.println(this.correctAnswer);
    out.println(this.firstAnswer);
    out.println(this.secondAnswer);
    out.println(this.thirdAnswer);
    out.println(this.fourthAnswer);
    this.clear();
  }
}