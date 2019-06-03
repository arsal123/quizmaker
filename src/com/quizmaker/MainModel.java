package com.quizmaker;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class MainModel
{
  private MainMenu quizView;
  
  public MainModel()
  {
    super();
  }
  public void setGUI(MainMenu currentGUI)
  {
    this.quizView = currentGUI;
  }
  public void restart()
  {
    PrintWriter writer = new PrintWriter(Prompt.printWriter("File.txt"));
    writer.print("");
    writer.close();
  }
}