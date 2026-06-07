package com.collage.application.department.dao;

import com.collage.application.department.model.Department;
import java.util.List;

public interface DepartmentDAO {
    void createDepartment(Department dept);
    void updateDepartment(Department dept);
    void deleteDepartment(int departmentId);
    Department searchDepartmentById(int departmentId);
    List<Department> getAllDepartments();
}
