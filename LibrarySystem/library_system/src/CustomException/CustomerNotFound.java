package CustomException;

public class CustomerNotFound extends Exception {
    public CustomerNotFound(String message) {
        super(message);
    }
}
