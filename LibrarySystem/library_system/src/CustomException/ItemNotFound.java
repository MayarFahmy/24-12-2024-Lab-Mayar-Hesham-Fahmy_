package CustomException;

public class ItemNotFound extends Exception {
    public ItemNotFound(String message) {
        super(message);
    }
}
