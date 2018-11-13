/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adressverwaltung.controller;

import adressverwaltung.model.Application;
import adressverwaltung.view.Surface;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *This class implemensts the Controller to call execute function of Commands
 * 
 * <br>with this class you are allowed to call functions like:
 * <br>add content to text area
 * <br>remove one entry from list
 * 
 * @author Leonhard Römer
 * @version 1.0
 */
public class ControllerExecute implements ActionListener{
    
    /**
     * view declares the component view from MVC architecture
     * <br>with view the controller get informations of happened actions
     */
    private Surface view;
    /**
     * model declares the component model from MVC architecture
     * <br>with model the controller get the opportunity to call functions for
     * specific purpose of programm
     */
    private Application model;
    /**
     * invoker declares the interface to add the specific commands
     * <br>with invoker the commands like add or remove are connected to MVC
     */
    private CommandInvoker invoker;
    
    
    /**
     * Constructor to initialize the class
     * <br>with this the MVC architecture is built for usage
     * @param view set the Component View of the MVC architecture
     * @param model set the Component Model of the MVC architecture
     */       
    public ControllerExecute(Surface view, Application model)
    {
        this.view = view;
        this.model = model;
        invoker = new CommandInvoker();
    }
    
    
    /**
     * function to register the specific action areas like buttons
     * <br>with this the Interface ActionListener is used to add
     * diffrent action areas
     */
    public void registerEvents()
    {
        view.getBtnAdd().addActionListener(this);
        view.getBtnDelete().addActionListener(this);
    }
    /**
     * function to determine the specific command of an action area
     */      
    public void registerCommands()
    {
        invoker.addCommand(view.getBtnAdd(), 
                           new CmdAddElement(this.view, this.model));
        invoker.addCommand(view.getBtnDelete(), 
                           new CmdDeleteElement(view, model));
    }
    /**
     * function to call specific command of the arriving event
     * @param e param to identify the source for triggering event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Component key = (Component)e.getSource();
        invoker.executeCommand(key);  
    }
    
    /**
     * function to get the CommandInvoker of the class
     * @return the CommandInvoker to connect diffrent controllers
     */
    public CommandInvoker getInvoker()
    {
        return invoker;
    }   
}
