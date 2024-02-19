package propertiesform;


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

import rentalmanagementclasses.Property;

public class PropertyForm implements ActionListener {
    JFrame frame;
    JLabel propertyIDLabel = new JLabel("Property ID");
    JLabel addressLabel = new JLabel("Address");
    JLabel typeLabel = new JLabel("Type");
    JLabel bedroomsLabel = new JLabel("Bedrooms");
    JLabel bathroomsLabel = new JLabel("Bathrooms");
    JLabel monthlyRentLabel = new JLabel("Monthly Rent");

    JTextField propertyIDTextField = new JTextField();
    JTextField addressTextField = new JTextField();
    JTextField typeTextField = new JTextField();
    JTextField bedroomsTextField = new JTextField();
    JTextField bathroomsTextField = new JTextField();
    JTextField monthlyRentTextField = new JTextField();
    JButton insertButton = new JButton("Insert");
    JButton viewButton = new JButton("View");
    JButton updateButton = new JButton("Update");
    JButton deleteButton = new JButton("Delete");
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int) screenSize.getWidth();
    int height = (int) screenSize.getHeight();

    public PropertyForm() {
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
        frame.setTitle("Property Form");
        frame.setBounds(0, 0, width / 2, height / 2);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
    }

    private void setLocationAndSize() {
        int labelX = 10, labelWidth = 150;
        int textFieldX = 160, textFieldWidth = 250;
        int startY = 10, spacingY = 60;

        propertyIDLabel.setBounds(labelX, startY, labelWidth, 30);
        addressLabel.setBounds(labelX, startY + spacingY, labelWidth, 30);
        typeLabel.setBounds(labelX, startY + 2 * spacingY, labelWidth, 30);
        bedroomsLabel.setBounds(labelX, startY + 3 * spacingY, labelWidth, 30);
        bathroomsLabel.setBounds(labelX, startY + 4 * spacingY, labelWidth, 30);
        monthlyRentLabel.setBounds(labelX, startY + 5 * spacingY, labelWidth, 30);

        propertyIDTextField.setBounds(textFieldX, startY, textFieldWidth, 30);
        addressTextField.setBounds(textFieldX, startY + spacingY, textFieldWidth, 30);
        typeTextField.setBounds(textFieldX, startY + 2 * spacingY, textFieldWidth, 30);
        bedroomsTextField.setBounds(textFieldX, startY + 3 * spacingY, textFieldWidth, 30);
        bathroomsTextField.setBounds(textFieldX, startY + 4 * spacingY, textFieldWidth, 30);
        monthlyRentTextField.setBounds(textFieldX, startY + 5 * spacingY, textFieldWidth, 30);

        insertButton.setBounds(labelX, 450, 90, 30);
        viewButton.setBounds(labelX + 100, 450, 90, 30);
        updateButton.setBounds(labelX + 200, 450, 90, 30);
        deleteButton.setBounds(labelX + 300, 450, 90, 30);
        table.setBounds(450, 10, 600, 300);
    }

    private void setFontForAll() {
        Font font = new Font("Times New Roman", Font.BOLD, 14);

        propertyIDLabel.setFont(font);
        addressLabel.setFont(font);
        typeLabel.setFont(font);
        bedroomsLabel.setFont(font);
        bathroomsLabel.setFont(font);
        monthlyRentLabel.setFont(font);

        propertyIDTextField.setFont(font);
        addressTextField.setFont(font);
        typeTextField.setFont(font);
        bedroomsTextField.setFont(font);
        bathroomsTextField.setFont(font);
        monthlyRentTextField.setFont(font);

        Font buttonFont = new Font("Arial", Font.BOLD, 16);
        insertButton.setFont(buttonFont);
        viewButton.setFont(buttonFont);
        updateButton.setFont(buttonFont);
        deleteButton.setFont(buttonFont);
    }

    private void addComponentsToFrame() {
        frame.add(propertyIDLabel);
        frame.add(addressLabel);
        frame.add(typeLabel);
        frame.add(bedroomsLabel);
        frame.add(bathroomsLabel);
        frame.add(monthlyRentLabel);

        frame.add(propertyIDTextField);
        frame.add(addressTextField);
        frame.add(typeTextField);
        frame.add(bedroomsTextField);
        frame.add(bathroomsTextField);
        frame.add(monthlyRentTextField);

        frame.add(insertButton);
        frame.add(viewButton);
        frame.add(deleteButton);
        frame.add(updateButton);
        frame.add(table);
    }


    @Override
	   public void actionPerformed(ActionEvent e) {
			Property pro=new Property();
			if(e.getSource()==insertButton) {
		
				pro.setAddress(addressTextField.getText());
				pro.setType(	typeTextField.getText());
				pro.setBedrooms(bedroomsTextField.getText());
				pro.setBathrooms(bathroomsTextField.getText());
				pro.setMonthlyRent(monthlyRentTextField.getText());
				
			    pro.insertData();
			    }
			else if (e.getSource() == viewButton) {
	            model.setColumnCount(0);
	            model.setRowCount(0);
	            model.addColumn("propertyID");
	            model.addColumn("address");
	            model.addColumn("type");
	            model.addColumn("bedrooms");
	            model.addColumn("bathrooms");
	            model.addColumn("monthlyRent");


	            ResultSet resultSet = Property.viewData();
	            if (resultSet != null) {
	                try {
	                    while (resultSet.next()) {
	                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
	                                resultSet.getString(3), resultSet.getString(4),resultSet.getString(5), resultSet.getString(6)});
	                    }
	                } catch (SQLException ex) {
	                    ex.printStackTrace();
	                }
	            }
	        }

			
          else if (e.getSource()==updateButton) {
         	 int id=Integer.parseInt(propertyIDTextField.getText());
         	 
         	pro.setAddress(addressTextField.getText());
				pro.setType(typeTextField.getText());
				pro.setBedrooms(bedroomsTextField.getText());
				pro.setBathrooms(bathroomsTextField.getText());
				pro.setMonthlyRent(monthlyRentTextField.getText());
				pro.update(id);
				}
          else {
				int id=Integer.parseInt(propertyIDTextField.getText());
				pro.delete(id);}
		
          }
 

 public static void main(String[] args) {
	 PropertyForm  prof = new PropertyForm();
     System.out.println(prof);
 }
}
