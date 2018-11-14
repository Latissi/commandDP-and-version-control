/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package adressverwaltung.model;

import adressverwaltung.view.Surface;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import javax.swing.JTextField;

/**
 *
 * @author nobody
 */
public class Application
{
  public Application()
  {
    
  }
  /**
   * gets the user input for all text fields and puts it into one string
   * @return returns the new string
   */
  public String getEintrag (String name, String Tel, String Handy, String Email){
      String eintrag =  
              "Name: " + name+ "\n" +
              "Telefon: " + Tel + "\n"+
              "Handy: " + Handy + "\n"+
              "Email: " + Email + "\n\n";
      return eintrag;
  }
  
  /**
   * loads the (buffered)text from the specified file and returns it
   * @param f the File from which the text is supposed to be loaded
   * @return returns the string which was read out of the file
   * @throws FileNotFoundException
   * @throws IOException 
   */
  public String loadText(File f) throws FileNotFoundException, IOException
    {
        FileInputStream fis = new FileInputStream(f);
        InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
        BufferedReader buffin = new BufferedReader(isr);
        StringBuffer text = new StringBuffer();
        String zeile="";
        
        while((zeile=buffin.readLine())!=null)
        {
            text.append(zeile);
            text.append("\n");                     
        }
        
        return (text.toString()); 
    }
}
