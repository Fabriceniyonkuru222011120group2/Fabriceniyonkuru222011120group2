package rentalmanagementclasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class User{
    private int userID;
    private String username;
    private String password;
    private String customerID;
	
    public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(int userID, String username, String password, String customerID) {
		
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.customerID = customerID;
	}
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

   
	public void makeconnection() {
	}
			public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/rental_management_system";
	    String user = "root";
	    String password = "";

	    // SQL query to insert data
	    String sql = "insert INTO users(Username, 	Password, 	CustomerID ) VALUES (?,?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       
	       
	        preparedStatement.setString(1, this.username);
	        preparedStatement.setString(2, this.password);
	        preparedStatement.setString(3, this.customerID);
	     
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

	/*public void readwithID(int inputid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/product_delivery_app_system";
	    String user = "root";
	    String password = "";

	    // SQL query to select all columns from student where id = ?
	    String sql = "SELECT * FROM vendor WHERE vid = ?";

	    try (
	        // Establish the connection
	        Connection connection = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement preparedStatement = connection.prepareStatement(sql);
	    ) {
	        // Set the value for the parameterized query
	        //int studentId = 1; // Replace with the desired student id
	        //if()
	    	preparedStatement.setInt(1, inputid);

	        // Execute the query and get the result set
	        ResultSet resultSet = preparedStatement.executeQuery();

	        // Process the result set
	        while (resultSet.next()) {
	        	this.setEmp_id(resultSet.getInt("emp_id"));
	            this.setFname(resultSet.getString("fname"));
	            this.setLname(resultSet.getString("lname"));
	            this.setDob(resultSet.getString("dob"));
	            this.setPos(resultSet.getString("pos"));
	            this.setCont_info(resultSet.getString("cont_info"));
	            
	            
	            }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}*/


	public void update(int inputUserID) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/rental_management_system";
	    String user = "root";
	    String password = "";

	    // SQL query to update data
	    String sql ="UPDATE users SET UserID=?,Username=?,Password=?,CustomerID=? WHERE UserID=?";

	    try (
	        // Establish the co
	        Connection co = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement us= co.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	
	         us.setString(1, this.getUsername());
	        us.setString(2, this.getPassword());
	        us.setString(3, this.getCustomerID());
	        
	        
	       us.setInt(4,inputUserID);
	        // Execute the update
	        int rowsAffected = us.executeUpdate();

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
	public void delete(int inputUserID ) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/rental_management_system";
	    String user = "root";
	    String password = "";

	    // SQL query to delete data
	    String sql = "DELETE FROM leases WHERE UserID =?";

	    try (
	        // Establish the 
	        Connection co = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = co.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        pl.setInt(1, inputUserID ); // Assuming there is a column named 'id' for the WHERE clause

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



