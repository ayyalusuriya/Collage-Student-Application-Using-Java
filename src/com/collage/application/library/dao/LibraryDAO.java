package com.collage.application.library.dao;

import com.collage.application.library.model.LibraryModel;
import java.util.List;

public interface LibraryDAO {
    void createBook(LibraryModel book);
    void updateBook(LibraryModel book);
    void deleteBook(int id);
    LibraryModel searchBookByTitle(String title);
    List<LibraryModel> getAllBooks();
}
