package menu;


import javax.swing.*;
import customerform.CustomerForm;
import employeeform.employeeform;
import landlordform.LandlordForm;
import leaseform.LeaseForm;
import mentainancerequestform.mentainancerequestform;
import paymentform.PaymentForm;
import propertiesform.PropertyForm;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;


public class menu extends JFrame implements ActionListener {
    private JMenuBar menuBar;
    private JMenu homeMenu;
    private JMenuItem customerItem;
    private JMenuItem employeeItem;
    private JMenuItem landlordItem;
    private JMenuItem leaseItem;
    private JMenuItem mentainancerequesttem;
    private JMenuItem paymentItem;
    private JMenuItem propertiesItem;
    private JMenuItem settingsItem;
    private JMenuItem logoutItem;
    private String loggedInUserItem;
    private boolean isSubscribed = false;

    public menu(String username) {
        this.loggedInUserItem = username;
        setTitle("Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create menu bar
        menuBar = new JMenuBar();

        // Create home menu
        homeMenu = new JMenu("Home");

        // Create menu items
        customerItem = new JMenuItem("customer");
        customerItem.addActionListener(this);
       employeeItem = new JMenuItem("employee");
        employeeItem.addActionListener(this);
        landlordItem = new JMenuItem("landlord");
        landlordItem.addActionListener(this);
        leaseItem = new JMenuItem("lease");
        leaseItem.addActionListener(this);
       mentainancerequesttem = new JMenuItem("mentainancerequest");
     mentainancerequesttem.addActionListener(this);
        paymentItem = new JMenuItem("payment");
       paymentItem.addActionListener(this);
        propertiesItem = new JMenuItem("properties");
       propertiesItem.addActionListener(this);
        settingsItem = new JMenuItem("Settings");
        settingsItem.addActionListener(this);
        logoutItem = new JMenuItem("Logout");
        logoutItem.addActionListener(this);

        // Add menu items to home menu
        homeMenu.add(customerItem);
        homeMenu.add(employeeItem);
        homeMenu.add(paymentItem);
        homeMenu.add(landlordItem);
        homeMenu.add(leaseItem);
        homeMenu.add(mentainancerequesttem);
        homeMenu.add(propertiesItem);
        homeMenu.addSeparator();
        homeMenu.add(settingsItem);
        homeMenu.addSeparator();
        homeMenu.add(logoutItem);

        // Add home menu to menu bar
        menuBar.add(homeMenu);

        // Set menu bar to frame
        setJMenuBar(menuBar);

        // Initialize dashboard panel
        JPanel dashboardPanel = new JPanel();
        dashboardPanel.setLayout(new BorderLayout());

        // Add components to dashboard panel
        JLabel titleLabel = new JLabel("Welcome " + loggedInUserItem + " to Dashboard");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        dashboardPanel.add(titleLabel, BorderLayout.CENTER);

        // Add dashboard panel to frame
        add(dashboardPanel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == customerItem) {
            JOptionPane.showMessageDialog(this, "Opening CustomerForm...");
            new CustomerForm();
        } else if (e.getSource() == employeeItem) {
            JOptionPane.showMessageDialog(this, "Opening employeeForm...");
            new employeeform();
        } else if (e.getSource() == landlordItem) {
            JOptionPane.showMessageDialog(this, "Opening landlordForm...");
            new LandlordForm();
        } else if (e.getSource() == leaseItem) {
            JOptionPane.showMessageDialog(this, "Opening leaseForm...");
            new LeaseForm();
        } else if (e.getSource() == mentainancerequesttem) {
            JOptionPane.showMessageDialog(this, "Opening mentainancerequest Form...");
            new mentainancerequestform();
            
        } else if (e.getSource() == propertiesItem) {
                JOptionPane.showMessageDialog(this, "Opening mentainancerequest Form...");
                new PropertyForm();
        }else if (e.getSource() == paymentItem) {
                    JOptionPane.showMessageDialog(this, "Opening mentainancerequest Form...");
                    new PaymentForm();
            
        } else if (e.getSource() == settingsItem) {
            String newUsername = JOptionPane.showInputDialog(this, "Enter new username:");
            String newPassword = JOptionPane.showInputDialog(this, "Enter new password:");
            JOptionPane.showMessageDialog(this, "User registered successfully: " + newUsername);
        } else if (e.getSource() == logoutItem) {
            int choice = JOptionPane.showConfirmDialog(this, "Do you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                dispose();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new menu("loyal customer"));
    }
}


