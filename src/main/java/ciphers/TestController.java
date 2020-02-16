package ciphers;

import ciphers.impl.CesarCipher;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;


import java.net.URL;
import java.util.ResourceBundle;

public class TestController implements Initializable {
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
