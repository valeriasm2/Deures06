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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class ControllerCharacters implements Initializable {

    @FXML
    private ImageView imgArrowBack;

    @FXML
    private VBox list = new VBox();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Path imagePath = null;
        try {
            URL imageURL = getClass().getResource("/assets/images0601/arrow-back.png");
            Image image = new Image(imageURL.toExternalForm());
            imgArrowBack.setImage(image);
        } catch (Exception e) {
            System.err.println("Error loading image asset: " + imagePath);
            e.printStackTrace();
        }
    }

    public void loadList() {
        try {
            System.out.println("Iniciando carga de personajes...");
            
            // 1. Cargar JSON
            URL jsonUrl = getClass().getResource("/assets/data/characters.json");
            if (jsonUrl == null) {
                System.err.println("ERROR: No se encontró el archivo JSON");
                return;
            }
            
            String jsonContent = Files.readString(Paths.get(jsonUrl.toURI()));
            JSONArray characters = new JSONArray(jsonContent);
            System.out.println("Encontrados " + characters.length() + " personajes");
    
            // 2. Cargar plantilla
            URL itemTemplateUrl = getClass().getResource("/assets/itemCharacters.fxml");
            if (itemTemplateUrl == null) {
                System.err.println("ERROR: No se encontró la plantilla FXML");
                return;
            }
    
            // 3. Limpiar lista existente
            list.getChildren().clear();
    
            // 4. Añadir cada personaje
            for (int i = 0; i < characters.length(); i++) {
                JSONObject character = characters.getJSONObject(i);
                
                FXMLLoader loader = new FXMLLoader(itemTemplateUrl);
                try {
                    Parent item = loader.load();
                    ControllerItem controller = loader.getController();
                    
                    if (controller == null) {
                        System.err.println("ERROR: El controlador es null para " + character.getString("name"));
                        continue;
                    }
                    
                    // Configurar valores
                    controller.setNameCharacter(character.getString("name"));
                    controller.setImatge("/assets/images0601/" + character.getString("name").toLowerCase() + ".png");
                    controller.setCircleColor(character.getString("color"));
                    controller.setGame(character.getString("game"));
                    
                    list.getChildren().add(item);
                    System.out.println("Añadido: " + character.getString("name"));
                } catch (Exception e) {
                    System.err.println("Error cargando personaje: " + character.getString("name"));
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            System.err.println("ERROR CRÍTICO al cargar personajes:");
            e.printStackTrace();
        }
    }
    @FXML
    private void toViewMain(MouseEvent event) {
        UtilsViews.setViewAnimating("ViewMain");
    }
}
