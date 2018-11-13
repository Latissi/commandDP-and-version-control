/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package adressverwaltung;

import adressverwaltung.controller.Controller;
import adressverwaltung.controller.ControllerExecute;
import adressverwaltung.controller.ControllerUndo;
import adressverwaltung.model.Application;
import adressverwaltung.view.Surface;

/**
 * Builder Class
 * @author nobody
 */
public class Start
{
  public Start()
  {
    Surface frm = new Surface();
    frm.setVisible(true);
    Application model = new Application(frm);
    Controller controllerOpenSave = new Controller(frm, model);
    controllerOpenSave.registerEvents();
    ControllerExecute controllerExecute = new ControllerExecute(frm, model);
    controllerExecute.registerEvents();
    controllerExecute.registerCommands();
    ControllerUndo controllerUndo = new ControllerUndo(frm, model, controllerExecute.getInvoker());
    controllerUndo.registerEvents();
    
  }

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) 
  {
    new Start();
  }
}
