package contact.system;

public class Contact {

    private String name;
    private String number;
    private String ID;

    public Contact(String name, String number, String ID) {
        this.name = name;
        this.number = number;
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}
