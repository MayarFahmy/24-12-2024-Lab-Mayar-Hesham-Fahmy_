package Management;
import CustomException.*;
import Library.*;
import java.util.*;
import java.util.regex.*;

public class LibraryManagement<B extends Book, M extends Magazine> {
    private ArrayList<? extends LibraryItem> items;

    public LibraryManagement() {
        items = new ArrayList<>();
    }

    public void addItem(LibraryItem item) throws EmptyString {

        if (item instanceof Magazine) {
            Magazine magazine = (Magazine) item;

            if (magazine.getTitle() == null || magazine.getTitle().trim().isEmpty()) {
                throw new EmptyString("Empty title");
            }
        }
        if (item instanceof Book) {
            Book book = (Book) item;

            if (book.getTitle() == null || book.getTitle().trim().isEmpty()) {
                throw new EmptyString("Empty title");
            }

            String nameRegex = "^[A-Za-z]+(?: [A-Za-z]+)*(?: [A-Za-z]\\\\.)?$";
            Pattern pattern = Pattern.compile(nameRegex);
            Matcher matcher = pattern.matcher(book.getAuthor());

            if (book.getAuthor() == null || book.getAuthor().trim().isEmpty() || !matcher.matches()) {
                throw new EmptyString("Invalid Author name");
            }
        }

        ArrayList<LibraryItem> itemsAdded = (ArrayList<LibraryItem>) items;
        itemsAdded.add(item);
        
    }

    public void removeItem(int ID) throws RuntimeException{
      for (LibraryItem item : items) {
          if (item instanceof Book) {
              Book book = (Book) item;
              if (book.getID() == ID) {
                  System.out.println("Book removed: " + book.getTitle());
                  items.remove(item);
              }
              else {
                  throw new RuntimeException("Book does not exist");

              }
          }
          if (item instanceof Magazine) {
              Magazine magazine = (Magazine) item;
              if(magazine.getID() == ID) {
                  System.out.println("Magazine removed: " + magazine.getTitle());
                  items.remove(item);
              }
              else {
                 throw new RuntimeException("Magazine does not exist");
              }
          }
      }
    }

    public String countLibraryItems() throws ItemNotFound {
        if (items == null || items.isEmpty()) {
            throw new ItemNotFound("No items found in the library.");
        }
        int magazineCount = 0;
        int bookCount = 0;
        for (LibraryItem item : items) {
            if (item instanceof Magazine) {
                magazineCount++;
            } else if (item instanceof Book) {
                bookCount++;
            }
        }
        System.out.println("Number of Books: " + bookCount);
        System.out.println("Number of Magazines: " + magazineCount);

        return "Book count: " + bookCount +"\n" +"Magazines count: " + magazineCount;
    }


    public void displayItems() throws ItemNotFound {
        String[] keys_ = {"Books", "Magazines"};

        HashMap<String, List<LibraryItem>> magazineMap = new HashMap<>();
        HashMap<String, List<LibraryItem>> bookMap = new HashMap<>();


        magazineMap.put(keys_[1], new ArrayList<>());
        bookMap.put(keys_[0], new ArrayList<>());


        for (LibraryItem item : items) {
            if (item instanceof Magazine) {
                magazineMap.get(keys_[1]).add(item);
            } else if (item instanceof Book) {
                bookMap.get(keys_[0]).add(item);
            }
        }


        if (!bookMap.get(keys_[0]).isEmpty()) {
            System.out.println("Books:");
            for (LibraryItem book : bookMap.get(keys_[0])) {
                System.out.println(book.getDetails());
            }

        }
        else {
            System.out.println("No books found in the library.");
        }

        if (!magazineMap.get(keys_[1]).isEmpty()) {
            System.out.println("Magazines:");
            for (LibraryItem magazine : magazineMap.get(keys_[1])) {
                System.out.println(magazine.getDetails());
            }
        }
        else {
            System.out.println("No magazines found in the library.");
        }
    }

}
