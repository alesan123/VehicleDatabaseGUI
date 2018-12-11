/**
 * Name:Vehicle.java. Author: Alejandro Sanchez. Description: Class is used to create Vehicle
 * objects which store data
 */

package dbproject;

public class Vehicle {

  private String vin;
  private String make;
  private String model;
  private String year;
  private String mileage;
  private String price;

  /**
   * Constructor creates Vehicle.
   *
   * @param vin vin number.
   * @param make make
   * @param model model
   * @param year year
   * @param mileage mileage
   * @param price price
   */
  public Vehicle(String vin, String make, String model, String year, String mileage,
      String price) {
    this.vin = vin;
    this.make = make;
    this.model = model;
    this.year = year;
    this.mileage = mileage;
    this.price = price;
  }


  public String getVin() {
    return vin;
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
