package com.collage.application.department.model;

public class Department {
    private int departmentId;
    private String departmentName;
    private String hodName;

    public Department(int departmentId, String departmentName, String hodName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.hodName = hodName;
    }

    // Getters and Setters
    public int getDepartmentId() { return departmentId; }
    public void setDepartmentId(int departmentId) { this.departmentId = departmentId; }

    public String getDepartmentName() { return departmentName; }
    public void setDepartmentName(String departmentName) { this.departmentName = departmentName; }

    public String getHodName() { return hodName; }
    public void setHodName(String hodName) { this.hodName = hodName; }

    @Override
    public String toString() {
        return "Department [ID=" + departmentId + ", Name=" + departmentName + ", HOD=" + hodName + "]";
    }
}
