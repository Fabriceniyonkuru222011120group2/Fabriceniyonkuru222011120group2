package landlordform;


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
import rentalmanagementclasses.Landlord;
import rentalmanagementclasses.Payment;

public class LandlordForm implements ActionListener {
    JFrame frame;
    JLabel landlordIDLabel = new JLabel("Landlord ID");
    JLabel firstNameLabel = new JLabel("First Name");
    JLabel lastNameLabel = new JLabel("Last Name");
    JLabel emailLabel = new JLabel("Email");
    JLabel phoneLabel = new JLabel("Phone");

    JTextField landlordIDTextField = new JTextField();
    JTextField firstNameTextField = new JTextField();
    JTextField lastNameTextField = new JTextField();
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

    public LandlordForm() {
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
        frame.setTitle("Landlord Form");
        frame.setBounds(0, 0, width / 2, height / 2);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.pink);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
    }

    private void setLocationAndSize() {
        int labelX = 10, labelWidth = 150;
        int textFieldX = 160, textFieldWidth = 250;
        int startY = 10, spacingY = 60;

        landlordIDLabel.setBounds(labelX, startY, labelWidth, 30);
        firstNameLabel.setBounds(labelX, startY + spacingY, labelWidth, 30);
        lastNameLabel.setBounds(labelX, startY + 2 * spacingY, labelWidth, 30);
        emailLabel.setBounds(labelX, startY + 3 * spacingY, labelWidth, 30);
        phoneLabel.setBounds(labelX, startY + 4 * spacingY, labelWidth, 30);

        landlordIDTextField.setBounds(textFieldX, startY, textFieldWidth, 30);
        firstNameTextField.setBounds(textFieldX, startY + spacingY, textFieldWidth, 30);
        lastNameTextField.setBounds(textFieldX, startY + 2 * spacingY, textFieldWidth, 30);
        emailTextField.setBounds(textFieldX, startY + 3 * spacingY, textFieldWidth, 30);
        phoneTextField.setBounds(textFieldX, startY + 4 * spacingY, textFieldWidth, 30);

        insertButton.setBounds(labelX, 450, 90, 30);
        viewButton.setBounds(labelX + 100, 450, 90, 30);
        updateButton.setBounds(labelX + 200, 450, 90, 30);
        deleteButton.setBounds(labelX + 300, 450, 90, 30);
        
        table.setBounds(450, 10, 600, 300);
    }

    private void setFontForAll() {
        Font font = new Font("Times New Roman", Font.BOLD, 14);

        landlordIDLabel.setFont(font);
        firstNameLabel.setFont(font);
        lastNameLabel.setFont(font);
        emailLabel.setFont(font);
        phoneLabel.setFont(font);

        landlordIDTextField.setFont(font);
        firstNameTextField.setFont(font);
        lastNameTextField.setFont(font);
        emailTextField.setFont(font);
        phoneTextField.setFont(font);

        Font buttonFont = new Font("Arial", Font.BOLD, 16);
        insertButton.setFont(buttonFont);
        viewButton.setFont(buttonFont);
        updateButton.setFont(buttonFont);
        deleteButton.setFont(buttonFont);
    }

    private void addComponentsToFrame() {
        frame.add(landlordIDLabel);
        frame.add(firstNameLabel);
        frame.add(lastNameLabel);
        frame.add(emailLabel);
        frame.add(phoneLabel);

        frame.add(landlordIDTextField);
        frame.add(firstNameTextField);
        frame.add(lastNameTextField);
        frame.add(emailTextField);
        frame.add(phoneTextField);

        frame.add(insertButton);
        frame.add(viewButton);
        frame.add(deleteButton);
        frame.add(updateButton);
        frame.add(table);
    }


    @Override
	   public void actionPerformed(ActionEvent e) {
			Landlord lan= new Landlord();
			
			if(e.getSource()==insertButton) {
				lan.setFirstName(firstNameTextField.getText());
				lan.setLastName(lastNameTextField.getText());
				lan.setEmail(emailTextField.getText());
				lan.setPhone(phoneTextField.getText());
				
			    lan.insertData();
			    }
			else if (e.getSource() == viewButton) {
	            model.setColumnCount(0);
	            model.setRowCount(0);
	            model.addColumn("landlordID");
	            model.addColumn("firstName");
	            model.addColumn("lastName");
	            model.addColumn("email");
	            model.addColumn("phone");


	            ResultSet resultSet = Landlord.viewData();
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
         	 int id=Integer.parseInt(landlordIDTextField.getText());
         	 lan.setFirstName(firstNameTextField.getText());
				lan.setLastName(lastNameTextField.getText());
				lan.setEmail(emailTextField.getText());
				lan.setPhone(phoneTextField.getText());
				lan.update(id);
				}
          else {
				int id=Integer.parseInt(landlordIDTextField.getText());
				lan.delete(id);}
		
          }
 

 public static void main(String[] args) {
  LandlordForm form = new LandlordForm();
     System.out.println(form);
 }
}