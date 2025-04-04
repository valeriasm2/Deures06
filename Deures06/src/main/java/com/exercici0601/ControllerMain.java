package com.exercici0601;

import com.utils.*;


import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;


public class ControllerMain {

    @FXML
    private void toViewCharacters(MouseEvent event) {
        System.out.println("To View Characters");
        ControllerCharacters ctrlCharacters = (ControllerCharacters) UtilsViews.getController("ViewCharacters");
        ctrlCharacters.loadList();
        UtilsViews.setViewAnimating("ViewCharacters");
    }
}
