package employeeform;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import customerform.CustomerForm;
import rentalmanagementclasses.Customer;
import rentalmanagementclasses.Property;
import rentalmanagementclasses.employee;



public class employeeform implements ActionListener {
    JFrame frame;
    JLabel EmployeeIDLabel = new JLabel("Employee ID");
    JLabel firstNameLabel = new JLabel("First Name");
    JLabel lastNameLabel = new JLabel("Last Name"); 
    JLabel position = new JLabel("position");
    JLabel emailLabel = new JLabel("Email");
    JLabel phoneLabel = new JLabel("Phone");

    JTextField EmployeeIDTextField = new JTextField();
    JTextField firstNameTextField = new JTextField();
    JTextField lastNameTextField = new JTextField();
    JTextField positionTextField = new JTextField();
    JTextField emailTextField = new JTextField();
    JTextField phoneTextField = new JTextField();

    JButton insertButton = new JButton("Insert");
    JButton viewButton = new JButton("View");
    JButton updateButton = new JButton("Update");
    JButton deleteButton = new JButton("Delete");
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);


    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int) screenSize.getWidth();
    int height = (int) screenSize.getHeight();

    public employeeform() {
        createForm();
        addActionListeners();
        setLocationAndSize();
        setFontForAll();
        addComponentsToFrame();
    }

    private void addActionListeners() {
        insertButton.addActionListener(this);
        viewButton.addActionListener(this);
        deleteButton.addActionListener(this);
        updateButton.addActionListener(this);
    }

    private void createForm() {
        frame = new JFrame();
        frame.setTitle("Employee Form");
        frame.setBounds(0, 0, width / 2, height / 2);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.blue);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
    }

    private void setLocationAndSize() {
        int labelX = 10, labelWidth = 150;
        int textFieldX = 160, textFieldWidth = 250;
        int startY = 10, spacingY = 60;

        EmployeeIDLabel.setBounds(labelX, startY, labelWidth, 30);
        firstNameLabel.setBounds(labelX, startY + spacingY, labelWidth, 30);
        lastNameLabel.setBounds(labelX, startY + 2 * spacingY, labelWidth, 30);
        position.setBounds(labelX, startY + 3 * spacingY, labelWidth, 30);
        emailLabel.setBounds(labelX, startY + 4 * spacingY, labelWidth, 30);
        phoneLabel.setBounds(labelX, startY + 5 * spacingY, labelWidth, 30);

        EmployeeIDTextField.setBounds(textFieldX, startY, textFieldWidth, 30);
        firstNameTextField.setBounds(textFieldX, startY + spacingY, textFieldWidth, 30);
        lastNameTextField.setBounds(textFieldX, startY + 2 * spacingY, textFieldWidth, 30);
        positionTextField.setBounds(textFieldX, startY + 3 * spacingY, textFieldWidth, 30);
        emailTextField.setBounds(textFieldX, startY + 4 * spacingY, textFieldWidth, 30);
        phoneTextField.setBounds(textFieldX, startY + 5 * spacingY, textFieldWidth, 30);

        insertButton.setBounds(labelX, 450, 90, 30);
        viewButton.setBounds(labelX + 100, 450, 90, 30);
        updateButton.setBounds(labelX + 200, 450, 90, 30);
        deleteButton.setBounds(labelX + 300, 450, 90, 30);
        table.setBounds(450, 10, 600, 300);
    }

    private void setFontForAll() {
        Font font = new Font("Times New Roman", Font.BOLD, 14);

        EmployeeIDLabel.setFont(font);
        firstNameLabel.setFont(font);
        lastNameLabel.setFont(font);
        position.setFont(font);
        emailLabel.setFont(font);
        phoneLabel.setFont(font);

        EmployeeIDTextField.setFont(font);
        firstNameTextField.setFont(font);
        lastNameTextField.setFont(font);
        positionTextField.setFont(font);
        emailTextField.setFont(font);
        phoneTextField.setFont(font);

        Font buttonFont = new Font("Arial", Font.BOLD, 16);
        insertButton.setFont(buttonFont);
        viewButton.setFont(buttonFont);
        updateButton.setFont(buttonFont);
        deleteButton.setFont(buttonFont);
    }

    private void addComponentsToFrame() {
        frame.add(EmployeeIDLabel);
        frame.add(firstNameLabel);
        frame.add(lastNameLabel);
        frame.add(position);
        frame.add(emailLabel);
        frame.add(phoneLabel);

        frame.add(EmployeeIDTextField);
        frame.add(firstNameTextField);
        frame.add(lastNameTextField);
        frame.add(positionTextField);
        frame.add(emailTextField);
        frame.add(phoneTextField);

        frame.add(insertButton);
        frame.add(viewButton);
        frame.add(deleteButton);
        frame.add(updateButton);
        frame.add(table);
    }

	/*@Override
	public void actionPerformed(ActionEvent e) {
		employee emp= new employee();
		
		if(e.getSource()==insertButton) {
			emp.setFirstName(firstNameTextField.getText());
			emp.setLastName(lastNameTextField.getText());
			emp.setEmail(emailTextField.getText());
			emp.setPhone(phoneTextField.getText());
			
		    emp.insertData();
		    }
    }
	
	else if (e.getSource() == viewButton) {
        model.setColumnCount(0);
        model.setRowCount(0);
        model.addColumn("CustomerID");
        model.addColumn("firstName");
        model.addColumn("lastName");
        model.addColumn("email");
        model.addColumn("phone");


        ResultSet resultSet = Customer.viewData();
        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                            resultSet.getString(3), resultSet.getString(4), resultSet.getString(5)});
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
		
      else if (e.getSource()==updateButton) {
     	 int id=Integer.parseInt(EmployeeIDTextField.getText());
     	 
     	employee emp;
		emp.setFirstName(firstNameTextField.getText());
			emp.setLastName(lastNameTextField.getText());
			emp.setEmail(emailTextField.getText());
			emp.setPhone(phoneTextField.getText());
			emp.update(id);
			}
      else {
			int id1=Integer.parseInt(EmployeeIDTextField.getText());
			emp.delete(id1);
			}
}}
				

	public static void main(String[] args) {
		employeeform empf = new employeeform();
		     System.out.println(empf);
		 }
		}*/
    @Override
	   public void actionPerformed(ActionEvent e) {
			employee emp=new employee();
			if(e.getSource()==insertButton) {
		
				emp.setFirstName(firstNameTextField.getText());
				emp.setLastName(lastNameTextField.getText());
				emp.setLastName(positionTextField.getText());
				emp.setEmail(emailTextField.getText());
				emp.setPhone(phoneTextField.getText());
				
			    emp.insertData();
			    }
			else if (e.getSource() == viewButton) {
	            model.setColumnCount(0);
	            model.setRowCount(0);
	            model.addColumn("EmployeeID");
	            model.addColumn("firstName");
	            model.addColumn("lastName");
	            model.addColumn("position");
	            model.addColumn("email");
	            model.addColumn("phone");


	            ResultSet resultSet = employee.viewData();
	            if (resultSet != null) {
	                try {
	                    while (resultSet.next()) {
	                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
	                                resultSet.getString(3), resultSet.getString(4),  resultSet.getString(5) });
	                    }
	                } catch (SQLException ex) {
	                    ex.printStackTrace();
	                }
	            }
	        }

			
          else if (e.getSource()==updateButton) {
         	 int id=Integer.parseInt(EmployeeIDTextField.getText());
         	 
         	 emp.setFirstName(firstNameTextField.getText());
				emp.setLastName(lastNameTextField.getText());
				emp.setPosition(positionTextField.getText());
				emp.setEmail(emailTextField.getText());
				emp.setPhone(phoneTextField.getText());
				emp.update(id);
				}
          else {
				int id=Integer.parseInt(EmployeeIDTextField.getText());
				emp.delete(id);}
		
          }
 

 public static void main(String[] args) {
	 employeeform   emp = new  employeeform ();
     System.out.println(emp);
 }
}

		
