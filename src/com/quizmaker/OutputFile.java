package com.quizmaker;

import java.io.*;

public class OutputFile
{
  public static void main(String[] args)
  {
    String string = Prompt.getString("Enter some shit");
    PrintWriter out = new PrintWriter(Prompt.printWriter("File.txt"));
    out.println(string);
  }
}