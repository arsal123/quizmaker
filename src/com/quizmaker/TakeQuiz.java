package com.quizmaker;
import javax.swing.*;
import java.awt.*;

public class TakeQuiz extends JPanel
{
  private TakeModel quizModel;
  private TakeQuiz takeQuiz;
  
  //Making the buttons for the quiz maker
  private JButton main = new JButton ("Main Menu");
  private JButton next = new JButton ("Next");   //Making the "Next" button
  private JButton close = new JButton ("Close"); //Making the "Close" button
  private JButton done = new JButton ("Done");   //Making the "Done" button
  
  //Making the text fields for the questions and answers
  private String titleStr = "";
  private String rightAnswerStr = "";
  private String questionStr = ""; 
  private String answer1Str = "";
  private String answer2Str = "";
  private String answer3Str = "";
  private JLabel title = new JLabel(titleStr);
  public ButtonGroup buttonGroup = new ButtonGroup();
  private JRadioButton option1 = new JRadioButton(questionStr); //Making the option1 text field
  private JRadioButton option2 = new JRadioButton(answer1Str);  //Making the first answer text field
  private JRadioButton option3 = new JRadioButton(answer2Str);  //Making the second answer text field
  private JRadioButton option4 = new JRadioButton(answer2Str);  //Making the third

  public JLabel rightAnswer = new JLabel("Answer: ");
  
  //Making the JPanels
  private JPanel buttons = new JPanel();
  private JPanel decidePanel = new JPanel();
  private JPanel quizButtons = new JPanel();
  private JPanel textFields = new JPanel();
  private JPanel mainButtons = new JPanel();
  private JPanel top = new JPanel();
  private JPanel answer = new JPanel();
  private JPanel uploadPictures = new JPanel();
  private JPanel filler = new JPanel();
  private JPanel gapFiller = new JPanel();
  public int num = 1;
  
  //Making the JLabels
  private JLabel label = new JLabel("Question #"+num);
  
  //Making the constructor for the QuizGUI
  public TakeQuiz(TakeModel quizModel)
  {
    super();
    this.quizModel = quizModel;
    this.quizModel.setGUI(this);  //Setting up the GUI to make it as a BorderLayout
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
    decidePanel.add(rightAnswer);
    BorderLayout border = new BorderLayout();
    buttons.setLayout(border);
    buttons.add(quizButtons,BorderLayout.EAST);
    buttons.add(decidePanel,BorderLayout.CENTER);
    buttons.add(mainButtons,BorderLayout.WEST);
    
    //Options
    textFields.setLayout(new BoxLayout(textFields, BoxLayout.Y_AXIS));
    buttonGroup.add(option2);
    buttonGroup.add(option3);
    buttonGroup.add(option4);
    buttonGroup.add(option1);
    textFields.add(option1);
    textFields.add(option2);
    textFields.add(option3);
    textFields.add(option4);
    textFields.setBorder(BorderFactory.createTitledBorder("Options:"));
    
    //Title
    top.setBorder(BorderFactory.createTitledBorder("Question:"));
    top.add(title);
    
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
    this.quizModel.stringArray();
    TakeController controller = new TakeController(this.takeQuiz,this.quizModel, this.option1.getText(),this.option2.getText(),this.option3.getText(),this.option4.getText());
    this.next.addActionListener(controller);
    this.close.addActionListener(controller);
    this.done.addActionListener(controller);
    this.main.addActionListener(controller);
    this.option1.addActionListener(controller);
    this.option2.addActionListener(controller);
    this.option3.addActionListener(controller);
    this.option4.addActionListener(controller);
  }
  
  //Update the GUI after the actions of the Model
  public void updateLittle(String answer)
  {
    if (answer=="true")
      this.rightAnswer.setText(this.quizModel.rightAnswer(""));
    else 
      this.rightAnswer.setText(this.quizModel.wrongAnswer());
    this.quizModel.setGUI(this);  //Setting up the GUI to make it as a BorderLayout
    this.layoutView();          //Having the JPanel layout view
    this.registerControllers();  //Having the controllers to be registered by the controller class
  }
  public void update()
  {
    this.title.setText(this.quizModel.returnTitle(num));
    int y = (int)(Math.random()*((10-1)+1))+1;
    switch(y)
    {
      case 1:
        this.option1.setText(this.quizModel.returnAnswer(num));
        this.option2.setText(this.quizModel.returnQuestion2(num));
        this.option3.setText(this.quizModel.returnQuestion3(num));
        this.option4.setText(this.quizModel.returnQuestion4(num));
        this.quizModel.theAnswer = 1;
      case 2:
        this.option1.setText(this.quizModel.returnQuestion1(num));
        this.option2.setText(this.quizModel.returnAnswer(num));
        this.option3.setText(this.quizModel.returnQuestion3(num));
        this.option4.setText(this.quizModel.returnQuestion4(num));
        this.quizModel.theAnswer = 2;
      case 3:
        this.option1.setText(this.quizModel.returnQuestion1(num));
        this.option2.setText(this.quizModel.returnQuestion2(num));
        this.option3.setText(this.quizModel.returnAnswer(num));
        this.option4.setText(this.quizModel.returnQuestion4(num));
        this.quizModel.theAnswer = 3;
      case 4:
        this.option1.setText(this.quizModel.returnQuestion1(num));
        this.option2.setText(this.quizModel.returnQuestion2(num));
        this.option3.setText(this.quizModel.returnQuestion3(num));
        this.option4.setText(this.quizModel.returnAnswer(num));
        this.quizModel.theAnswer = 4;
      case 5:
        this.option1.setText(this.quizModel.returnQuestion2(num));
        this.option2.setText(this.quizModel.returnQuestion3(num));
        this.option3.setText(this.quizModel.returnAnswer(num));
        this.option4.setText(this.quizModel.returnQuestion4(num));
        this.quizModel.theAnswer = 3;
      case 6:
        this.option1.setText(this.quizModel.returnQuestion4(num));
        this.option2.setText(this.quizModel.returnAnswer(num));
        this.option3.setText(this.quizModel.returnQuestion3(num));
        this.option4.setText(this.quizModel.returnQuestion1(num));
        this.quizModel.theAnswer = 2;
      case 7:
        this.option1.setText(this.quizModel.returnQuestion1(num));
        this.option2.setText(this.quizModel.returnQuestion2(num));
        this.option3.setText(this.quizModel.returnQuestion3(num));
        this.option4.setText(this.quizModel.returnAnswer(num));
        this.quizModel.theAnswer = 4;
      case 8:
        this.option1.setText(this.quizModel.returnAnswer(num));
        this.option2.setText(this.quizModel.returnQuestion1(num));
        this.option3.setText(this.quizModel.returnQuestion2(num));
        this.option4.setText(this.quizModel.returnQuestion3(num));
        this.quizModel.theAnswer = 1;
      case 9:
        this.option1.setText(this.quizModel.returnQuestion1(num));
        this.option2.setText(this.quizModel.returnAnswer(num));
        this.option3.setText(this.quizModel.returnQuestion4(num));
        this.option4.setText(this.quizModel.returnQuestion3(num));
        this.quizModel.theAnswer = 2;
      case 10:
        this.option1.setText(this.quizModel.returnAnswer(num));
        this.option2.setText(this.quizModel.returnQuestion2(num));
        this.option3.setText(this.quizModel.returnQuestion4(num));
        this.option4.setText(this.quizModel.returnQuestion1(num));
        this.quizModel.theAnswer = 1;
    }
    this.label.setText("Question #"+num);
    num++;
  }
}