package com.collage.application.student.dao;

import com.collage.application.student.model.StudentModel;
import com.collage.application.util.DataBaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    @Override
    public void createStudent(StudentModel student) {
        String sql = "INSERT INTO students (student_id, name, dob, year, address, phone, email, blood_group, aadhar_no, department_id) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, student.getStudentId());
            pstmt.setString(2, student.getName());
            pstmt.setString(3, student.getDob());
            pstmt.setInt(4, student.getYear());
            pstmt.setString(5, student.getAddress());
            pstmt.setString(6, student.getPhone());
            pstmt.setString(7, student.getEmail());
            pstmt.setString(8, student.getBloodGroup());
            pstmt.setString(9, student.getAadharNo());
            pstmt.setInt(10, student.getDepartmentId());

            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Student added successfully: " + student.getName());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateStudent(StudentModel student) {
        String sql = "UPDATE students SET name=?, dob=?, year=?, address=?, phone=?, email=?, blood_group=?, aadhar_no=?, department_id=? WHERE student_id=?";

        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getDob());
            pstmt.setInt(3, student.getYear());
            pstmt.setString(4, student.getAddress());
            pstmt.setString(5, student.getPhone());
            pstmt.setString(6, student.getEmail());
            pstmt.setString(7, student.getBloodGroup());
            pstmt.setString(8, student.getAadharNo());
            pstmt.setInt(9, student.getDepartmentId());
            pstmt.setInt(10, student.getStudentId());

            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Student updated successfully: " + student.getName());
            } else {
                System.out.println("⚠️ No student found with ID: " + student.getStudentId());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteStudent(int studentId) {
        String sql = "DELETE FROM students WHERE student_id=?";

        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, studentId);

            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Student deleted with ID: " + studentId);
            } else {
                System.out.println("⚠️ No student found with ID: " + studentId);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public StudentModel searchStudentByName(String name) {
        String sql = "SELECT * FROM students WHERE name=?";
        StudentModel student = null;

        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                student = new StudentModel(
                        rs.getInt("student_id"),
                        rs.getString("name"),
                        rs.getString("dob"),
                        rs.getInt("year"),
                        rs.getString("address"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getString("blood_group"),
                        rs.getString("aadhar_no"),
                        rs.getInt("department_id")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return student;
    }

    @Override
    public List<StudentModel> getAllStudents() {
        List<StudentModel> students = new ArrayList<>();
        String sql = "SELECT * FROM students";

        try (Connection conn = DataBaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                students.add(new StudentModel(
                        rs.getInt("student_id"),
                        rs.getString("name"),
                        rs.getString("dob"),
                        rs.getInt("year"),
                        rs.getString("address"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getString("blood_group"),
                        rs.getString("aadhar_no"),
                        rs.getInt("department_id")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }
}
