package org.example;
import javax.swing.JFrame;
import asciiPanel.AsciiPanel;
import org.example.screens.Screen;
import org.example.screens.impl.StartScreen;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class JavalikeMainApp  extends JFrame implements KeyListener {

    private AsciiPanel terminal;
    private Screen currentScreen;

    public JavalikeMainApp(){
        super();
        terminal = new AsciiPanel();
        terminal.write("Hello", 1, 1);
        add(terminal);
        pack();
        currentScreen = new StartScreen();
        addKeyListener(this);
        repaint();
    }
    public static void main(String[] args){
        JavalikeMainApp app = new JavalikeMainApp();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
    }

    public void repaint(){
        terminal.clear();
        currentScreen.display(terminal);
        super.repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        currentScreen = currentScreen.processInput(e);
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
