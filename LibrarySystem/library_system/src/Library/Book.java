package Library;

import CustomException.EmptyString;

public class Book extends LibraryItem {
    private int ID;
    private String Author;
    public Book() {
        super();

    }
    public Book(String title, int ID, String author) {
        super(title,ID);
        this.Author = author;
    }

    public void setID(int ID){

        this.ID = ID;
    }
    public void setTitle(String title) throws EmptyString {
        if(title==null || title.trim().isEmpty()){
            throw new EmptyString("title");
        }
        this.title = title;
    }
    public void setAuthor(String author) throws EmptyString {

        if(author==null || author.trim().isEmpty()){
            throw new EmptyString("author");
        }
        this.Author = author;
    }

    public String getAuthor(){
        return this.Author;
    }
    public int getID(){
        return this.ID;
    }
    public String getTitle(){
        return this.title;
    }

    @Override
    public String getDetails() {
        return "Book ID: " + ID +"\n"+"Book Title: " + title +"\n"+"Author name: " + Author;
    }
}
