package contact.system;

import java.awt.Container;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Contact_list implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent ae) {

    }
    private final ArrayList<Contact> contactlist = new ArrayList<>();//composition

    public void load() {
        try {
            FileReader fr = new FileReader("contact_info.txt");
            BufferedReader br = new BufferedReader(fr);
            String s = br.readLine();
            while (s != null) {
                if (s.equals("")) {
                    break;
                } else {
                    String[] token = s.split(",");
                    String id, num, nam;
                    nam = token[0];
                    num = token[1];
                    id = token[2];
                    Contact con = new Contact(nam, num, id);
                    contactlist.add(con);
                    s = br.readLine();
                }
            }
            fr.close();
            br.close();
        } catch (IOException e) {

        }
    }

    public void save_data() {
        try {
            FileWriter fw = new FileWriter("contact_info.txt");
            PrintWriter pw = new PrintWriter(fw);
            for (int i = 0; i < contactlist.size(); i++) {
                Contact con = (Contact) contactlist.get(i);
                pw.println(con.getName() + "," + con.getNumber() + "," + con.getID());
            }
            pw.flush();
            pw.close();
            fw.close();
        } catch (IOException e) {

        }
    }

    public void search_contact() {
        JFrame f = new JFrame("Search Contact");
        Container c;
        JLabel label1 = new JLabel("Name: ");

        JTextField t1 = new JTextField(20);

        JButton b1 = new JButton("Submit");
        b1.setBackground(Color.LIGHT_GRAY);
        JButton b2 = new JButton("Info");
        b2.setBackground(Color.LIGHT_GRAY);

        b1.addActionListener((ActionEvent e) -> {
            boolean flag = true;
            String[] data;
            data = new String[20];
            data[0] = "Name" + "         " + "Number" + "         " + "ID";
            String name = t1.getText();
            for (int i = 0; i < contactlist.size(); i++) {
                if (contactlist.get(i).getName().equals(name)) {
                    flag = false;
                    data[1] = contactlist.get(i).getName() + "         " + contactlist.get(i).getNumber() + "         " + contactlist.get(i).getID();
                    break;
                }
            }
            if (flag == true) {
                JOptionPane.showMessageDialog(f, "Contact not found");
                t1.setText(null);
            } else {
                JFrame f1 = new JFrame("Search Contact");
                Container c1;
                JList list1 = new JList(data);
                list1.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
                list1.setLayoutOrientation(JList.VERTICAL);
                list1.setVisibleRowCount(-1);
                JScrollPane scroll1 = new JScrollPane(list1);
                scroll1.setPreferredSize(new Dimension(250, 80));
                c1 = f1.getContentPane();
                c1.setLayout(new BorderLayout());
                c1.add(scroll1, BorderLayout.CENTER);
                f1.setSize(300, 300);
                f1.setVisible(true);
                t1.setText(null);
            }
        });
        b2.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(f, "Enter the contact name for showing his/her data.\nThe name will show the data in a drop down list.");
        });

        JPanel buttons1 = new JPanel(new GridLayout(1, 2));
        buttons1.add(b1);
        buttons1.add(b2);

        JPanel labels = new JPanel(new GridLayout(4, 2));
        labels.add(label1);
        labels.add(t1);

        c = f.getContentPane();
        c.setLayout(new BorderLayout());
        c.add(labels, BorderLayout.CENTER);
        c.add(buttons1, BorderLayout.SOUTH);

        f.setSize(300, 300);
        f.setVisible(true);
    }

    public void list_contact() {
        JFrame f = new JFrame("All Contacts");
        Container c;
        String[] data = new String[100];
        data[0] = "Name" + "         " + "Number" + "         " + "ID";
        for (int i = 1; i < contactlist.size(); i++) {
            data[i] = contactlist.get(i).getName() + "         " + contactlist.get(i).getNumber() + "         " + contactlist.get(i).getID();
        }
        JList list = new JList(data);
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);
        list.setVisibleRowCount(-1);
        JScrollPane scroll = new JScrollPane(list);
        scroll.setPreferredSize(new Dimension(250, 80));

        c = f.getContentPane();
        c.setLayout(new BorderLayout());
        c.add(scroll, BorderLayout.CENTER);

        f.setSize(300, 300);
        f.setVisible(true);
    }

    public void delete_contact() {
        JFrame f = new JFrame("Delete Contact");
        Container c;
        JLabel label1 = new JLabel("Name: ");

        JTextField t1 = new JTextField(20);

        JButton b1 = new JButton("Submit");
        b1.setBackground(Color.LIGHT_GRAY);
        JButton b2 = new JButton("Info");
        b2.setBackground(Color.LIGHT_GRAY);
        
        b1.addActionListener((ActionEvent e) -> {
            boolean flag = true;
            String name = t1.getText();
            for (int i = 0; i < contactlist.size(); i++) {
                if (contactlist.get(i).getName().equals(name)) {
                    contactlist.remove(contactlist.get(i));
                    flag = false;
                    break;
                }
            }
            if (flag == true) {
                JOptionPane.showMessageDialog(f, "Contact not found");
                t1.setText(null);
            } else {
                JOptionPane.showMessageDialog(f, "Contact is deleted");
                t1.setText(null);
            }
        });
        b2.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(f, "Enter the name of Contact and all his data\nwill be deleted respectively.");
        });

        JPanel buttons1 = new JPanel(new GridLayout(1, 2));
        buttons1.add(b1);
        buttons1.add(b2);

        JPanel labels = new JPanel(new GridLayout(4, 2));
        labels.add(label1);
        labels.add(t1);

        c = f.getContentPane();
        c.setLayout(new BorderLayout());
        c.add(labels, BorderLayout.CENTER);
        c.add(buttons1, BorderLayout.SOUTH);

        f.setSize(300, 300);
        f.setVisible(true);
    }

    public void edit_contact() {
        JFrame f = new JFrame("Edit Contact");
        Container c;
        JLabel label1 = new JLabel("Name: ");

        JTextField t1 = new JTextField(20);

        JButton b1 = new JButton("Submit");
        b1.setBackground(Color.LIGHT_GRAY);
        JButton b2 = new JButton("Info");
        b2.setBackground(Color.LIGHT_GRAY);

        b1.addActionListener((ActionEvent e) -> {
            boolean flag = true;
            String name = t1.getText();
            int temp = 0;
            for (int i = 0; i < contactlist.size(); i++) {
                if (contactlist.get(i).getName().equals(name)) {
                    flag = false;
                }
            }
            if (flag == true) {
                JOptionPane.showMessageDialog(f, "Contact not found");
                t1.setText(null);
            } else {
                JFrame f1 = new JFrame("Edit Contact");
                Container c1;
                JLabel labele1 = new JLabel("New Name: ");
                JLabel labele2 = new JLabel("New Number: ");
                JLabel labele3 = new JLabel("New ID: ");

                JButton be1 = new JButton("Done");
                JButton be2 = new JButton("Info");
                JTextField te1 = new JTextField(20);
                JTextField te2 = new JTextField(20);
                JTextField te3 = new JTextField(20);
                JPanel buttons1 = new JPanel(new GridLayout(1, 2));
                buttons1.add(be1);
                buttons1.add(be2);

                JPanel labels = new JPanel(new GridLayout(3, 2));
                labels.add(labele1);
                labels.add(te1);
                labels.add(labele2);
                labels.add(te2);
                labels.add(labele3);
                labels.add(te3);

                c1 = f1.getContentPane();
                c1.setLayout(new BorderLayout());
                c1.add(labels, BorderLayout.CENTER);
                c1.add(buttons1, BorderLayout.SOUTH);

                f1.setSize(300, 300);
                f1.setVisible(true);
                int t = temp;
                b1.addActionListener((ActionEvent e1) -> {
                    String name1 = te1.getText();
                    String number1 = te2.getText();
                    String id1 = te3.getText();
                    if (name1.equals("") || number1.equals("") || id1.equals("")) {
                        JOptionPane.showMessageDialog(f, "Invalid Entry");
                    } else {
                        contactlist.get(t).setName(name1);
                        contactlist.get(t).setNumber(number1);
                        contactlist.get(t).setID(id1);
                        JOptionPane.showMessageDialog(f, "Contact is Editid");
                    }
                });
            }
        });
        b2.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(f, "Enter the contact name and if the contact\nis found then all the data can be edited.");
        });
        JPanel buttons1 = new JPanel(new GridLayout(1, 2));
        buttons1.add(b1);
        buttons1.add(b2);

        JPanel labels = new JPanel(new GridLayout(4, 2));
        labels.add(label1);
        labels.add(t1);

        c = f.getContentPane();
        c.setLayout(new BorderLayout());
        c.add(labels, BorderLayout.CENTER);
        c.add(buttons1, BorderLayout.SOUTH);
        f.setSize(300, 300);
        f.setVisible(true);

    }

    public void create_contact() {
        JFrame f = new JFrame("Create Contact");
        Container c;
        JLabel label1 = new JLabel("Name: ");
        JLabel label2 = new JLabel("Number: ");
        JLabel label3 = new JLabel("ID: ");

        JTextField t1 = new JTextField(20);
        JTextField t2 = new JTextField(20);
        JTextField t3 = new JTextField(20);

        JButton b1 = new JButton("Submit");
        b1.setBackground(Color.LIGHT_GRAY);
        JButton b2 = new JButton("Info");
        b2.setBackground(Color.LIGHT_GRAY);

        b1.addActionListener((ActionEvent e) -> {
            String name = t1.getText();
            String number = t2.getText();
            String id = t3.getText();
            if (t1.getText().equals("") || t2.getText().equals("") || t3.getText().equals("")) {
                JOptionPane.showMessageDialog(f, "Blank Data Entered");
            } else {
                Contact create = new Contact(name, number, id);
                contactlist.add(create);
                JOptionPane.showMessageDialog(f, "Contact Created");
            }
            t1.setText("");
            t2.setText("");
            t3.setText("");
        });
        b2.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(f, "Enter the data in the specified feilds to create a contact.");
        });

        JPanel buttons1 = new JPanel(new GridLayout(1, 2));
        buttons1.add(b1);
        buttons1.add(b2);

        JPanel labels = new JPanel(new GridLayout(3, 2));
        labels.add(label1);
        labels.add(t1);
        labels.add(label2);
        labels.add(t2);
        labels.add(label3);
        labels.add(t3);
        c = f.getContentPane();
        c.setLayout(new BorderLayout());
        c.add(labels, BorderLayout.CENTER);
        c.add(buttons1, BorderLayout.SOUTH);

        f.setSize(300, 300);
        f.setVisible(true);
    }

}
