package leaseform;


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

import rentalmanagementclasses.Customer;
import rentalmanagementclasses.Lease;

public class LeaseForm implements ActionListener {
    JFrame frame;
    JLabel leaseIDLabel = new JLabel("Lease ID");
    JLabel customerIDLabel = new JLabel("Customer ID");
    JLabel propertyIDLabel = new JLabel("Property ID");
    JLabel leaseStartLabel = new JLabel("Lease Start");
    JLabel leaseEndLabel = new JLabel("Lease End");

    JTextField leaseIDTextField = new JTextField();
    JTextField customerIDTextField = new JTextField();
    JTextField propertyIDTextField = new JTextField();
    JTextField leaseStartTextField = new JTextField();
    JTextField leaseEndTextField = new JTextField();

    JButton insertButton = new JButton("Insert");
    JButton viewButton = new JButton("View");
    JButton updateButton = new JButton("Update");
    JButton deleteButton = new JButton("Delete");

    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int) screenSize.getWidth();
    int height = (int) screenSize.getHeight();

    public LeaseForm() {
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
        frame.setTitle("Lease Form");
        frame.setBounds(0, 0, width / 2, height / 2);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.lightGray);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
    }

    private void setLocationAndSize() {
        int labelX = 10, labelWidth = 150;
        int textFieldX = 160, textFieldWidth = 250;
        int startY = 10, spacingY = 60;

        leaseIDLabel.setBounds(labelX, startY, labelWidth, 30);
        customerIDLabel.setBounds(labelX, startY + spacingY, labelWidth, 30);
        propertyIDLabel.setBounds(labelX, startY + 2 * spacingY, labelWidth, 30);
        leaseStartLabel.setBounds(labelX, startY + 3 * spacingY, labelWidth, 30);
        leaseEndLabel.setBounds(labelX, startY + 4 * spacingY, labelWidth, 30);

        leaseIDTextField.setBounds(textFieldX, startY, textFieldWidth, 30);
        customerIDTextField.setBounds(textFieldX, startY + spacingY, textFieldWidth, 30);
        propertyIDTextField.setBounds(textFieldX, startY + 2 * spacingY, textFieldWidth, 30);
        leaseStartTextField.setBounds(textFieldX, startY + 3 * spacingY, textFieldWidth, 30);
        leaseEndTextField.setBounds(textFieldX, startY + 4 * spacingY, textFieldWidth, 30);

        insertButton.setBounds(labelX, 300, 90, 30);
        viewButton.setBounds(labelX + 100, 300, 90, 30);
        updateButton.setBounds(labelX + 200, 300, 90, 30);
        deleteButton.setBounds(labelX + 300, 300, 90, 30);
        table.setBounds(450, 10, 600, 300);
    }

    private void setFontForAll() {
        Font font = new Font("Times New Roman", Font.BOLD, 14);

        leaseIDLabel.setFont(font);
        customerIDLabel.setFont(font);
        propertyIDLabel.setFont(font);
        leaseStartLabel.setFont(font);
        leaseEndLabel.setFont(font);

        leaseIDTextField.setFont(font);
        customerIDTextField.setFont(font);
        propertyIDTextField.setFont(font);
        leaseStartTextField.setFont(font);
        leaseEndTextField.setFont(font);

        Font buttonFont = new Font("Arial", Font.BOLD, 16);
        insertButton.setFont(buttonFont);
        viewButton.setFont(buttonFont);
        updateButton.setFont(buttonFont);
        deleteButton.setFont(buttonFont);
    }

    private void addComponentsToFrame() {
        frame.add(leaseIDLabel);
        frame.add(customerIDLabel);
        frame.add(propertyIDLabel);
        frame.add(leaseStartLabel);
        frame.add(leaseEndLabel);

        frame.add(leaseIDTextField);
        frame.add(customerIDTextField);
        frame.add(propertyIDTextField);
        frame.add(leaseStartTextField);
        frame.add(leaseEndTextField);

        frame.add(insertButton);
        frame.add(viewButton);
        frame.add(deleteButton);
        frame.add(updateButton);
        frame.add(table);

    }

    @Override
	   public void actionPerformed(ActionEvent e) {
			Lease lea=new Lease();
			if(e.getSource()==insertButton) {
		
				lea.setCustomerID(customerIDTextField.getText());
				lea.setPropertyID(propertyIDTextField.getText());
				lea.setLeaseStart(leaseStartTextField.getText());
				lea.setLeaseEnd(leaseEndTextField.getText());
				
			    lea.insertData();
			    }

			else if (e.getSource() == viewButton) {
	            model.setColumnCount(0);
	            model.setRowCount(0);
	            model.addColumn("leaseID");
	            model.addColumn("CustomerID");
	            model.addColumn("propertyID");
	            model.addColumn("leaseStart");
	            model.addColumn("leaseEnd");
	            


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
         	 int id=Integer.parseInt(leaseIDTextField.getText());
         	 
         	lea.setCustomerID(customerIDTextField.getText());
				lea.setPropertyID(propertyIDTextField.getText());
				lea.setLeaseStart(leaseStartTextField.getText());
				lea.setLeaseEnd(leaseEndTextField.getText());
				lea.update(id);
				}
          else {
				int id=Integer.parseInt(leaseIDTextField.getText());
				lea.delete(id);}
		
          }
 

 public static void main(String[] args) {
     LeaseForm  lea = new LeaseForm();
     System.out.println(lea);
 }
}
