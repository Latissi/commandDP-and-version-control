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
 *
 * @author Leonhard Römer
 */
public class ControllerUndo implements ActionListener {
    
    private Surface view;
    private Application model;
    private CommandInvoker invoker;
    
    public ControllerUndo(Surface view, Application model, CommandInvoker invoker)
    {
        this.view = view;
        this.model = model;
        this.invoker = invoker;
    }
    
    public void registerEvents()
    {
        view.getMiUndo().addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        
        if ((src == view.getMiUndo()))
                {
                    invoker.undoCommand();
                }
    } 
}
