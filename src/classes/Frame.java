/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 *
 * @author mauricio
 */
public class Frame extends JFrame {

    public JFrame comparar;
    public JTextArea archivo1;
    public JTextArea archivo2;

    public Frame(File a, File b) {
        
        comparar = new JFrame();
        comparar.setTitle("diff");
        archivo1 = new JTextArea();
        aTexto(a,archivo1);
        
        //archivo1.append(file1);
        
        archivo2 = new JTextArea();
        aTexto(b, archivo2);
        //archivo2.append(file2);
        comparar.getContentPane().setBackground(new Color(50, 50, 50));
        comparar.add(archivo1, BorderLayout.SOUTH);
        comparar.add(archivo2, BorderLayout.NORTH);
        comparar.setSize(660, 350);
        comparar.setLocationRelativeTo(null);

        comparar.setResizable(false);

        comparar.setVisible(true);

    }
    
    public void aTexto(File a, JTextArea b){
        File fichero = a;
        FileReader fr = null;
        BufferedReader br = null;
        String message = "";
        b.setText("");
        try {
            fr = new FileReader(fichero);
            br = new BufferedReader(fr);
            while((message = br.readLine())!= null){
                b.append(message + "\n");
            }
        } catch (Exception e) {
        }
        
    }

}
