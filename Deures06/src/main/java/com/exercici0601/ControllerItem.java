package com.exercici0601;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class ControllerItem {
    @FXML
    private Circle circleColor;
    
    @FXML 
    private ImageView imgCharacter;
    
    @FXML 
    private Label lblName;
    
    @FXML 
    private Label lblGame;

    public void setNameCharacter(String name) {
        lblName.setText(name);
    }

    public void setImatge(String imagePath) {
        try {
            Image img = new Image(getClass().getResourceAsStream(imagePath));
            imgCharacter.setImage(img);
        } catch (Exception e) {
            System.err.println("Error loading image: " + imagePath);
            imgCharacter.setImage(null);
        }
    }

    public void setCircleColor(String color) {
        if (circleColor != null && color != null) {
            circleColor.setFill(Color.web(color));
        }
    }

    public void setGame(String game) {
        lblGame.setText(game);
    }
}