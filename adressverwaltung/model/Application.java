/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package adressverwaltung.model;

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
