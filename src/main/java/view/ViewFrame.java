package view;

import controller.RegistrationController;
import observers.Observer;
import register_entry.RegisterEntry;
import view.panels.ListPanel;
import view.panels.RegistrationButtonPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;

public class ViewFrame extends JFrame implements Observer
{
    // Get your controller in this private field
    private RegistrationController registrationController;
    ListPanel panel;
    RegistrationButtonPanel buttons;

    public ViewFrame(RegistrationController register)
    {
        super("Registration");
        this.registrationController = register;
    }

    public void initialize()
    {
        this.setSize(500, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);

        setDefaultLookAndFeelDecorated(true);

        // Pass the controller to the ButtonPanel
        buttons = new RegistrationButtonPanel(registrationController);
        panel = new ListPanel();

        this.add(panel);
        this.add(buttons);

//        //own fun
//        JButton die = new JButton("Die");
//        JLabel label1 = new JLabel();
//        this.add(die);
//        this.add(label1);
//
//        die.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                label1.setText("lmao you died, noob");
//            }
//        });


        this.setVisible(true);


    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals("db_update")){
            RegisterEntry register = (RegisterEntry)evt.getNewValue();
            panel.addEntry(register);
        }
    }

}
