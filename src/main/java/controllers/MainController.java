package controllers;

import ciphers.Cipher;
import ciphers.impl.CesarCipher;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;


import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
    @FXML
    public TextArea inputTextArea;


    @FXML
    public void triggerEncoding(){
        String userText = inputTextArea.getText();
        if(!userText.isEmpty()){
            Cipher cesarCipher = new CesarCipher();
            String encode = cesarCipher.encode(userText);
            inputTextArea.setText(encode);
        }
    }

    public void triggerDecoding(){
        String userText = inputTextArea.getText();
        if(!userText.isEmpty()){
            Cipher cesarCipher = new CesarCipher();
            String decode = cesarCipher.decode(userText);
            inputTextArea.setText(decode);
        }
    }
}
