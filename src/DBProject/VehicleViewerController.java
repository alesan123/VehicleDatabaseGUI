/**
 * Name:VehicleViewerController.java. Author: Alejandro Sanchez. Description: Used to populate
 * VehicleViewer.fxml with data from the database
 */

package DBProject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class VehicleViewerController {

  @FXML
  private TableView<Vehicle> tableView;
  @FXML
  private TableColumn vinCol;
  @FXML
  private TableColumn makeCol;
  @FXML
  private TableColumn modelCol;
  @FXML
  private TableColumn yearCol;
  @FXML
  private TableColumn mileageCol;
  @FXML
  private TableColumn priceCol;

  static ObservableList<Vehicle> itemList;
  public int index;

  /**
   * calls initializeTable() function.
   */
  public void initialize() {
    initializeTable();
  }

  /**
   * Updates the ViewTable.
   */
  private void initializeTable() {
    //Connects to database
    DBHandler handler = new DBHandler();
    final String query = "SELECT * FROM VEHICLE";
    ResultSet rs = handler.execQuery(query);

    itemList = FXCollections.observableArrayList();

    try {
      //Data retrieved from database goes into the parameters of Vehicle, creating Vehicle objects.
      while (rs.next()) {
        Vehicle vehicle = new Vehicle(
            rs.getString("VIN"),
            rs.getString("MAKE"),
            rs.getString("MODEL"),
            rs.getString("MANUFYEAR"),
            rs.getString("MILEAGE"),
            rs.getString("PRICE"));

        //Adds vehicle objects to ObservableList.
        itemList.add(vehicle);
      }
      //Populates the columns on the table with data from each object.
      vinCol.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("VIN"));
      makeCol.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("make"));
      modelCol.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("model"));
      yearCol.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("year"));
      mileageCol.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("mileage"));
      priceCol.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("price"));

      tableView.setItems(itemList);

    } catch (SQLException e) {
      e.getLocalizedMessage();
    }
  }

  /**
   * Add Vehicle button opens a new scene which prompts user to enter data for a new Vehicle
   */
  public void addVehicle(ActionEvent event) throws Exception {
    Parent addNewParent = FXMLLoader.load(getClass().getResource("AddVehicle.fxml"));
    Scene addNewScene = new Scene(addNewParent);

    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    window.setScene(addNewScene);
    window.show();
  }

  /**
   * Function deletes selected Vehicle
   */
  public void deleteVehicle(ActionEvent event) {
    //Creates object named clickedOn whenever a row is selected on the tableView
    Vehicle clickedOn = tableView.getSelectionModel().getSelectedItem();
    //It only deletes whenever a row is selected
    if (clickedOn != null) {
      final String delete = "DELETE FROM VEHICLE WHERE VIN = '" + clickedOn.getVIN() + "'";
      DBHandler handler = new DBHandler();
      handler.execAction(delete);
      initializeTable();
    }


  }
}

