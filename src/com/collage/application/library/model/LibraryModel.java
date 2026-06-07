package com.collage.application.library.model;

public class LibraryModel {
    private int libraryId;
    private String bookTitle;
    private String author;
    private int availableCopies;

    public LibraryModel(int libraryId, String bookTitle, String author, int availableCopies) {
        this.libraryId = libraryId;
        this.bookTitle = bookTitle;
        this.author = author;
        this.availableCopies = availableCopies;
    }

    public int getLibraryId() { return libraryId; }
    public void setLibraryId(int libraryId) { this.libraryId = libraryId; }

    public String getBookTitle() { return bookTitle; }
    public void setBookTitle(String bookTitle) { this.bookTitle = bookTitle; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public int getAvailableCopies() { return availableCopies; }
    public void setAvailableCopies(int availableCopies) { this.availableCopies = availableCopies; }

    @Override
    public String toString() {
        return "LibraryModel{" +
                "libraryId=" + libraryId +
                ", bookTitle='" + bookTitle + '\'' +
                ", author='" + author + '\'' +
                ", availableCopies=" + availableCopies +
                '}';
    }
}
