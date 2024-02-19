package rentalmanagementclasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Lease {
    private int leaseID;
    private String customerID;
    private String propertyID;
    private String leaseStart;
    private String leaseEnd;
	public Lease() {
		super();
	} 
	public Lease(int leaseID, String customerID, String propertyID, String leaseStart, String leaseEnd) {
		super();
		this.leaseID = leaseID;
		this.customerID = customerID;
		this.propertyID = propertyID;
		this.leaseStart = leaseStart;
		this.leaseEnd = leaseEnd;
	}
	public int getLeaseID() {
		return leaseID;
	}
	public void setLeaseID(int leaseID) {
		this.leaseID = leaseID;
	}
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public String getPropertyID() {
		return propertyID;
	}
	public void setPropertyID(String propertyID) {
		this.propertyID = propertyID;
	}
	public String getLeaseStart() {
		return leaseStart;
	}
	public void setLeaseStart(String leaseStart) {
		this.leaseStart = leaseStart;
	}
	public String getLeaseEnd() {
		return leaseEnd;
	}
	public void setLeaseEnd(String leaseEnd) {
		this.leaseEnd = leaseEnd;
	}

	public void makeconnection() {
	}
			public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/niyonkuru_fabrice_rentalmanagementsystem";
	    String user = "222011120";
	    String password = "222011120";

	    // SQL query to insert data
	    String sql = "INSERT INTO leases(LeaseID, CustomerID, PropertyID, LeaseStart,LeaseEnd	) VALUES (?,?,?,?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       
	        preparedStatement.setInt(1, this.leaseID);
	        preparedStatement.setString(2, this.customerID);
	        preparedStatement.setString(3, this.propertyID);
	        preparedStatement.setString(4, this.leaseStart);
	        preparedStatement.setString(5, this.leaseEnd);
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

			        String sql = "SELECT * FROM leases";

			        try {
			            Connection con = DriverManager.getConnection(host, user, password);
			            PreparedStatement preparedStatement = con.prepareStatement(sql);
			            return preparedStatement.executeQuery();
			        } catch (SQLException e) {
			            e.printStackTrace();
			            return null;
			        }
			    }

	public void update(int inputLeaseID) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/niyonkuru_fabrice_rentalmanagementsystem";
	    String user = "222011120";
	    String password = "222011120";

	    // SQL query to update data
	    String sql ="UPDATE leases SET CustomerID=?,PropertyID=?,LeaseStart=?,LeaseEnd=? WHERE LeaseID=?";

	    try (
	        // Establish the co
	        Connection co = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement lea= co.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	
	         lea.setString(1, this.getCustomerID());
	        lea.setString(2, this.getPropertyID());
	        lea.setString(3, this.getLeaseStart());
	        lea.setString(4, this.getLeaseEnd());
	        
	       lea.setInt(5,inputLeaseID);
	        // Execute the update
	        int rowsAffected = lea.executeUpdate();

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
	public void delete(int inputLeaseID) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/niyonkuru_fabrice_rentalmanagementsystem";
	    String user = "222011120";
	    String password = "222011120";

	    // SQL query to delete data
	    String sql = "DELETE FROM leases WHERE LeaseID=?";

	    try (
	        // Establish the 
	        Connection co = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = co.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        pl.setInt(1, inputLeaseID); // Assuming there is a column named 'id' for the WHERE clause

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

