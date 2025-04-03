package com.exercici0601;

import java.util.Objects;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class ControllerItem {

    @FXML
    private Label lblName;

    @FXML
    private ImageView imgCharacter;

    @FXML
    private Circle circleColor;

    @FXML
    private Label lblGame;

    public void setNameCharacter(String name) {
        lblName.setText(name);
    }

    public void setImatge(String imagePath) {
        imgCharacter.setImage(new Image(getClass().getResource(imagePath).toExternalForm()));
    }

    public void setCircleColor(String color) {
        circleColor.setFill(Color.valueOf(color));
    }

    public void setGame(String game) {
        lblGame.setText(game);
    }
}

