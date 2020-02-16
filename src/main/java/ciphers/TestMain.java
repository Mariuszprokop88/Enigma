package ciphers;

import ciphers.impl.CesarCipher;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class TestMain extends Application {
    String resourcePath = "/fxml/jhjh.fxml";
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/jhjh.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 600,400);
        primaryStage.setTitle("Enigma");
        primaryStage.setScene(scene);
        primaryStage.show();
    }



    }

