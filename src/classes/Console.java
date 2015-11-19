/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author mauricio
 */
public class Console {

    public static void main(String[] args) {
        new Console();
    }
    public JFrame frame;
    public JTextPane console;
    public JTextField input;
    public JScrollPane scrollpane;

    public StyledDocument document;
    boolean trace = false;

    public Console() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }
        frame = new JFrame();
        frame.setTitle("Console");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        console = new JTextPane();
        console.setEditable(false);
        console.setFont(new Font("Courier New", Font.PLAIN, 12));
        console.setOpaque(false);

        document = console.getStyledDocument();

        input = new JTextField();
        // input.setBorder(null)
        input.setEditable(true);
        input.setFont(new Font("Courier New", Font.PLAIN, 12));
        input.setForeground(Color.BLACK);
        input.setCaretColor(Color.BLACK);
        input.setOpaque(false);

        input.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String text = input.getText();

                if (text.length() > 1) {
                   // print(text + "\n", true);
                    doCommand(text);
                    scrollBottom();
                    input.selectAll();
                }
            }

        }
        );
        input.addKeyListener(new KeyListener() {

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

            @Override
            public void keyTyped(KeyEvent e) {
            }

        });

        scrollpane = new JScrollPane(console);
        scrollpane.setBorder(null);
        scrollpane.setOpaque(false);
        scrollpane.getViewport().setOpaque(false);

        frame.add(input, BorderLayout.SOUTH);
        frame.add(scrollpane, BorderLayout.CENTER);

        frame.getContentPane().setBackground(new Color(50, 50, 50));

        frame.setSize(660, 350);
        frame.setLocationRelativeTo(null);

        frame.setResizable(false);
        frame.setVisible(true);

    }

    public void doCommand(String s) {

        
        
        
    }
    
    public void scrollTop(){
        console.setCaretPosition(0);
    }
    
    public void scrollBottom(){
        console.setCaretPosition(console.getDocument().getLength());
    }
    
    public void print(String s, boolean trace){
        print(s,trace,new Color (255, 255, 255));
    }
    
    public void print(String s, boolean trace, Color c){
        Style style = console.addStyle("Style", null);
        StyleConstants.setForeground(style, c);
        
        if (trace) {
            Throwable t = new Throwable();
            // puedo usar esto para display el path
            StackTraceElement[] elements = t.getStackTrace();
            String caller = elements[0].getClassName();
            
            s= caller + " -> " + s; 
        }
        
        try {
            document.insertString(document.getLength(), s, style);
        } catch (Exception e) {
        }
    }
    
    public void println(String s, boolean trace){
        println(s,trace, new Color(255,255,255));
    }
    
    public void println(String s, boolean trace, Color c){
    
    }
    
}
