package UI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;

public class CreateFrame {
    JFrame frame;
    JTextField textField;

    public CreateFrame(ActionListener listener) {
        createAndShowUI();
        setupAllButtons(listener);
        setFrameVisible();
    }

    public void createAndShowUI() {
        frame = new JFrame("Calculator");
        frame.setSize(330, 496);
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);
    }

    public void setFrameVisible() {
        frame.setVisible(true);
    }

    public void setupAllButtons(ActionListener listener) {
        showTextField();
        createAndShowButtons(4, listener, "7", "8", "9", "/");
        createAndShowButtons(3, listener, "4", "5", "6", "*");
        createAndShowButtons(2, listener, "1", "2", "3", "-");
        createAndShowButtons(1, listener, ".", "0", "=", "+");
        createAndShowButtons(0, listener, "C", "CE");
    }

    public void showTextField() {
        this.textField = new JTextField();
        textField.setBounds(16, 16, 280, 64);
        textField.setEditable(false);
        textField.setHorizontalAlignment(JTextField.RIGHT);
        frame.add(textField);
    }

    public JTextField getTextField() {
        return this.textField;
    }

    public void createAndShowButtons(int rowItem, ActionListener listener, String... buttons) {
        for (int i = 0; i < buttons.length; i++) {
            createButton(
                    buttons[i],
                    getLeftPadding(i, buttons.length),
                    getTopPadding(rowItem),
                    getWidthSize(buttons.length),
                    64,
                    listener
            );
        }
    }

    public void createButton(String title, int leftPadding, int topPadding, int width, int height, ActionListener listener) {
        JButton button = new JButton(title);
        button.addActionListener(listener);
        button.setBounds(leftPadding, topPadding, width, height);
        button.setBackground(Color.LIGHT_GRAY);
        button.setBorder(BorderFactory.createRaisedBevelBorder());
        button.setOpaque(true);
        frame.add(button);
    }

    public int getWidthSize(int length) {
        if (length == 2) return 136;
        else return 64;
    }

    public int getLeftPadding(int item, int length) {
        return switch (item) {
            case 1 -> (length == 2) ? 160 : 88;
            case 2 -> 160;
            case 3 -> 232;
            default -> 16;
        };
    }

    public int getTopPadding(int item) {
        return switch (item) {
            case 1 -> 306;
            case 2 -> 234;
            case 3 -> 162;
            case 4 -> 90;
            default -> 378;
        };
    }
}
