package com.example.main1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
   // private List<Number> num = new ArrayList<>();


    Float data = 0f;
    int operation = -1;
    @FXML
    private Button clear;

    @FXML
    private TextField display;

    @FXML
    private Button div;

    @FXML
    private Button eight;

    @FXML
    private Button equals;

    @FXML
    private Button five;

    @FXML
    private Button four;

    @FXML
    private Button minus;

    @FXML
    private Button mult;

    @FXML
    private Button nine;

    @FXML
    private Button one;

    @FXML
    private Button plus;

    @FXML
    private Button seven;

    @FXML
    private Button six;

    @FXML
    private Button three;

    @FXML
    private Button two;

    @FXML
    private Button zero;

    @FXML
    private Button tochka;

    @FXML
    private Label label;

    @FXML
    void handleButtonAction(ActionEvent event) {
        Button button = (Button) event.getSource();
        String text = button.getText();

        if (event.getSource() == equals) {
            String[] elements = label.getText().split(" ");
            float result = Float.parseFloat(elements[0]);

            for (int i = 1; i < elements.length; i += 2) {
                float nextOperand = Float.parseFloat(elements[i + 1]);
                switch (elements[i]) {
                    case "+" -> result += nextOperand;
                    case "-" -> result -= nextOperand;
                    case "*" -> result *= nextOperand;
                    case "/" -> result /= nextOperand;
                }
            }
            display.setText(String.valueOf(result));
            label.setText("");
        } else if (event.getSource() == clear) {
            display.setText("");
            label.setText("");
        } else if (event.getSource() == plus || event.getSource() == minus || event.getSource() == mult || event.getSource() == div) {
            if (!label.getText().isEmpty()) {
                String[] elements = label.getText().split(" ");
                float result = Float.parseFloat(elements[0]);

                for (int i = 1; i < elements.length; i += 2) {
                    float nextOperand = Float.parseFloat(elements[i + 1]);
                    switch (elements[i]) {
                        case "+" -> result += nextOperand;
                        case "-" -> result -= nextOperand;
                        case "*" -> result *= nextOperand;
                        case "/" -> result /= nextOperand;
                    }
                }

                display.setText(String.valueOf(result));
                label.setText(result + " " + text + " ");  // Добавляем операцию к label
                operation = text.equals("+") ? 1 : text.equals("-") ? 2 : text.equals("*") ? 3 : 4;
            } else {
                data = Float.parseFloat(display.getText());
                label.setText(data + " " + text + " ");  // Добавляем операцию к label
                display.setText("");
                operation = text.equals("+") ? 1 : text.equals("-") ? 2 : text.equals("*") ? 3 : 4;
            }
        } else {  // Цифры и точка
            display.setText(display.getText() + text);
            label.setText(label.getText() + text);
        }
    }

    @FXML
    void KeyInput(ActionEvent event) {
        Float secondOperand = Float.parseFloat(display.getText());
        Button button = (Button) event.getSource();
        String text = button.getText();

        if (text.matches("[0-9]")) {
            display.setText(display.getText() + text);
        } else if (event.getSource() == plus) {
            data = Float.parseFloat(display.getText());
            operation = 1;
            label.setText(display.getText() + " + ");
            display.setText("");
        } else if (event.getSource() == minus) {
            data = Float.parseFloat(display.getText());
            operation = 2;
            label.setText(display.getText() + " - ");
            display.setText("");
        } else if (event.getSource() == mult) {
            data = Float.parseFloat(display.getText());
            operation = 3;
            label.setText(display.getText() + " * ");
            display.setText("");
        } else if (event.getSource() == div) {
            data = Float.parseFloat(display.getText());
            operation = 4;
            label.setText(display.getText() + " / ");
            display.setText("");
        } else if (event.getSource() == equals)  {
        switch (text) {

            case "+":
                // Действия при нажатии кнопки "+"
                Float ans = data + secondOperand;
                display.setText(String.valueOf(ans));
                label.setText("");
                break;
            case "-":
                // Действия при нажатии кнопки "-"
                ans = data - secondOperand;
                display.setText(String.valueOf(ans));
                label.setText("");
                break;
            case "*":
                // Действия при нажатии кнопки "*"
                ans = data * secondOperand;
                display.setText(String.valueOf(ans));
                label.setText("");
                break;
            case "/":
                // Действия при нажатии кнопки "/"
                ans = 0f;
                try {
                    ans = data / secondOperand;
                } catch (Exception e){display.setText("Ошибка");}
                display.setText(String.valueOf(ans));
                label.setText("");
                break;
            default:
                break;
        }
    }
    }

//    @FXML
//    void ButtonAction(ActionEvent event) {
//        Button button = (Button) event.getSource();
//        String text = button.getText();
//
//        if (text.matches("[0-9]")) {
//            display.setText(display.getText() + text);
//        } else if (text.equals("+")) {
//            label.setText(display.getText() + " + ");
//            display.setText("");
//        }
//
//    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}