package com.exercici0601;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import com.utils.UtilsViews;

public class ControllerFitxa {
    @FXML private Text name;
    @FXML private Text game;
    @FXML private ImageView imgCharacter;
    @FXML private Circle color;
    @FXML private ImageView imgArrowBack;

    // Método para cargar datos - DEBE ser público
    public void setCharacterData(String name, String game, String imagePath, String colorHex) {
        this.name.setText(name);
        this.game.setText(game);
        
        try {
            Image img = new Image(getClass().getResourceAsStream("/assets/images0601/" + imagePath));
            imgCharacter.setImage(img);
        } catch (Exception e) {
            System.err.println("Error loading image: " + imagePath);
        }
        
        try {
            color.setFill(Color.web(colorHex));
        } catch (IllegalArgumentException e) {
            color.setFill(Color.GRAY); // Color por defecto
        }
    }

    @FXML
    private void toViewMain(MouseEvent event) {
        UtilsViews.setViewAnimating("ViewMain");
    }
}