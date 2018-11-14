/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adressverwaltung.controller;

import adressverwaltung.model.Application;
import adressverwaltung.view.Surface;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * class to implements the controller for the function undo()
 * <br> in the class the event to invoke the undo()-command is registered and
 * triggered if the specific event appears
 * @author Leonhard Römer, Fabian Heise
 */
public class ControllerUndo implements ActionListener {
    /**
    * variable to declare the component view of the MVC-architecture
    */
    private Surface view;
    /**
    * variable to declare the component model of the MVC-architecture
    */
    private Application model;
    /**
    * variable to connect a collection of all avaiable commands to the controller
    */
    private CommandInvoker invoker;
    /**
    * Constructor to build the MVC-architecture and connect an invoker to the controller
    * @param view set the component view of the MVC-architecture
    * @param model set the component model of the MVC-architecture
    * @param invoker connects an existing CommandInvoker to the controller
    */
    public ControllerUndo(Surface view, Application model, CommandInvoker invoker)
    {
        this.view = view;
        this.model = model;
        this.invoker = invoker;
    }
    /**
    * function to register the events within the controller
    * <br>register the undo-Button to the controller
    */
    public void registerEvents()
    {
        view.getMiUndo().addActionListener(this);
        
    }
    /**
    * function to identify an event and to call the related command
    */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        
        if ((src == view.getMiUndo()))
                {
                  if (!invoker.getUndoStack().empty())
                  {
                    invoker.undoCommand();
                  }
                }
    } 
}
