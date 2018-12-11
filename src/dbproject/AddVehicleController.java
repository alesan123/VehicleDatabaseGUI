/**
 * Name:AddVehicleController.java. Author: Alejandro Sanchez. Description: Controller class converts
 * data the user inputs inside of the textFields and inserts them into database.
 */


package dbproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddVehicleController {

  @FXML
  private TextField vinNumber;
  @FXML
  private TextField make;
  @FXML
  private TextField model;
  @FXML
  private TextField year;
  @FXML
  private TextField mileage;
  @FXML
  private TextField price;

  DbHandler databaseHandler;

  /**
   * Function connects to database upon opening scene.
   */
  public void initialize() {
    databaseHandler = new DbHandler();
  }

  /**
   * Requires user to input data into every TextField, which then inserts the data into the
   * database.
   */
  @FXML
  private void addVehicle(ActionEvent event) throws Exception {
    String vehicleVin = vinNumber.getText();
    String vehicleMake = make.getText();
    String vehicleModel = model.getText();
    String vehicleYear = year.getText();
    String vehicleMileage = mileage.getText();
    String vehiclePrice = price.getText();

    //If statement that gives an alert when there is an empty TextField
    if (vehicleVin.isEmpty() || vehicleMake.isEmpty() || vehicleModel.isEmpty() || vehicleYear
        .isEmpty()
        || vehicleMileage.isEmpty() || vehiclePrice.isEmpty()) {
      Alert alert = new Alert(AlertType.ERROR);
      alert.setHeaderText("");
      alert.setContentText("Every field is required.");
      alert.showAndWait();
      return;
    }

    final String addQuery = "INSERT INTO APP.VEHICLE (VIN, MAKE, MODEL, MANUFYEAR, MILEAGE, PRICE) "
        + "VALUES ("
        + "'" + vehicleVin + "', "
        + "'" + vehicleMake + "', "
        + "'" + vehicleModel + "', "
        + "'" + vehicleYear + "', "
        + "'" + vehicleMileage + "', "
        + "'" + vehiclePrice + "'"
        + " )";
    // String addQuery needs to be dynamicaly generated because the information will change
    // dynamically.
    databaseHandler.execAction(addQuery);

    //Opens VehicleViewer scene after adding data into database
    Parent addNewParent = FXMLLoader.load(getClass().getResource("VehicleViewer.fxml"));
    Scene addNewScene = new Scene(addNewParent);
    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    window.setScene(addNewScene);
    window.show();
  }

  /**
   * Cancel button opens VehicleViewer scene.
   */
  @FXML
  private void cancel(ActionEvent event) throws Exception {
    Parent addNewParent = FXMLLoader.load(getClass().getResource("VehicleViewer.fxml"));
    Scene addNewScene = new Scene(addNewParent);

    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    window.setScene(addNewScene);
    window.show();
  }

}
