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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;
import javax.swing.JFileChooser;

/**
 *This class implemensts the Controller to call normal functions of surface
 * 
 * <br>with this class you are allowed to call functions like:
 * <br>load a file from directory
 * <br>save a file within the directory
 * 
 * @author Leonhard Römer, Fabian Heise
 * @version 1.0
 */

public class Controller implements ActionListener {
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
     * selectedFile stores informations about the currently opened file
     */
    private File selectedFile;
    /**
     * Constructor to instantiate the Controller
     * constructs the MVC architecture with view and model
     * @param view set the component view of MVC architecture
     * @param model set the  
     */
    public Controller(Surface view, Application model)
    {
        this.view = view;
        this.model = model;
    }
    
    public void registerEvents()
    {
        view.getMiOpen().addActionListener(this);
        view.getBtnOpen().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        String path;
        Preferences prefs = Preferences.userNodeForPackage(this.getClass());
        if ((src == view.getMiOpen()||(src == view.getBtnOpen())))
        {                    
            JFileChooser fc = view.getFcOpen();
            if ((path = prefs.get("directory", "NULL")) != "NULL")
            {
                fc.setCurrentDirectory(new File(path));
            }
            int choice = fc.showDialog(view, "Open File");
            if (choice == JFileChooser.APPROVE_OPTION)
            {
                File selectedFile = fc.getSelectedFile();
                view.getLbPfad().setText("File: " + selectedFile.getAbsolutePath());
                prefs.put("directory",selectedFile.getParent());
                try{
                    view.getTaOuput().setText(model.loadText(selectedFile));
                }
                catch (FileNotFoundException es)
                {
                    fc.showDialog(null, es.getMessage());
                } 
                catch (IOException ex) {
                    Logger.getLogger(ControllerExecute.class.getName()).log(Level.SEVERE, null, ex);
                }                         
            }
        }
        
    }
    
}
