import UI.CreateFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {
    JTextField textField = new JTextField();
    CreateFrame createFrame = new CreateFrame(this, textField);

    String operation = "";
    double result = 0.0;

    @Override
    public void actionPerformed(ActionEvent event) {
        switch (event.getActionCommand()) {
            case "CE" -> {
                textField.setText("");
                operation = "";
            }
            case "C" -> {
                String content = textField.getText();
                textField.setText("");
                for (int i = 0; i < content.length() - 1; i++) {
                    textField.setText(textField.getText() + content.charAt(i));
                }
                operation = "";
            }
            case "+" -> {
                result = Double.parseDouble(textField.getText());
                textField.setText("");
                operation = "+";
            }
            case "-" -> {
                result = Double.parseDouble(textField.getText());
                textField.setText("");
                operation = "-";
            }
            case "*" -> {
                result = Double.parseDouble(textField.getText());
                textField.setText("");
                operation = "*";
            }
            case "/" -> {
                result = Double.parseDouble(textField.getText());
                textField.setText("");
                operation = "/";
            }
            case "=" -> {
                switch (operation) {
                    case "+" -> {
                        result = result + Double.parseDouble(textField.getText());
                        textField.setText(result + "");
                    }
                    case "-" -> {
                        result = result - Double.parseDouble(textField.getText());
                        textField.setText(result + "");
                    }
                    case "*" -> {
                        result = result * Double.parseDouble(textField.getText());
                        textField.setText(result + "");
                    }
                    case "/" -> {
                        result = result / Double.parseDouble(textField.getText());
                        textField.setText(result + "");
                    }
                }
            }
            default -> textField.setText(textField.getText().concat(event.getActionCommand()));
        }
    }
}
