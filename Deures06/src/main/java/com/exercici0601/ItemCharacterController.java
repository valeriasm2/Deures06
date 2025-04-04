package com.exercici0601;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class ItemCharacterController {

    @FXML
    private ImageView imgCharacter;

    @FXML
    private Label lblName;

    @FXML
    private Label lblGame;

    @FXML
    private Circle circleColor;

    public void setData(String name, String game, String imagePath, String color) {
        lblName.setText(name);
        lblGame.setText("Juego: " + game);

        // Cargar imagen
        try {
            Image image = new Image(getClass().getResourceAsStream("/assets/images0601/" + imagePath));
            imgCharacter.setImage(image);
        } catch (Exception e) {
            System.err.println("Error al cargar imagen: " + imagePath);
            imgCharacter.setImage(null);
        }

        // Asignar color al círculo
        circleColor.setFill(Color.web(color));
    }
}