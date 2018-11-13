package adressverwaltung.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Interface to declare functions for using Commands called by events
 * @author Leonhard Römer, Fabian Heise
 */
public interface CommandInterface
{
    /**
    * Function to call a command
    */
    public void execute();
    /**
    * Function to withdraw a executed command
    */
    public void undo();  
}
