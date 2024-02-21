package org.example.screens;

import asciiPanel.AsciiPanel;

import java.awt.event.KeyEvent;

public interface Screen {

    void display(AsciiPanel terminal);
    Screen processInput(KeyEvent key);
}
