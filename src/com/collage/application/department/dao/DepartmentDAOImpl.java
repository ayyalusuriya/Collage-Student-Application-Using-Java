package com.collage.application.department.dao;

import com.collage.application.department.model.Department;
import com.collage.application.util.DataBaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAOImpl implements DepartmentDAO {

    @Override
    public void createDepartment(Department dept) {
        String sql = "INSERT INTO departments (department_id, department_name, hod_name) VALUES (?, ?, ?)";

        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, dept.getDepartmentId());
            stmt.setString(2, dept.getDepartmentName());
            stmt.setString(3, dept.getHodName());

            stmt.executeUpdate();
            System.out.println("✅ Department added: " + dept.getDepartmentName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateDepartment(Department dept) {
        String sql = "UPDATE departments SET department_name=?, hod_name=? WHERE department_id=?";

        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, dept.getDepartmentName());
            stmt.setString(2, dept.getHodName());
            stmt.setInt(3, dept.getDepartmentId());

            int rows = stmt.executeUpdate();
            if (rows > 0)
                System.out.println("✅ Department updated: " + dept.getDepartmentName());
            else
                System.out.println("⚠️ Department not found for ID: " + dept.getDepartmentId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDepartment(int departmentId) {
        String sql = "DELETE FROM departments WHERE department_id=?";

        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, departmentId);
            int rows = stmt.executeUpdate();

            if (rows > 0)
                System.out.println("✅ Department deleted with ID: " + departmentId);
            else
                System.out.println("⚠️ Department not found for ID: " + departmentId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Department searchDepartmentById(int departmentId) {
        String sql = "SELECT * FROM departments WHERE department_id=?";
        Department dept = null;

        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, departmentId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                dept = new Department(
                        rs.getInt("department_id"),
                        rs.getString("department_name"),
                        rs.getString("hod_name")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dept;
    }

    @Override
    public List<Department> getAllDepartments() {
        String sql = "SELECT * FROM departments";
        List<Department> departments = new ArrayList<>();

        try (Connection conn = DataBaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                departments.add(new Department(
                        rs.getInt("department_id"),
                        rs.getString("department_name"),
                        rs.getString("hod_name")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return departments;
    }
}
