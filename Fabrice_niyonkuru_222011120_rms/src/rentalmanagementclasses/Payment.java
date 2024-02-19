package rentalmanagementclasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Payment {
    private int paymentID;
    private String leaseID;
    private String paymentDate;
    private String amount;
	public Payment() {
		super();
	}
	public Payment(int paymentID, String leaseID, String paymentDate, String amount) {
		super();
		this.paymentID = paymentID;
		this.leaseID = leaseID;
		this.paymentDate = paymentDate;
		this.amount = amount;
	}
	public int getPaymentID() {
		return paymentID;
	} 
	public void setPaymentID(int paymentID) {
		this.paymentID = paymentID;
	}
	public String getLeaseID() {
		return leaseID;
	}
	public void setLeaseID(String leaseID) {
		this.leaseID = leaseID;
	}
	public String getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}


	public void makeconnection() {
	}
			public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/niyonkuru_fabrice_rentalmanagementsystem";
	    String user = "222011120";
	    String password = "222011120";

	    // SQL query to insert data
	    String sql = "INSERT INTO payments(	PaymentID , LeaseID, PaymentDate, Amount) VALUES (?,?,?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       
	        preparedStatement.setInt(1, this.	paymentID);
	        preparedStatement.setString(2, this.leaseID);
	        preparedStatement.setString(3, this.paymentDate);
	        preparedStatement.setString(4, this.amount);
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

			        String sql = "SELECT * FROM payments";

			        try {
			            Connection con = DriverManager.getConnection(host, user, password);
			            PreparedStatement preparedStatement = con.prepareStatement(sql);
			            return preparedStatement.executeQuery();
			        } catch (SQLException e) {
			            e.printStackTrace();
			            return null;
			        }
			    }


	public void update(int inputpaymentID) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/niyonkuru_fabrice_rentalmanagementsystem";
	    String user = "222011120";
	    String password = "222011120";

	    // SQL query to update data
	    String sql ="UPDATE payments SET LeaseID=?, PaymentDate=?, Amount=? WHERE  PaymentID =?";

	    try (
	        // Establish the co
	        Connection co = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pay= co.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	
	        pay.setString(1, this.getLeaseID());
	        pay.setString(2, this.getPaymentDate());
	        pay.setString(3, this.getAmount());
	        
	     pay.setInt(4,inputpaymentID);
	        // Execute the update
	        int rowsAffected = pay.executeUpdate();

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
	public void delete(int inputpaymentID) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/niyonkuru_fabrice_rentalmanagementsystem";
	    String user = "222011120";
	    String password = "222011120";

	    // SQL query to delete data
	    String sql = "DELETE FROM payments WHERE PaymentID=?";

	    try (
	        // Establish the 
	        Connection co = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = co.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        pl.setInt(1, inputpaymentID); // Assuming there is a column named 'id' for the WHERE clause

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



