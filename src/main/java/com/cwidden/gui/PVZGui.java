package com.cwidden.gui;

import com.cwidden.SVSController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PVZGui extends JFrame implements ActionListener {
    private JTextArea textAreaShroomGame;
    private JTextField textFieldGameLength;
    private JTextField textFieldFieldSize;
    private JPanel rootPanel;
    private JButton runGameButton;
    private JTextArea textAreaSunflowerGame;
    private JLabel labelError;
    private JRadioButton radioButtonExtraInformation;
    private JButton clearButton;

    private SVSController svsController = SVSController.getINSTANCE();

    public PVZGui() {
        add(rootPanel);
        labelError.setVisible(false);
        setTitle("Plants vs. Zombies Sun Production Simulator");
        runGameButton.addActionListener(this);
        clearButton.addActionListener(this);

        setSize(750,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(runGameButton)) {
            try {
                String gameLengthText = textFieldGameLength.getText();
                String fieldSizeText = textFieldFieldSize.getText();
                int gameLength = Integer.parseInt(gameLengthText);
                int fieldSize = Integer.parseInt(fieldSizeText);
                svsController.runGame(fieldSize, gameLength, radioButtonExtraInformation.isSelected());
                labelError.setVisible(false);
            } catch (NumberFormatException n) {
                labelError.setVisible(true);
            }
        }
        if (e.getSource().equals(clearButton)) {
            textAreaSunflowerGame.setText("");
            textAreaShroomGame.setText("");
        }
    }


    public void printShroomLine(String text, boolean highlight) {
        if (highlight) {
            textAreaShroomGame.append("==> ");
        }
        textAreaShroomGame.append(text + "\n");
    }

    public void printSunflowerLine(String text, boolean highlight) {
        if (highlight) {
            textAreaSunflowerGame.append("==> ");
        }
        textAreaSunflowerGame.append(text + "\n");
    }
}
