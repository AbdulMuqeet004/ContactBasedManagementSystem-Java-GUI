package contact.system;

import javax.swing.JOptionPane;

public class ContactSystem {

    public static void main(String[] args) { 
        Contact_GUI gui  = new Contact_GUI();
        gui.load();
        gui.init();        
    }
}
