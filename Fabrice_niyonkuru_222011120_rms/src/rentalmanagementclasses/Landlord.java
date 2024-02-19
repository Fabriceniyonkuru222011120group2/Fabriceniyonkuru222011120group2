package rentalmanagementclasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Landlord {
    private int landlordID;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    // Constructors, getters, setters

    public Landlord(int landlordID, String firstName, String lastName, String email, String phone) {
        this.landlordID = landlordID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    // Add getters and setters for each field

    public Landlord() {
		// TODO Auto-generated constructor stub
	}

	public int getLandlordID() {
        return landlordID;
    }

    public void setLandlordID(int landlordID) {
        this.landlordID = landlordID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

public void makeconnection() {
}
		public void insertData() {
	// JDBC URL, username, and password of MySQL server
    String host = "jdbc:mysql://localhost/niyonkuru_fabrice_rentalmanagementsystem";
    String user = "222011120";
    String password = "222011120";

    // SQL query to insert data
    String sql = "INSERT INTO landlords(LandlordID, FirstName, LastName, Email, Phone) VALUES (?,?,?,?,?)";
	
    try (
        // Establish the connection
        Connection con = DriverManager.getConnection(host, user, password);

        // Create a prepared statement
    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
    	    ) {
        // Set the values for the prepared statement
       
        preparedStatement.setInt(1, this.landlordID);
        preparedStatement.setString(2, this.firstName);
        preparedStatement.setString(3, this.lastName);
        preparedStatement.setString(4, this.email);
        preparedStatement.setString(5, this.phone);
                // Execute the query
        int rowsAffected = preparedStatement.executeUpdate();

        // Check the result
        if (rowsAffected > 0) {
        	System.out.println("Data inserted sucessfully");
            JOptionPane.showMessageDialog(null, "Data inserted successfully!","After insert",JOptionPane.INFORMATION_MESSAGE);
        } else {
            System.out.println("Failed to insert data.");
            JOptionPane.showMessageDialog(null, "Failed to be inserted data.!","After insert",JOptionPane.ERROR_MESSAGE);

        }

    } catch (SQLException e) {
        e.printStackTrace();
    }	
}

		 public static ResultSet viewData() {
		        String host = "jdbc:mysql://localhost/niyonkuru_fabrice_rentalmanagementsystem";
		        String user = "222011120";
		        String password = "222011120";

		        String sql = "SELECT * FROM landlords";

		        try {
		            Connection con = DriverManager.getConnection(host, user, password);
		            PreparedStatement preparedStatement = con.prepareStatement(sql);
		            return preparedStatement.executeQuery();
		        } catch (SQLException e) {
		            e.printStackTrace();
		            return null;
		        }
		    }
		

public void update(int inputlandlordID) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/niyonkuru_fabrice_rentalmanagementsystem";
    String user = "222011120";
    String password = "222011120";

    // SQL query to update data
    String sql = "UPDATE landlords SET   FirstName=?, LastName=?, Email=?, Phone=? WHERE LandlordID =?";

    try (
        // Establish the co
        Connection co = DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement lan= co.prepareStatement(sql);
    ) {
        // Set the new values for the update
    	
         lan.setString(1, this.getFirstName());
         lan.setString(2, this.getLastName());
         lan.setString(3, this.getEmail());
         lan.setString(4, this.getPhone());
        
       lan.setInt(5,inputlandlordID);
        // Execute the update
        int rowsAffected = lan.executeUpdate();

        // Check the result
        if (rowsAffected > 0) {
            System.out.println("Data updated successfully!");
            JOptionPane.showMessageDialog(null, "Data updated successfully!","After update",JOptionPane.INFORMATION_MESSAGE);
        } else {
            System.out.println("Failed to update data. No matching record found.");
            JOptionPane.showMessageDialog(null, "Failed to update data!","After update",JOptionPane.INFORMATION_MESSAGE);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }   
}
public void delete(int inputlandlordID) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/niyonkuru_fabrice_rentalmanagementsystem";
    String user = "222011120";
    String password = "222011120";

    // SQL query to delete data
    String sql = "DELETE FROM landlords WHERE landlordID=?";

    try (
        // Establish the 
        Connection co = DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement pl = co.prepareStatement(sql);
    ) {
        // Set the value for the WHERE clause
        pl.setInt(1, inputlandlordID); // Assuming there is a column named 'id' for the WHERE clause

        // Execute the delete
        int rowsAffected = pl.executeUpdate();

        // Check the result
        if (rowsAffected > 0) {
            System.out.println("Data deleted successfully!");
            JOptionPane.showMessageDialog(null, "Data deleted successfully!","After delete",JOptionPane.INFORMATION_MESSAGE);
        } else {
            System.out.println("Failed to delete data. No matching record found.");
            JOptionPane.showMessageDialog(null, "Failed to delete data!","After delete",JOptionPane.INFORMATION_MESSAGE);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
}
}


