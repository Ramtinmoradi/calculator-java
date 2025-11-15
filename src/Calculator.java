import UI.CreateFrame;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {
    JTextField textField;
    CreateFrame createFrame;

    public Calculator() {
        this.createFrame = new CreateFrame(this);
        this.textField = createFrame.getTextField();
    }

    String operation = "";
    double result = 0.0;

    private void setOperation(String newOperation) {
        try {
            result = Double.parseDouble(textField.getText());
            textField.setText("");
            operation = newOperation;
        } catch (NumberFormatException e) {
            textField.setText("Error");
            operation = "";
        }
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        switch (event.getActionCommand()) {
            case "CE" -> {
                textField.setText("");
                operation = "";
            }
            case "C" -> {
                if (!operation.equals("=")) {
                    String content = textField.getText();
                    if (content != null && !content.isEmpty()) {
                        textField.setText(content.substring(0, content.length() - 1));
                    }
                }
            }
            case "+" -> setOperation("+");
            case "-" -> setOperation("-");
            case "*" -> setOperation("*");
            case "/" -> setOperation("/");
            case "=" -> {
                try {
                    double secondNumber = Double.parseDouble(textField.getText());
                    switch (operation) {
                        case "+" -> result = result + secondNumber;
                        case "-" -> result = result - secondNumber;
                        case "*" -> result = result * secondNumber;
                        case "/" -> {
                            if (secondNumber == 0) {
                                textField.setText("Error: Div by zero");
                                operation = "";
                                result = 0.0;
                                return;
                            }
                            result = result / secondNumber;
                        }
                    }
                    textField.setText(String.valueOf(result));
                    operation = "=";
                } catch (NumberFormatException e) {
                    textField.setText("Error");
                    operation = "";
                    result = 0.0;
                }
            }
            default -> {
                String command = event.getActionCommand();
                if (operation.equals("=")) {
                    textField.setText(command);
                    operation = "";
                } else {
                    textField.setText(textField.getText().concat(command));
                }
            }
        }
    }
}
