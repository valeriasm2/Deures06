package com.exercici0601;

import java.util.Objects;

import javafx.scene.text.Text;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

public class ControllerItem {

    @FXML
    private Text nameCharacter;

    @FXML
    private ImageView imageCharacters;

    @FXML
    private Circle circle;

    @FXML
    private Text game;

    // Cambié el tipo de "nameCharacter" para asignar el texto correctamente
    public void setNameCharacter(String name) {
        this.nameCharacter.setText(name);  // Usamos setText para asignar un texto a un objeto Text
    }

    public void setImatge(String imagePath) {
        try {
            Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(imagePath)));
            this.imageCharacters.setImage(image);
        } catch (NullPointerException e) {
            System.err.println("Error loading image asset: " + imagePath);
            e.printStackTrace();
        }
    }

    public void setCircleColor(String color) {
        circle.setStyle("-fx-fill: " + color);
    }

    // Agregar un método para establecer el nombre del juego
    public void setGame(String gameName) {
        this.game.setText(gameName);  // Similar a setNameCharacter, asignamos el nombre del juego
    }
}

