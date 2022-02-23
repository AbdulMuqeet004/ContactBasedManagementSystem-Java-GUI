package contact.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Contact_GUI extends Contact_list implements ActionListener {

    JFrame f;
    Container c;
    JButton b1, b2, b3, b4, b5, b6;

    JPanel buttons;

    ImageIcon image;
    JLabel background,label;

    public void init() {
        b1 = new JButton("Add");
        b1.setBackground(Color.LIGHT_GRAY);
        b2 = new JButton("List");
        b2.setBackground(Color.LIGHT_GRAY);
        b3 = new JButton("Delete");
        b3.setBackground(Color.LIGHT_GRAY);
        b4 = new JButton("Edit");
        b4.setBackground(Color.LIGHT_GRAY);
        b5 = new JButton("Search");
        b5.setBackground(Color.LIGHT_GRAY);
        b6 = new JButton("Exit");
        b6.setBackground(Color.LIGHT_GRAY);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);

        buttons = new JPanel(new GridLayout(2, 3));

        buttons.add(b1);
        buttons.add(b2);
        buttons.add(b3);
        buttons.add(b4);
        buttons.add(b6);
        buttons.add(b5);
        buttons.setBounds(100,150,300,100);
        
        image = new ImageIcon("egle.png");

        background = new JLabel("", image, JLabel.CENTER);
        background.setBounds(0, 0, 500, 300);
        
        f = new JFrame();
        f.setTitle("Contact Management System");
        label = new JLabel("*****Welcome*****");
        label.setFont(new Font("Contact Management System", Font.PLAIN, 20));
        label.setBounds(160,50,200, 100);
        label.setBackground(Color.YELLOW);
        c = f.getContentPane();
        c.setLayout(null);
        c.add(buttons);
        c.add(label);
        c.add(background);
        f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        f.setBounds(300,200,500, 300);
        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String get = ae.getActionCommand();
        if (get.equals(b1.getActionCommand())) {
            create_contact();
        } else if (get.equals(b2.getActionCommand())) {
            list_contact();
        } else if (get.equals(b3.getActionCommand())) {
            delete_contact();
        } else if (get.equals(b4.getActionCommand())) {
            edit_contact();
        } else if (get.equals(b5.getActionCommand())) {
            search_contact();
        } else if (get.equals(b6.getActionCommand())) {
            save_data();
            System.exit(0);
        }
    }
}
