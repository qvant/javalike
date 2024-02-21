package org.example.screens.impl;

import asciiPanel.AsciiPanel;
import org.example.screens.Screen;

import java.awt.event.KeyEvent;

public class PlayScreen implements Screen {
    @Override
    public void display(AsciiPanel terminal) {
        terminal.write("Some gameplay", 1, 1);
        terminal.write("--Press [Enter] to win or [Escape] to lose --", 22, 22);

    }

    @Override
    public Screen processInput(KeyEvent key) {
        switch (key.getKeyCode()){
            case KeyEvent.VK_ENTER: return new WinScreen();
            case KeyEvent.VK_ESCAPE: return new LoseScreen();
        }
        return this;
    }
}
