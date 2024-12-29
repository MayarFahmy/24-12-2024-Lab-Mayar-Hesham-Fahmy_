package Management;
import Client.Client;
import CustomException.EmptyString;
import CustomException.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.regex.Pattern;

public class ClientManagement {
    private ArrayList<Client> clients;


    public ClientManagement() {
        clients = new ArrayList<>();
    }


    public void addClient(Client client) throws EmptyString {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        String nameRegex = "^[A-Za-z]{2,50}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Pattern pattern1 = Pattern.compile(nameRegex);

        if (client.getName() == null || client.getName().trim().isEmpty() || !pattern1.matcher(client.getName()).matches()) {
            throw new EmptyString("Invalid name entered for Client");
        }
        if (client.getEmail() == null || client.getEmail().trim().isEmpty() || !pattern.matcher(client.getEmail()).matches()) {
            throw new EmptyString("Enter a valid email address");
        }
        clients.add(client);
    }

    public  void removeClient(int ID) throws ItemNotFound {

       for (Client client : clients) {
           if (client.getId() == ID) {

               clients.remove(client);
               System.out.println("Client removed successfully");
               break;
           }
           else {
               throw new ItemNotFound("Client not found");
           }
       }
    }
   public String updateClient(int ID, Client client1) throws InputMismatchException {
       String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
               "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
       String nameRegex = "^[A-Za-z]{2,50}$";
       Pattern pattern = Pattern.compile(emailRegex);
       Pattern pattern1 = Pattern.compile(nameRegex);
       for (Client client : clients) {
           if (client.getId() == ID) {
               if(client.getName() == null || client.getName().trim().isEmpty() || !pattern1.matcher(client.getName()).matches()) {
                   client.setName(client1.getName());
                   break;
               }

               if (client.getEmail() == null || client.getEmail().trim().isEmpty() || !pattern.matcher(client.getEmail()).matches()) {
                   client.setEmail(client1.getEmail());
                   break;
               }
               return "Client updated successfully";
           }
       }
       throw new InputMismatchException("Invalid name or email entry for Client, or client does not exist");

   }

    public void displayClients() throws ItemNotFound {
        for (Client client : clients) {
            System.out.println(client.getClientDetails());
        }
    }
}
