package com.collage.application.student.dao;

import com.collage.application.student.model.StudentModel;
import java.util.List;

public interface StudentDAO {
    void createStudent(StudentModel student);
    void updateStudent(StudentModel student);
    void deleteStudent(int studentId);
    StudentModel searchStudentByName(String name);
    List<StudentModel> getAllStudents();
}
