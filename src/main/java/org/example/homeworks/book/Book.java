package org.example.homeworks.book;

public class Book implements Displayable {
    private String bookName;
    private String bookAuthor;
    private int publicationDate;

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookName() {
        return this.bookName;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookAuthor() {
        return this.bookAuthor;
    }

    public void setPublicationDate(int publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getPublicationDate() {
        return this.publicationDate;
    }

    @Override
    public void print() {
        System.out.println("Book name is " + this.bookName + ", author is " + this.bookAuthor +
                ", publication date is " + this.publicationDate);
    }
}
