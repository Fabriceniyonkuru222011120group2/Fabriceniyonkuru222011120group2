package rentalmanagementclasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class MaintenanceRequest {
    private int requestID;
    private String propertyID;
    private String description;
    private String dateRequested;
    private String status;
	public MaintenanceRequest() {
		super();
	}
	public MaintenanceRequest(int requestID, String propertyID, String description, String dateRequested, String status) {
		super();
		this.requestID = requestID;
		this.propertyID = propertyID;
		this.description = description;
		this.dateRequested = dateRequested;
		this.status = status;
	} 
	public int getRequestID() {
		return requestID;
	}
	public void setRequestID(int requestID) {
		this.requestID = requestID;
	}
	public String getPropertyID() {
		return propertyID;
	}
	public void setPropertyID(String propertyID) {
		this.propertyID = propertyID;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDateRequested() {
		return dateRequested;
	}
	public void setDateRequested(String dateRequested) {
		this.dateRequested = dateRequested;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}


	public void makeconnection() {
	}
			public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/niyonkuru_fabrice_rentalmanagementsystem";
	    String user = "222011120";
	    String password = "222011120";

	    // SQL query to insert data
	    String sql = "INSERT INTO maintenancerequests(RequestID , PropertyID, Description, 	DateRequested,	Status	) VALUES (?,?,?,?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       
	        preparedStatement.setInt(1, this.requestID);
	        preparedStatement.setString(2, this.propertyID);
	        preparedStatement.setString(3, this.description);
	        preparedStatement.setString(4, this.dateRequested);
	        preparedStatement.setString(5, this.status);
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

			        String sql = "SELECT * FROM maintenancerequests";

			        try {
			            Connection con = DriverManager.getConnection(host, user, password);
			            PreparedStatement preparedStatement = con.prepareStatement(sql);
			            return preparedStatement.executeQuery();
			        } catch (SQLException e) {
			            e.printStackTrace();
			            return null;
			        }
			    }


	public void update(int inputRequestID) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/niyonkuru_fabrice_rentalmanagementsystem";
	    String user = "222011120";
	    String password = "222011120";

	    // SQL query to update data
	    String sql ="UPDATE maintenancerequests SET PropertyID=?,Description=?,DateRequested=?,Status=? WHERE RequestID=?";

	    try (
	        // Establish the co
	        Connection co = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement req= co.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	
	         req.setString(1, this.getPropertyID());
	        req.setString(2, this.getDescription());
	        req.setString(3, this.getDateRequested());
	        req.setString(4, this.getStatus());
	        
	       req.setInt(5,inputRequestID);
	        // Execute the update
	        int rowsAffected = req.executeUpdate();

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
	public void delete(int inputRequestID) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/niyonkuru_fabrice_rentalmanagementsystem";
	    String user = "222011120";
	    String password = "222011120";

	    // SQL query to delete data
	    String sql = "DELETE FROM maintenancerequests WHERE RequestID=?";

	    try (
	        // Establish the 
	        Connection co = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = co.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        pl.setInt(1, inputRequestID); // Assuming there is a column named 'id' for the WHERE clause

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



