package org.example;
import javax.swing.JFrame;
import asciiPanel.AsciiPanel;

public class JavalikeMainApp  extends JFrame{

    private AsciiPanel terminal;

    public JavalikeMainApp(){
        super();
        terminal = new AsciiPanel();
        terminal.write("Hello", 1, 1);
        add(terminal);
        pack();
    }
    public static void main(String[] args){
        JavalikeMainApp app = new JavalikeMainApp();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
    }
}
