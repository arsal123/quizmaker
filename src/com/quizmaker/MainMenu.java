package com.quizmaker;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JPanel
{
  private MainModel quiz;
  
  private JButton play = new JButton("Play");
  private JButton menu = new JButton("Menu");
  private JButton create = new JButton("Create");
  private JPanel panelOne = new JPanel();
  private JPanel panelTwo = new JPanel();
  private JPanel panelThree = new JPanel();
  private JComponent filler = new JPanel();
  
  private JLabel quizTitle = new JLabel("Build-your-own QuizMaker");
  
  public MainMenu(MainModel quiz)
  {
    super();
    this.quiz = quiz;
    this.quiz.setGUI(this);
    this.layoutView();
    this.registerControllers();
  }
  
  private void layoutView()
  {
    this.setLayout(new BorderLayout());
    this.add(panelOne,BorderLayout.NORTH);
    this.add(panelTwo,BorderLayout.CENTER);
    this.add(panelThree,BorderLayout.SOUTH);
    panelOne.add(filler);
    filler.setSize(100,75);
    panelOne.setBackground(Color.GREEN);
    panelThree.setBackground(Color.GREEN);
    filler.setBackground(Color.GREEN);
    play.setSize(100,50);
    panelTwo.add(play);
    panelThree.add(menu);
    panelThree.add(create);
  }
  private void registerControllers()
  {
    MenuController controller = new MenuController(this.quiz);
    this.play.addActionListener(controller);
    this.menu.addActionListener(controller);
    this.create.addActionListener(controller);
  }
}