/**
 * Name:Vehicle.java. Author: Alejandro Sanchez. Description: Class is used to create Vehicle
 * objects which store data
 */

package DBProject;

public class Vehicle {

  private String VIN;
  private String make;
  private String model;
  private String year;
  private String mileage;
  private String price;

  public Vehicle(String VIN, String make, String model, String year, String mileage,
      String price) {
    this.VIN = VIN;
    this.make = make;
    this.model = model;
    this.year = year;
    this.mileage = mileage;
    this.price = price;
  }


  public String getVIN() {
    return VIN;
  }

  public String getMake() {
    return make;
  }

  public String getModel() {
    return model;
  }

  public String getYear() {
    return year;
  }

  public String getMileage() {
    return mileage;
  }

  public String getPrice() {
    return price;
  }

}
