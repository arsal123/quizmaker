package com.quizmaker;

import java.util.*;
import java.io.*;

public class Prompt extends Object{
  
  private static Scanner in = new Scanner(System.in); 
  
  public static int getInt(String prompt)
  {
    int data=0; //The integer input by the user
    
    while(true)
    {
      System.out.println(prompt);
      if(in.hasNextInt())
      {
        data = in.nextInt();
        in.nextLine();
        break;
      }
      else
      {
        String error = in.nextLine();
        System.out.println(error + "is not an integer.");
      }
    }
    return data;
  }
  
    public static double getDouble(String prompt)
  {
    double data=0; //The double input by the user
    
    while(true)
    {
      System.out.println(prompt);
      if(in.hasNextDouble())
      {
        data = in.nextDouble();
        in.nextLine();
        break;
      }
      else
      {
        String error = in.nextLine();
        System.out.println(error + "is not a decimal number.");
      }
    }
    return data;
  }
  
  public static String getString(String prompt)
  {
    System.out.println(prompt);
    return in.nextLine();
  }
  
  public static File getFile(String prompt)
  {
    while (true)
    {
      File inputFile = new File(prompt);
      if (!inputFile.exists())
      {
        System.out.println("Error: " + prompt + " does not exist.");
      }
      else if (inputFile.isDirectory())
      {
        System.out.println("Error: " + prompt + " is a directory.");
      }
      else if (!inputFile.canRead())
      {
        System.out.println("Error: " + prompt + " is not readable.");
      }
      else
      {
        return inputFile;
      } 
    }
  }
  public static File returnFile(String prompt)
  {
    while (true)
    {
      File inputFile = new File(prompt);
      if (!inputFile.exists())
      {
        System.out.println("Error: " + prompt + " does not exist.");
      }
      else if (inputFile.isDirectory())
      {
        System.out.println("Error: " + prompt + " is a directory.");
      }
      else if (!inputFile.canRead())
      {
        System.out.println("Error: " + prompt + " is not readable.");
      }
      else
      {
        return inputFile;
      } 
    }
  }
  
  public static Scanner getInputScanner(String prompt)
  {
    try
    {
      return new Scanner(Prompt.getFile(prompt));
    }
    catch (FileNotFoundException ex)
    {
      System.out.println(ex.getMessage());
      System.out.println("in" + System.getProperty("user.dir"));
      System.exit(1);
    }
    return null;
  }
  public static PrintWriter getPrintWriter(String prompt)
  {
    System.out.println(prompt);
    String fileName = in.nextLine().trim();
    File outputFile = new File(fileName);

    try
    {
      return new PrintWriter(outputFile);
    }
    catch (FileNotFoundException ex)
    {
      System.out.println(ex.getMessage());
      System.out.println("in" + System.getProperty("user.dir"));
      System.exit(1);
    }
    return null;
  } 
  
  public static PrintWriter printWriter(String prompt)
  {
    String fileName = prompt;
    File outputFile = new File(fileName);

    try
    {
      return new PrintWriter(outputFile);
    }
    catch (FileNotFoundException ex)
    {
      System.out.println(ex.getMessage());
      System.out.println("in" + System.getProperty("user.dir"));
      System.exit(1);
    }
    return null;
  }
}