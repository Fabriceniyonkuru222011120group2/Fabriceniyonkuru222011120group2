package rentalmanagementclasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Property {
    private int propertyID;
    private String address;
    private String type;
    private String bedrooms;
    private String bathrooms;
    private String monthlyRent;
	public Property() {
		super();
	}
		public Property(int propertyID, String address, String type, String bedrooms, String bathrooms, String monthlyRent)  {
	super();
	this.propertyID = propertyID;
	this.address = address;
	this.type = type;
	this.bedrooms = bedrooms;
	this.bathrooms =bathrooms;
	this.monthlyRent=monthlyRent;

			
		}
	
	public int getPropertyID() {
		return propertyID;
	}
	public void setPropertyID(int propertyID) {
		this.propertyID = propertyID;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBedrooms() {
		return bedrooms;
	}
	public void setBedrooms(String bedrooms) {
		this.bedrooms = bedrooms;
	}
	public String getBathrooms() {
		return bathrooms;
	}
	public void setBathrooms(String bathrooms) {
		this.bathrooms = bathrooms;
	}
	public String getMonthlyRent() {
		return monthlyRent;
	}
	public void setMonthlyRent(String monthlyRent) {
		this.monthlyRent = monthlyRent;
	}

   
	public void makeconnection() {
	}
			public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/niyonkuru_fabrice_rentalmanagementsystem";
	    String user = "222011120";
	    String password = "222011120";

	    // SQL query to insert data
	    String sql = "INSERT INTO properties(PropertyID, Address, Type, Bedrooms,Bathrooms,MonthlyRent	) VALUES (?,?,?,?,?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       
	        preparedStatement.setInt(1, this.propertyID);
	        preparedStatement.setString(2, this.address);
	        preparedStatement.setString(3, this.type);
	        preparedStatement.setString(4, this.bedrooms);
	        preparedStatement.setString(5, this.bathrooms);
	        preparedStatement.setString(6, this.monthlyRent);
	                // Execute the query
	        int rowsAffected = preparedStatement.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	        	System.out.println("Data inserted sucessfully");
	            JOptionPane.showMessageDialog(null, "Data inserted successfully!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to insert data.");
	            JOptionPane.showMessageDialog(null, "Failed to inserted data.!","After insert",JOptionPane.ERROR_MESSAGE);

	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }	
	}

			 public static ResultSet viewData() {
			        String host = "jdbc:mysql://localhost/niyonkuru_fabrice_rentalmanagementsystem";
			        String user = "222011120";
			        String password = "222011120";

			        String sql = "SELECT * FROM properties";

			        try {
			            Connection con = DriverManager.getConnection(host, user, password);
			            PreparedStatement preparedStatement = con.prepareStatement(sql);
			            return preparedStatement.executeQuery();
			        } catch (SQLException e) {
			            e.printStackTrace();
			            return null;
			        }
			    }


	public void update(int inputPropertyID) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/niyonkuru_fabrice_rentalmanagementsystem";
	    String user = "222011120";
	    String password = "222011120";

	    // SQL query to update data
	    String sql ="UPDATE properties SET	Address=?,Type=?,Bedrooms=?,Bathrooms=?,MonthlyRent=? WHERE PropertyID=?";

	    try (
	        // Establish the co
	        Connection co = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pro= co.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	
	         pro.setString(1, this.getAddress());
	        pro.setString(2, this.getType());
	        pro.setString(3, this.getBedrooms());
	        pro.setString(4, this.getBathrooms());
	        pro.setString(5, this.getMonthlyRent());
	       pro.setInt(6,inputPropertyID);
	        // Execute the update
	        int rowsAffected = pro.executeUpdate();

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
	public void delete(int inputPropertyID) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/niyonkuru_fabrice_rentalmanagementsystem";
	    String user = "222011120";
	    String password = "222011120";

	    // SQL query to delete data
	    String sql = "DELETE FROM properties WHERE PropertyID=?";

	    try (
	        // Establish the 
	        Connection co = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = co.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        pl.setInt(1, inputPropertyID); // Assuming there is a column named 'id' for the WHERE clause

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


