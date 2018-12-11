/**
 * Name: Main.java. Author: Alejandro Sanchez. Description: Main class used to start application.
 */

package dbproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("VehicleViewer.fxml"));
    primaryStage.setTitle("Vehicle Data");
    primaryStage.setScene(new Scene(root, 809, 517));
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
