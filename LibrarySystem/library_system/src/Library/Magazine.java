package Library;
import CustomException.EmptyString;


public class Magazine extends LibraryItem{
    private int IssueNumber;
    public Magazine() {
        super();
    }

    public Magazine(int IssueNumber, String title, int ID) {
        super(title, ID);
        this.IssueNumber = IssueNumber;

    }


    public void setID(int ID) throws EmptyString {
        this.ID = ID;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setIssueNumber(int issueNumber) {
        IssueNumber = issueNumber;
    }


    public int getIssueNumber() {
        return IssueNumber;
    }
    public String getTitle() {
        return title;
    }
    public int getID() {
        return ID;
    }


    @Override
    public String getDetails() {
        return "Magazine ID: " + ID +"\n"+"Magazine name: " + title +"\n"+"Issue Number: " + IssueNumber;
    }


}
