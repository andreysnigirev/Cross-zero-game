package com.example.crosszero;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.GridPane;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    private char currSymbol = 'X';

    private char[][] field = new char[3][3];
    private boolean isGame = true;

    @FXML
    void buttonClick(ActionEvent event) {
        Button button = (Button)event.getSource();
        if (!isGame || button.getText() != "") {
            return;
        }
        int rowIndex = GridPane.getRowIndex(button) == null ? 0: GridPane.getRowIndex(button);
        int columnIndex = GridPane.getColumnIndex(button) == null ? 0: GridPane.getColumnIndex(button);
        if (field[rowIndex][columnIndex] != '0' && field[rowIndex][columnIndex] != 'X') {
            field[rowIndex][columnIndex] = currSymbol;
            button.setText(String.valueOf(currSymbol));
        } else {
            return;
        }

        if ((field[0][0] == field[0][1] && field[0][0] == field[0][2]) && (field[0][0] == 'X' || field[0][0] == '0')){
            isGame = false;
        }
        if ((field[1][0] == field[1][1] && field[1][0] == field[1][2]) && (field[1][0] == 'X' || field[1][0] == '0')){
            isGame = false;
        }
        if ((field[2][0] == field[2][1] && field[2][0] == field[2][2]) && (field[2][0] == 'X' || field[2][0] == '0')){
            isGame = false;
        }
        if ((field[0][0] == field[1][0] && field[0][0] == field[2][0]) && (field[0][0] == 'X' || field[0][0] == '0')){
            isGame = false;
        }
        if ((field[0][1] == field[1][1] && field[0][1] == field[2][1]) && (field[0][1] == 'X' || field[0][1] == '0')){
            isGame = false;
        }
        if ((field[0][2] == field[1][2] && field[0][2] == field[2][2]) && (field[0][2] == 'X' || field[0][2] == '0')){
            isGame = false;
        }
        if ((field[0][0] == field[1][1] && field[0][0] == field[2][2]) && (field[0][0] == 'X' || field[0][0] == '0')){
            isGame = false;
        }
        if ((field[2][0] == field[1][1] && field[2][0] == field[0][2]) && (field[2][0] == 'X' || field[2][0] == '0')){
            isGame = false;
        }
        if (!isGame){
            if (currSymbol == 'X') {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Игра окончена, победил первый игрок!!", ButtonType.CLOSE);
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Игра окончена, победил второй игрок!!", ButtonType.CLOSE);
                alert.showAndWait();
            }
        }
        int c = 0;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (field[i][j] != 'X' && field[i][j] != '0'){
                    c++;
                }
            }
        }
        if (c == 0 && isGame){
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "У нас ничья!", ButtonType.CLOSE);
            alert.showAndWait();
            isGame = false;
        }
        currSymbol = currSymbol == 'X' ? '0' : 'X';
    }

    @FXML
    void initialize() {

    }

}
