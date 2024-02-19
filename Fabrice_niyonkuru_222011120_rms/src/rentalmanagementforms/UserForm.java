package rentalmanagementforms;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import rentalmanagementclasses.User;

public class UserForm {
    JFrame frame;
    JLabel userIDLabel = new JLabel("User ID");
    JLabel usernameLabel = new JLabel("Username");
    JLabel passwordLabel = new JLabel("Password");
    JLabel customerIDLabel = new JLabel("Customer ID");

    JTextField userIDTextField = new JTextField();
    JTextField usernameTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JTextField customerIDTextField = new JTextField();

    JButton addButton = new JButton("Add");
    JButton updateButton = new JButton("Update");
    JButton deleteButton = new JButton("Delete");

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int) screenSize.getWidth();
    int height = (int) screenSize.getHeight();

    public UserForm() {
        createForm();
        setLocationAndSize();
        setFontForAll();
        addComponentsToFrame();
    }

    private void createForm() {
        frame = new JFrame();
        frame.setTitle("User Form");
        frame.setBounds(0, 0, width / 2, height / 2);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.GRAY);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
    }

    private void setLocationAndSize() {
        int labelX = 10, labelWidth = 150;
        int textFieldX = 160, textFieldWidth = 250;
        int startY = 10, spacingY = 60;

        userIDLabel.setBounds(labelX, startY, labelWidth, 30);
        usernameLabel.setBounds(labelX, startY + spacingY, labelWidth, 30);
        passwordLabel.setBounds(labelX, startY + 2 * spacingY, labelWidth, 30);
        customerIDLabel.setBounds(labelX, startY + 3 * spacingY, labelWidth, 30);

        userIDTextField.setBounds(textFieldX, startY, textFieldWidth, 30);
        usernameTextField.setBounds(textFieldX, startY + spacingY, textFieldWidth, 30);
        passwordField.setBounds(textFieldX, startY + 2 * spacingY, textFieldWidth, 30);
        customerIDTextField.setBounds(textFieldX, startY + 3 * spacingY, textFieldWidth, 30);

        addButton.setBounds(labelX, 310, 85, 30);
        updateButton.setBounds(labelX + 155, 310, 85, 30);
        deleteButton.setBounds(labelX + 310, 310, 85, 30);
    }

    private void setFontForAll() {
        Font font = new Font("Times New Roman", Font.BOLD, 18);

        userIDLabel.setFont(font);
        usernameLabel.setFont(font);
        passwordLabel.setFont(font);
        customerIDLabel.setFont(font);

        userIDTextField.setFont(font);
        usernameTextField.setFont(font);
        passwordField.setFont(font);
        customerIDTextField.setFont(font);

        Font buttonFont = new Font("Arial", Font.BOLD, 12);
        addButton.setFont(buttonFont);
        updateButton.setFont(buttonFont);
        deleteButton.setFont(buttonFont);
    }

    private void addComponentsToFrame() {
        frame.add(userIDLabel);
        frame.add(usernameLabel);
        frame.add(passwordLabel);
        frame.add(customerIDLabel);

        frame.add(userIDTextField);
        frame.add(usernameTextField);
        frame.add(passwordField);
        frame.add(customerIDTextField);

        frame.add(addButton);
        frame.add(updateButton);
        frame.add(deleteButton);
    }
   
  public void actionPerformed(ActionEvent e) {
			User us=new User();
			if(e.getSource()==addButton) {
		
				us.setUsername(usernameTextField.getText());
				us.setPassword((passwordField).getText());
				us.setCustomerID (customerIDTextField.getText());

				
			    us.insertData();
			    }

			
       else if (e.getSource()==updateButton) {
      	 int id=Integer.parseInt(userIDTextField.getText());
      	 
      	us.setUsername(usernameTextField.getText());
				us.setPassword(passwordField.getText());
				us.setCustomerID(customerIDTextField.getText());

				us.update(id);
				}
       else {
				int id=Integer.parseInt(userIDTextField.getText());
				us.delete(id);}
		
       }


public static void main(String[] args) {
 UserForm   us = new UserForm ();
  System.out.println(us);
}
}


