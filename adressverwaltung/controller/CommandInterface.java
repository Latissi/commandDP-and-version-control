package adressverwaltung.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nobody
 */
public interface CommandInterface
{
    public void execute();
    public void undo();  
}