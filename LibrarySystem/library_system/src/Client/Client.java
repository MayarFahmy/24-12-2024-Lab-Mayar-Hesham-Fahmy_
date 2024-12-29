package Client;

public class Client {
    public int ID;
    public String name;
    public String email ;

    public Client() {}
    public Client(int ID, String name, String email) {
        this.ID = ID;
        this.name = name;
        this.email = email;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;

    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getClientDetails() {
        return "ClientID: " + ID+ "\n" +"Name: "+ name +"\n"+ "Email: " + email;
    }

}
