package com.collage.application.library.dao;

import com.collage.application.library.model.LibraryModel;
import com.collage.application.util.DataBaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibraryDAOImpl implements LibraryDAO {

    @Override
    public void createBook(LibraryModel book) {
        String sql = "INSERT INTO library (book_id, title, author, available) VALUES (?, ?, ?, ?)";

        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, book.getLibraryId());
            pstmt.setString(2, book.getBookTitle());
            pstmt.setString(3, book.getAuthor());
            pstmt.setInt(4, book.getAvailableCopies());

            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Book added successfully: " + book.getBookTitle());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateBook(LibraryModel book) {
        String sql = "UPDATE library SET title = ?, author = ?, available = ? WHERE book_id = ?";

        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, book.getBookTitle());
            pstmt.setString(2, book.getAuthor());
            pstmt.setInt(3, book.getAvailableCopies());
            pstmt.setInt(4, book.getLibraryId());

            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Book updated successfully: " + book.getBookTitle());
            } else {
                System.out.println("⚠️ No book found with ID: " + book.getLibraryId());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteBook(int id) {
        String sql = "DELETE FROM library WHERE book_id = ?";

        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Book deleted successfully with ID: " + id);
            } else {
                System.out.println("⚠️ No book found with ID: " + id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public LibraryModel searchBookByTitle(String title) {
        String sql = "SELECT * FROM library WHERE title = ?";
        LibraryModel book = null;

        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, title);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                book = new LibraryModel(
                        rs.getInt("book_id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getInt("available")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return book;
    }

    @Override
    public List<LibraryModel> getAllBooks() {
        String sql = "SELECT * FROM library";
        List<LibraryModel> books = new ArrayList<>();

        try (Connection conn = DataBaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                books.add(new LibraryModel(
                        rs.getInt("book_id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getInt("available")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }
}
