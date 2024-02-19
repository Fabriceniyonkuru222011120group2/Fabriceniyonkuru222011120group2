package paymentform;

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
import rentalmanagementclasses.Payment;

public class PaymentForm implements ActionListener {
    JFrame frame;
    JLabel paymentIDLabel = new JLabel("Payment ID");
    JLabel leaseIDLabel = new JLabel("Lease ID");
    JLabel paymentDateLabel = new JLabel("Payment Date");
    JLabel amountLabel = new JLabel("Amount");

    JTextField paymentIDTextField = new JTextField();
    JTextField leaseIDTextField = new JTextField();
    JTextField paymentDateTextField = new JTextField();
    JTextField amountTextField = new JTextField();

    JButton insertButton = new JButton("Insert");
    JButton viewButton = new JButton("View");
    JButton updateButton = new JButton("Update");
    JButton deleteButton = new JButton("Delete");

    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);


    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int) screenSize.getWidth();
    int height = (int) screenSize.getHeight();

    public PaymentForm() {
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
        frame.setTitle("Payment Form");
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

        paymentIDLabel.setBounds(labelX, startY, labelWidth, 30);
        leaseIDLabel.setBounds(labelX, startY + spacingY, labelWidth, 30);
        paymentDateLabel.setBounds(labelX, startY + 2 * spacingY, labelWidth, 30);
        amountLabel.setBounds(labelX, startY + 3 * spacingY, labelWidth, 30);

        paymentIDTextField.setBounds(textFieldX, startY, textFieldWidth, 30);
        leaseIDTextField.setBounds(textFieldX, startY + spacingY, textFieldWidth, 30);
        paymentDateTextField.setBounds(textFieldX, startY + 2 * spacingY, textFieldWidth, 30);
        amountTextField.setBounds(textFieldX, startY + 3 * spacingY, textFieldWidth, 30);

        insertButton.setBounds(labelX, 300, 90, 30);
        viewButton.setBounds(labelX + 100, 300, 90, 30);
        updateButton.setBounds(labelX + 200, 300, 90, 30);
        deleteButton.setBounds(labelX + 300, 300, 90, 30);
        table.setBounds(450, 10, 600, 300);
    }

    private void setFontForAll() {
        Font font = new Font("Times New Roman", Font.BOLD, 14);

        paymentIDLabel.setFont(font);
        leaseIDLabel.setFont(font);
        paymentDateLabel.setFont(font);
        amountLabel.setFont(font);

        paymentIDTextField.setFont(font);
        leaseIDTextField.setFont(font);
        paymentDateTextField.setFont(font);
        amountTextField.setFont(font);

        Font buttonFont = new Font("Arial", Font.BOLD, 16);
        insertButton.setFont(buttonFont);
        viewButton.setFont(buttonFont);
        updateButton.setFont(buttonFont);
        deleteButton.setFont(buttonFont);
    }

    private void addComponentsToFrame() {
        frame.add(paymentIDLabel);
        frame.add(leaseIDLabel);
        frame.add(paymentDateLabel);
        frame.add(amountLabel);

        frame.add(paymentIDTextField);
        frame.add(leaseIDTextField);
        frame.add(paymentDateTextField);
        frame.add(amountTextField);

        frame.add(insertButton);
        frame.add(viewButton);
        frame.add(deleteButton);
        frame.add(updateButton);
        frame.add(table);
    }
    @Override
	   public void actionPerformed(ActionEvent e) {
			Payment pay=new Payment();
			if(e.getSource()==insertButton) {
		
				pay.setLeaseID(leaseIDTextField.getText());
		    	pay.setPaymentDate(paymentDateTextField.getText());
				pay.setAmount(amountTextField.getText());
				
				
			    pay.insertData();
			    }
			else if (e.getSource() == viewButton) {
	            model.setColumnCount(0);
	            model.setRowCount(0);
	            model.addColumn("paymentID");
	            model.addColumn("leaseID");
	            model.addColumn("paymentDate");
	            model.addColumn("amount");
	      


	            ResultSet resultSet = Payment.viewData();
	            if (resultSet != null) {
	                try {
	                    while (resultSet.next()) {
	                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
	                                resultSet.getString(3), resultSet.getString(4)});
	                    }
	                } catch (SQLException ex) {
	                    ex.printStackTrace();
	                }
	            }
	        }
			
       else if (e.getSource()==updateButton) {
      	 int id=Integer.parseInt(paymentIDTextField.getText());
      	 
          	pay.setLeaseID(leaseIDTextField.getText());
				pay.setPaymentDate(paymentDateTextField.getText());
				pay.setAmount(amountTextField.getText());
				pay.update(id);
				}
       else {
				int id=Integer.parseInt(paymentIDTextField.getText());
				pay.delete(id);}
		
       }


public static void main(String[] args) {
  PaymentForm  pay = new PaymentForm();
  System.out.println(pay);
}
}

  