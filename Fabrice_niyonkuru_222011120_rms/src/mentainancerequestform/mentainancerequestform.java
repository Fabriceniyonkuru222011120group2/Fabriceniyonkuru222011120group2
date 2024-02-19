package mentainancerequestform;


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

import rentalmanagementclasses.MaintenanceRequest;

public class mentainancerequestform implements ActionListener {
    JFrame frame;
    JLabel requestIDLabel = new JLabel("Request ID");
    JLabel propertyIDLabel = new JLabel("Property ID");
    JLabel descriptionLabel = new JLabel("Description");
    JLabel dateRequestedLabel = new JLabel("Date Requested");
    JLabel statusLabel = new JLabel("Status");

    JTextField requestIDTextField = new JTextField();
    JTextField propertyIDTextField = new JTextField();
    JTextField descriptionTextField = new JTextField();
    JTextField dateRequestedTextField = new JTextField();
    JTextField statusTextField = new JTextField();

    JButton addButton = new JButton("Add");
    JButton viewButton = new JButton("view");
    JButton updateButton = new JButton("update");
    JButton deleteButton = new JButton("delete");
    
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int) screenSize.getWidth();
    int height = (int) screenSize.getHeight();

    public mentainancerequestform() {
        createForm();
        addActionListeners();
        setLocationAndSize();
        setFontForAll();
        addComponentsToFrame();
    }

    private void addActionListeners() {
        addButton.addActionListener(this);
        viewButton.addActionListener(this);
        updateButton.addActionListener(this);
        deleteButton.addActionListener(this);
    }

    private void createForm() {
        frame = new JFrame();
        frame.setTitle("Maintenance Request Form");
        frame.setBounds(0, 0, width / 2, height / 2);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
    }

    private void setLocationAndSize() {
        int labelX = 10, labelWidth = 150;
        int textFieldX = 160, textFieldWidth = 250;
        int startY = 10, spacingY = 60;

        requestIDLabel.setBounds(labelX, startY, labelWidth, 30);
        propertyIDLabel.setBounds(labelX, startY + spacingY, labelWidth, 30);
        descriptionLabel.setBounds(labelX, startY + 2 * spacingY, labelWidth, 30);
        dateRequestedLabel.setBounds(labelX, startY + 3 * spacingY, labelWidth, 30);
        statusLabel.setBounds(labelX, startY + 4 * spacingY, labelWidth, 30);

        requestIDTextField.setBounds(textFieldX, startY, textFieldWidth, 30);
        propertyIDTextField.setBounds(textFieldX, startY + spacingY, textFieldWidth, 30);
        descriptionTextField.setBounds(textFieldX, startY + 2 * spacingY, textFieldWidth, 30);
        dateRequestedTextField.setBounds(textFieldX, startY + 3 * spacingY, textFieldWidth, 30);
        statusTextField.setBounds(textFieldX, startY + 4 * spacingY, textFieldWidth, 30);

        addButton.setBounds(labelX, 310, 85, 30);
        viewButton.setBounds(labelX + 155, 310, 85, 30);
        updateButton.setBounds(labelX + 310, 310, 85, 30);
        deleteButton.setBounds(labelX + 465, 310, 85, 30);
        table.setBounds(450, 10, 600, 300);
    }

    private void setFontForAll() {
        Font font = new Font("Times New Roman", Font.BOLD, 18);

        requestIDLabel.setFont(font);
        propertyIDLabel.setFont(font);
        descriptionLabel.setFont(font);
        dateRequestedLabel.setFont(font);
        statusLabel.setFont(font);

        requestIDTextField.setFont(font);
        propertyIDTextField.setFont(font);
        descriptionTextField.setFont(font);
        dateRequestedTextField.setFont(font);
        statusTextField.setFont(font);

        Font buttonFont = new Font("Arial", Font.BOLD, 12);
        addButton.setFont(buttonFont);
        viewButton.setFont(buttonFont);
        updateButton.setFont(buttonFont);
        deleteButton.setFont(buttonFont);
    }

    private void addComponentsToFrame() {
        frame.add(requestIDLabel);
        frame.add(propertyIDLabel);
        frame.add(descriptionLabel);
        frame.add(dateRequestedLabel);
        frame.add(statusLabel);

        frame.add(requestIDTextField);
        frame.add(propertyIDTextField);
        frame.add(descriptionTextField);
        frame.add(dateRequestedTextField);
        frame.add(statusTextField);

        frame.add(addButton);
        frame.add(viewButton);
        frame.add(updateButton);
        frame.add(deleteButton);
        frame.add(table);
    }

    @Override
	   public void actionPerformed(ActionEvent e) {
    	MaintenanceRequest mai= new MaintenanceRequest();
			
			if(e.getSource()==addButton) {
				mai.setPropertyID(propertyIDTextField.getText());
				mai.setDescription(descriptionTextField.getText());
				mai.setDateRequested(dateRequestedTextField.getText());
				mai.setStatus(statusTextField.getText());
				
			    mai.insertData();
			    }
			else if (e.getSource() == viewButton) {
	            model.setColumnCount(0);
	            model.setRowCount(0);
	            model.addColumn("RequestID");
	            model.addColumn("propertyID");
	            model.addColumn("description");
	            model.addColumn("dateRequested");
	            model.addColumn("statuse");


	            ResultSet resultSet = MaintenanceRequest.viewData();
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
      	 int id=Integer.parseInt(requestIDTextField.getText());
      	 mai.setPropertyID(propertyIDTextField.getText());
				mai.setDescription(descriptionTextField.getText());
				mai.setDateRequested(dateRequestedTextField.getText());
				mai.setStatus(statusTextField.getText());
				mai.update(id);
				}
       else {
				int id=Integer.parseInt(requestIDTextField.getText());
				mai.delete(id);}
		
       }


    public static void main(String[] args) {
        mentainancerequestform form = new mentainancerequestform();
    }
}

