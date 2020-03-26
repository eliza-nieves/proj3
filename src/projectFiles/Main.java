package projectFiles;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Builds the GUI, and runs the program.
 */
public class Main extends Application {

    /**
     * Creates the GUI.
     * @param primaryStage Main stage of the GUI.
     * @throws Exception ANy issues during build
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Tuition Manager");
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    /**
     * Runs program.
     * @param args Command line arguments to running the program.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
