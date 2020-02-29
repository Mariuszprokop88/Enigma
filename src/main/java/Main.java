import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;



public class Main extends Application {
    private static Stage mainStage;
    String resourcePath = "/fxml/Main.fxml";
    @Override
    public void start(Stage primaryStage) throws Exception {
        mainStage = primaryStage;
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(resourcePath));
        AnchorPane anchor = loader.load();
        Scene scene = new Scene(anchor);
        primaryStage.setTitle("Enigma");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static Stage getMainStage() {
        return mainStage;
    }



    }

