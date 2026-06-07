package com.collage.application.pl;

import com.collage.application.department.dao.DepartmentDAOImpl;
import com.collage.application.department.model.Department;
import java.util.*;

public class DepartmentController {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DepartmentDAOImpl dao = new DepartmentDAOImpl();

        while (true) {
            System.out.println("\n===== Department Menu =====");
            System.out.println("1. Add Department");
            System.out.println("2. View All Departments");
            System.out.println("3. Search Department by ID");
            System.out.println("4. Update Department");
            System.out.println("5. Delete Department");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Department ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Department Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter HOD Name: ");
                    String hod = sc.nextLine();

                    dao.createDepartment(new Department(id, name, hod));
                    break;

                case 2:
                    dao.getAllDepartments().forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("Enter Department ID: ");
                    int searchId = sc.nextInt();
                    Department dept = dao.searchDepartmentById(searchId);
                    System.out.println(dept != null ? dept : "⚠️ Department not found.");
                    break;

                case 4:
                    System.out.print("Enter Department ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Department Name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter New HOD Name: ");
                    String newHod = sc.nextLine();

                    dao.updateDepartment(new Department(updateId, newName, newHod));
                    break;

                case 5:
                    System.out.print("Enter Department ID to delete: ");
                    int deleteId = sc.nextInt();
                    dao.deleteDepartment(deleteId);
                    break;

                case 6:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("⚠️ Invalid choice!");
            }
        }
    }
}
