package com.quizmaker;
import javax.swing.*;

public class QuizMaker
{
  public static JFrame f = new JFrame("QuizMaker");
  static TakeModel quizModel = new TakeModel();
  static TakeQuizView quizGui = new TakeQuizView(quizModel);

  public static void main(String[] args)
  {
//    makeQuizModel();
    getQuiz(f);
  }

  public static void makeQuizModel() {
    QuizModel quizModel = new QuizModel();
    QuizGUI quizGui = new QuizGUI(quizModel);
    f.setContentPane(quizGui);
    f.setVisible(true);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setSize(900,600);
  }

  public static void getMain(JFrame f)
  {
    MainModel menu = new MainModel();
    MainMenu menuGUI = new MainMenu(menu);
    f.setContentPane(menuGUI);
    f.setVisible(true);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setSize(900,600);
  }
  public static void getCreate(JFrame f)
  {
    QuizModel quizModel = new QuizModel();
    QuizGUI quizGui = new QuizGUI(quizModel);
    f.setContentPane(quizGui);
    f.setVisible(true);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setSize(900,600);
  }

  public static void getMenu(JFrame f)
  {
  }
  public static void getQuiz(JFrame f)
  {

    f.setContentPane(quizGui);
    f.setVisible(true);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setSize(900,600);
  }

  public static TakeQuizView getTakeQuizView(){
    return quizGui;
  }
}