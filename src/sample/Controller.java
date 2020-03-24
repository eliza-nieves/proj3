package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class Controller {

    @FXML
    private TextArea printed;

    public void addBtnPress(ActionEvent event){
    printed.appendText("hello\n");
    }
}


