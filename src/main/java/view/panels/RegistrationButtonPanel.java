package view.panels;

import Factory.EmployeeFactory;
import controller.RegistrationController;
import database.Database;
import database.RegistrationDB;
import employee.Employee;
import employee.Programmer;

import javax.swing.*;

public class RegistrationButtonPanel extends JPanel {

    private JButton checkIn;
    private JButton checkOut;


    // Get your controller in this private field
    private RegistrationController controller;
    private Database db;

    // For now, just make a new employee in this class via your factory.
    // You can change this later on to a more unified way
    private Employee employee;
    private EmployeeFactory employeeFactory = new EmployeeFactory();



    // Get your controller in this class via the constructor
    public RegistrationButtonPanel(RegistrationController controller)
    {
        JLabel label = new JLabel("Registration buttons");
        this.checkIn = new JButton("Check In");
        this.checkOut = new JButton("Check Out");

        this.db = RegistrationDB.getRegistrationDB();
        this.controller = controller;


        // Create your temporary employee here
        this.employee = employeeFactory.getEmployee("Jonathan", "Programmer");
        addCheckInButtonActionListener();
        addCheckOutButtonActionListener();


        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(label);
        this.add(this.checkIn);
        this.add(this.checkOut);

    }

    public void addCheckInButtonActionListener()
    {
        this.checkIn.addActionListener(listener ->
        {
            // Insert here your controller functionality
            controller.checkIn(employee);
        });
    }

    public void addCheckOutButtonActionListener()
    {
        this.checkOut.addActionListener(listener ->
        {
            // Insert here your controller functionality
            controller.checkOut(employee);
        });
    }

}
