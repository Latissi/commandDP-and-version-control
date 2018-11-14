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
 * function to collect all events and their commands
 * with the class it is possible to call commands as consequence of
 * specific events and also to withdraw a call
 * @author Leonhard Römer, Fabian Heise
 */
public class CommandInvoker
{
  /**
  * HashMap to store events and their related commands
  * <br>HashMap functions like a database to store and call diffrent
  * commands on call by a special key
  * <br> datatypes of the HashMap are component and the interface CommandInterface
  * which is implemented by diffrent commands, the component shows the event.
  */
  private HashMap<Component, CommandInterface> commands;
  /**
  * Stack to store the latest called commands
  * <br> Stack functions like a LIFO (Last In First Out)
  * <br> datatype of stack is the interface CommandInterface to store all commands
  * which implements the interface
  */
  private Stack<CommandInterface> undoStack;
  /**
  * Constructor to initialize the HashMap as well as the Stack
  */
  public CommandInvoker()
  {
    commands = new HashMap<>();
    undoStack = new Stack<>();
  }
  /**
  * function to add an event and the related command to the HashMap
  * @param key The input parameter key symbolize the event like pushing a button or set an input
  * by a textfield
  * @param value The parameter points out the related command
  */
  public void addCommand(Component key, CommandInterface value)
  {
    commands.put(key, value);
  }
  /**
   * function to call execute()-function of concrete command
   * @param key searching parameter to find related command in the HashMap
   */
  public void executeCommand(Component key)
  {
    commands.get(key).execute();
    undoStack.push(commands.get(key));
  }
  /**
  * function to call the undo()-function of concrete command
  */
  public void undoCommand()
  {
    undoStack.pop().undo();
  }
  /**
   * function to publish private Stack undoStack
   * @return the undoStack
   */
  public Stack<CommandInterface> getUndoStack()
  {
    return undoStack;
  }
}
