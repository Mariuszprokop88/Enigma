package controllers;

import aplication.Main;
import ciphers.Cipher;
import ciphers.impl.CesarCipher;
import ciphers.impl.Root13Cipher;
import ciphers.impl.VigenereCipher;
import factories.impl.CipherFactory;
import file.utils.FileTool;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


import java.io.File;
import java.io.IOError;
import java.io.IOException;
import java.net.URL;
import java.util.*;

import static factories.impl.CipherFactory.*;

public class MainController implements Initializable {
    private Stage mainStage;
    private ObservableList<String> possibleCipherMethods =  FXCollections.observableArrayList(Arrays.asList(CESAR, ROOT13, VIGENERE));
    private CipherFactory cipherFactory = new CipherFactory();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cipherChoiceBox.setItems(possibleCipherMethods);
        cipherChoiceBox.setValue(CESAR);
        mainStage = Main.getMainStage();

    }
    @FXML
    public TextArea inputTextArea;

    @FXML
    ChoiceBox<String>cipherChoiceBox;



    @FXML
    public void triggerEncoding() {
        String userText = inputTextArea.getText();
        if (!userText.isEmpty()) {
            String cipherType = cipherChoiceBox.getValue();
            Cipher cipher = cipherFactory.create(cipherType);
            if (cipher instanceof VigenereCipher) {
                TextInputDialog inputDialog = new TextInputDialog("Key");
                inputDialog.setHeaderText("Pleas choose key and rememebr it");
                inputDialog.setContentText("Key: ");
                Optional<String> userInputOptional = inputDialog.showAndWait();
                if (userInputOptional.isPresent() && !userInputOptional.get().equals("")) {
                    ((VigenereCipher) cipher).setKey(userInputOptional.get());
                } else {
                    return;
                }
            }
            String encode = cipher.encode(userText);
            inputTextArea.setText(encode);
        }
    }


    public void triggerDecoding(){
        String userText = inputTextArea.getText();
        if (!userText.isEmpty()) {
            String cipherType = cipherChoiceBox.getValue();
            Cipher cipher = cipherFactory.create(cipherType);
            if (cipher instanceof VigenereCipher) {
                TextInputDialog inputDialog = new TextInputDialog("Key");
                inputDialog.setHeaderText("If you know the key, write it here");
                inputDialog.setContentText("Key: ");
                Optional<String> userInputOptional = inputDialog.showAndWait();
                if (userInputOptional.isPresent() && !userInputOptional.get().equals("")) {
                    ((VigenereCipher) cipher).setKey(userInputOptional.get());
                } else {
                    return;
                }
            }
            String decode = cipher.decode(userText);
            inputTextArea.setText(decode);
        }
    }
    @FXML
    public void saveToFile(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save to file");
        fileChooser.setInitialFileName("message.crpt");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("crypt file", "*.crpt"),
                new FileChooser.ExtensionFilter("text file", "*txt")
        );
        File fileToSave = fileChooser.showSaveDialog(null);
        if(fileToSave!= null) {
            String absolutePath = fileToSave.getAbsolutePath();
            FileTool.writeTextAreaContentToFile(absolutePath, inputTextArea.getText());
        }
    }

@FXML
public void loadFile(){
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Load file");
    fileChooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("crypt file", "*.crpt"),
            new FileChooser.ExtensionFilter("text file", "*.txt")
    );
    File fileToLoad = fileChooser.showOpenDialog(null);
    if(null!=fileToLoad) {
    String fileContent = FileTool.getFileContent(fileToLoad.getAbsolutePath());
    inputTextArea.setText(fileContent);

        }
    }}

