package com.collage.application.pl;

import com.collage.application.student.dao.StudentDAOImpl;
import com.collage.application.student.model.StudentModel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class StudentController {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentDAOImpl dao = new StudentDAOImpl();

        try {
            System.out.println("Enter Student Details:");

            System.out.print("ID: ");
            int id = sc.nextInt();
            sc.nextLine(); // consume newline

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("DOB (dd-MM-yyyy): ");
            String dobInput = sc.nextLine();
            SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
            SimpleDateFormat dbFormat = new SimpleDateFormat("yyyy-MM-dd");
            String dob = "";
            try {
                Date date = inputFormat.parse(dobInput);
                dob = dbFormat.format(date); // converts to yyyy-MM-dd for MySQL
            } catch (Exception e) {
                System.out.println("Invalid date format!");
                return;
            }

            System.out.print("Year: ");
            int year = sc.nextInt();
            sc.nextLine();

            System.out.print("Address: ");
            String address = sc.nextLine();

            System.out.print("Phone: ");
            String phone = sc.nextLine();

            System.out.print("Email: ");
            String email = sc.nextLine();

            System.out.print("Blood Group: ");
            String bloodGroup = sc.nextLine();

            System.out.print("Aadhar No: ");
            String aadharNo = sc.nextLine();

            System.out.print("Department ID: ");
            int deptId = sc.nextInt();

            // Create StudentModel object
            StudentModel student = new StudentModel(id, name, dob, year, address, phone, email, bloodGroup, aadharNo, deptId);

            // Insert student into DB
            dao.createStudent(student);

            // Search student by name
            System.out.println("\nSearching student by name: " + name);
            StudentModel found = dao.searchStudentByName(name);
            if (found != null) {
                System.out.println("✅ Student found: " + found);
            } else {
                System.out.println("⚠️ Student not found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}
