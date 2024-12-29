package Library;

public abstract class LibraryItem {
    protected String title;
    protected int ID;


    public LibraryItem() {}
    public LibraryItem(String title,int ID) {
        this.title = title;
        this.ID=ID;
    }





    public abstract String getDetails();
}
