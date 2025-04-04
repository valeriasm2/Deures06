package com.exercici0601;

import com.utils.*;

import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;

import org.json.JSONArray;
import org.json.JSONObject;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;

public class ControllerCharacters implements Initializable {

    @FXML
    private ImageView imgArrowBack;

    @FXML
    private VBox list;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            URL imageURL = getClass().getResource("/assets/images0601/arrow-back.png");
            if (imageURL != null) {
                Image image = new Image(imageURL.toExternalForm());
                imgArrowBack.setImage(image);
            }
        } catch (Exception e) {
            System.err.println("Error loading image asset: arrow-back.png");
            e.printStackTrace();
        }
    }

    public void loadList() {
        try {
            // Cargar datos del JSON
            URL jsonFileURL = getClass().getResource("/assets/data/characters.json");
            if (jsonFileURL != null) {
                Path path = Paths.get(jsonFileURL.toURI());
                String content = Files.readString(path, StandardCharsets.UTF_8);
                JSONArray jsonInfo = new JSONArray(content);

                // Limpiar la lista actual
                list.getChildren().clear();

                // Cargar cada personaje
                for (int i = 0; i < jsonInfo.length(); i++) {
                    JSONObject character = jsonInfo.getJSONObject(i);
                    String name = character.getString("name");
                    String game = character.getString("game");
                    String imagePath = character.getString("image");
                    String color = character.getString("color");

                    // Crear el ítem para cada personaje
                    AnchorPane item = createCharacterItem(name, game, imagePath, color);
                    if (item != null) {
                        list.getChildren().add(item);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private AnchorPane createCharacterItem(String name, String game, String imagePath, String color) {
        try {
            // Crear el diseño del ítem
            AnchorPane item = new AnchorPane();
            item.setMaxHeight(50.0);
            item.setStyle("-fx-background-color: white; -fx-border-style: solid; -fx-border-width: 0 0 1 0; -fx-border-color: grey;");

            HBox hbox = new HBox();
            hbox.setAlignment(Pos.CENTER_LEFT);
            hbox.setPrefHeight(50.0);

            // Imagen del personaje
            ImageView imgCharacter = new ImageView();
            URL imageURL = getClass().getResource("/assets/images0601/" + imagePath);
            if (imageURL != null) {
                Image image = new Image(imageURL.toExternalForm());
                imgCharacter.setImage(image);
                imgCharacter.setFitHeight(40.0);
                imgCharacter.setFitWidth(40.0);
                imgCharacter.setPreserveRatio(true);
            }

            // Nombre y juego
            VBox textContainer = new VBox(5);
            Label lblName = new Label(name);
            lblName.setFont(new Font(18.0));
            Label lblGame = new Label("Juego: " + game);
            lblGame.setStyle("-fx-text-fill: #555; -fx-font-size: 12px;");

            textContainer.getChildren().addAll(lblName, lblGame);
            hbox.getChildren().addAll(imgCharacter, textContainer);

            
            // Añadir círculo de color
            Circle colorCircle = new Circle(10, Color.web(color));
            HBox.setMargin(colorCircle, new Insets(0, 15, 0, 0));
            hbox.getChildren().add(colorCircle);

            // Anchor el HBox al AnchorPane
            AnchorPane.setTopAnchor(hbox, 0.0);
            AnchorPane.setBottomAnchor(hbox, 0.0);
            AnchorPane.setLeftAnchor(hbox, 0.0);
            AnchorPane.setRightAnchor(hbox, 0.0);

            item.getChildren().add(hbox);
            return item;

        } catch (Exception e) {
            System.err.println("Error creating character item: " + name);
            e.printStackTrace();
            return null;
        }
    }

    @FXML
    private void toViewMain(MouseEvent event) {
        UtilsViews.setViewAnimating("ViewMain");
    }
}