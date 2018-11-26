/**
 * Name:DBHandler.java. Author: Alejandro Sanchez. Description: This class is instantiated when a
 * connection to the database is needed
 */

package DBProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class DBHandler {


  public static final String DB_URL = "jdbc:derby:lib/GUIprojectDB;create=true";
  private Connection conn = null;
  private Statement stmt = null;

  /**
   * Constructor that creates a connection to database whenever it is initialized
   */
  public DBHandler() {
    createConnection();
  }


  /**
   * createConnection method creates a connection to the database
   */
  void createConnection() {
    try {
      Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
      conn = DriverManager.getConnection(DB_URL);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Function that recieves a query statement and returns a Resultset.
   * Used when retrieving from database
   * @param query
   * @return Resultset
   */
  public ResultSet execQuery(String query) {
    ResultSet result;
    try {
      stmt = conn.createStatement();
      result = stmt.executeQuery(query);

    } catch (SQLException ex) {
      ex.getLocalizedMessage();
      return null;
    } finally {
    }
    return result;
  }

  /**
   * Function that recives a query statement and executes it.
   * Used when editing the database
   * @param query
   */
  public void execAction(String query) {
    try {
      stmt = conn.createStatement();
      stmt.execute(query);
    } catch (SQLException ex) {
      ex.getLocalizedMessage();
    } finally {
    }
  }
}

