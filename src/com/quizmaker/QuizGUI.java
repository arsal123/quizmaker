package com.quizmaker;

import javax.swing.*;
import java.awt.*;

public class QuizGUI extends JPanel
{
  private QuizModel quizModel;
  
  //Making the buttons for the quiz maker
  private JButton main = new JButton ("Main Menu");
  private JButton next = new JButton ("Next");   //Making the "Next" button
  private JButton close = new JButton ("Close"); //Making the "Close" button
  private JButton done = new JButton ("Done");   //Making the "Done" button
  private JButton upload = new JButton("Upload Picture");
  
  //Making the text fields for the questions and answers
  private JTextField title = new JTextField(50);
  private JTextField question = new JTextField(15); //Making the question text field
  private JTextField answer1 = new JTextField(15);  //Making the first answer text field
  private JTextField answer2 = new JTextField(15);  //Making the second answer text field
  private JTextField answer3 = new JTextField(15);  //Making the third
  private JTextField rightAnswer = new JTextField(50);
  
  //Making the JPanels
  private JPanel buttons = new JPanel();
  private JPanel quizButtons = new JPanel();
  private JPanel textFields = new JPanel();
  private JPanel mainButtons = new JPanel();
  private JPanel top = new JPanel();
  private JPanel answer = new JPanel();
  private JPanel uploadPictures = new JPanel();
  private JPanel filler = new JPanel();
  private JPanel gapFiller = new JPanel();
  private int num = 1;
  
  //Making the JLabels
  private JLabel label = new JLabel("Question #"+num);
  
  //Making the constructor for the QuizGUI
  public QuizGUI(QuizModel quizModel)
  {
    super();
    this.quizModel = quizModel;
    this.quizModel.setGUI(this);      //Setting up the GUI to make it as a BorderLayout
    this.layoutView();          //Having the JPanel layout view
    this.registerControllers();  //Having the controllers to be registered by the controller class
    this.update();
  }
  
  //Adding the buttons and text field to the panel
  private void layoutView()
  {
    //Buttons
    quizButtons.add(next);
    quizButtons.add(close);
    quizButtons.add(done);
    mainButtons.add(main);
    BorderLayout border = new BorderLayout();
    buttons.setLayout(border);
    buttons.add(quizButtons,BorderLayout.EAST);
    buttons.add(mainButtons,BorderLayout.WEST);
    
    //Answer
    answer.setBorder(BorderFactory.createTitledBorder("Answer:"));
    answer.add(rightAnswer);
    
    //Options
    textFields.setLayout(new BoxLayout(textFields, BoxLayout.Y_AXIS));
    textFields.add(question);
    textFields.add(answer1);
    textFields.add(answer2);
    textFields.add(answer3);
    textFields.setBorder(BorderFactory.createTitledBorder("Options:"));
    
    //Title
    top.setBorder(BorderFactory.createTitledBorder("Question:"));
    top.add(title);
    
    //Adding Pictures
    uploadPictures.add(upload);
    upload.setPreferredSize(new Dimension(200,100));
    
    //Filler
    filler.add(gapFiller);
    gapFiller.setPreferredSize(new Dimension(200,175));
      
    //The complete layout
    this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    this.add(label);
    this.add(top);
    this.add(answer);
    this.add(textFields);
    this.add(uploadPictures);
    this.add(filler);
    this.add(buttons);
  }
  
  //Assigns the controllers the buttons
  private void registerControllers()
  {
    QuizController controller = new QuizController(this.quizModel, this.title, this.rightAnswer, this.question, this.answer1, this.answer2, this.answer3);
    this.next.addActionListener(controller);
    this.close.addActionListener(controller);
    this.done.addActionListener(controller);
    this.main.addActionListener(controller);
    this.upload.addActionListener(controller);
  }
  
  //Update the GUI after the actions of the Model
  public void update()
  {
    this.label.setText("Question #"+num);
    num++;
    this.title.setText("");
    this.rightAnswer.setText("");
    this.question.setText("");
    this.answer1.setText("");
    this.answer2.setText("");
    this.answer3.setText("");
  }
}