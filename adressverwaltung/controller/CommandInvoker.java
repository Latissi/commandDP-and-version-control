/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package adressverwaltung.controller;

import java.awt.Component;
import java.util.HashMap;
import java.util.Stack;

/**
 *
 * @author Leonhard Römer, Fabian Heise
 */
public class CommandInvoker
{
  private HashMap<Component, CommandInterface> commands;
  private Stack<CommandInterface> undoStack;
  
  public CommandInvoker()
  {
    commands = new HashMap<>();
    undoStack=new Stack();
  }
  
  public void addCommand(Component key, CommandInterface value)
  {
    commands.put(key, value);
  }
  /**
   * 
   * @param key 
   */
  public void executeCommand(Component key)
  {
    commands.get(key).execute();
    undoStack.push(commands.get(key));
  }
  
  public void undoCommand()
  {
    undoStack.pop().undo();
  }
}