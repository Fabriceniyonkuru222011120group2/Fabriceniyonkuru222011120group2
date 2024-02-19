package rentalmanagementclasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class employee {
    private int employeeID;
    private String firstName;
    private String lastName;
    private String position;
    private String email;
    private String phone;

    // Constructors, getters, setters

    public employee(int employeeID, String firstName, String lastName, String position, String email, String phone) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.email = email;
        this.phone = phone;
    }

    // Add getters and setters for each field

    public employee() {
		// TODO Auto-generated constructor stub
	}

	public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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

	public void insertData1() {
		// TODO Auto-generated method stub
		
	}

	public void update1(int id) {
		// TODO Auto-generated method stub
		
	}

	public void delete1(int id) {
		// TODO Auto-generated method stub
		
	}
	public void makeconnection() {
	}
			public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/niyonkuru_fabrice_rentalmanagementsystem";
	    String user = "222011120";
	    String password = "222011120";

	    // SQL query to insert data
	    String sql = "INSERT INTO employees(EmployeeID , FirstName, LastName,Position, 	Email, 	Phone) VALUES (?,?,?,?,?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       
	        preparedStatement.setInt(1, this.employeeID );
	        preparedStatement.setString(2, this.firstName);
	        preparedStatement.setString(3, this.lastName);
	        preparedStatement.setString(4, this.position);
	        preparedStatement.setString(5, this.email);
	        preparedStatement.setString(6, this.phone);
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

			        String sql = "SELECT * FROM customers";

			        try {
			            Connection con = DriverManager.getConnection(host, user, password);
			            PreparedStatement preparedStatement = con.prepareStatement(sql);
			            return preparedStatement.executeQuery();
			        } catch (SQLException e) {
			            e.printStackTrace();
			            return null;
			        }
			    }


	public void update(int inputEmployeeID) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/niyonkuru_fabrice_rentalmanagementsystem";
	    String user = "222011120";
	    String password = "222011120";

	    // SQL query to update data
	    String sql = "UPDATE employees SET   FirstName=?, LastName=?, Position=?, Email=?, Phone=? WHERE EmployeeID  =?";

	    try (
	        // Establish the co
	        Connection co = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement emp= co.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	
	        emp.setString(1, this.getFirstName());
	         emp.setString(2, this.getLastName());
	         emp.setString(3, this.getPosition());
	         emp.setString(4, this.getEmail());
	         emp.setString(5, this.getPhone());
	        
	       emp.setInt(6,inputEmployeeID);
	        // Execute the update
	        int rowsAffected = emp.executeUpdate();

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
	public void delete(int inputEmployeeID) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/niyonkuru_fabrice_rentalmanagementsystem";
	    String user = "222011120";
	    String password = "222011120";

	    // SQL query to delete data
	    String sql = "DELETE FROM employees WHERE EmployeeID=?";

	    try (
	        // Establish the 
	        Connection co = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = co.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        pl.setInt(1, inputEmployeeID); // Assuming there is a column named 'id' for the WHERE clause

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



