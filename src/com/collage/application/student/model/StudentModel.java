package com.collage.application.student.model;

public class StudentModel {
    private int studentId;
    private String name;
    private String dob;
    private int year;
    private String address;
    private String phone;
    private String email;
    private String bloodGroup;
    private String aadharNo;
    private int departmentId;

    public StudentModel(int studentId, String name, String dob, int year, String address,
                        String phone, String email, String bloodGroup, String aadharNo, int departmentId) {
        this.studentId = studentId;
        this.name = name;
        this.dob = dob;
        this.year = year;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.bloodGroup = bloodGroup;
        this.aadharNo = aadharNo;
        this.departmentId = departmentId;
    }

    // Getters and setters
    public int getStudentId() { return studentId; }
    public String getName() { return name; }
    public String getDob() { return dob; }
    public int getYear() { return year; }
    public String getAddress() { return address; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }
    public String getBloodGroup() { return bloodGroup; }
    public String getAadharNo() { return aadharNo; }
    public int getDepartmentId() { return departmentId; }

    public void setName(String name) { this.name = name; }
    public void setDob(String dob) { this.dob = dob; }
    public void setYear(int year) { this.year = year; }
    public void setAddress(String address) { this.address = address; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setEmail(String email) { this.email = email; }
    public void setBloodGroup(String bloodGroup) { this.bloodGroup = bloodGroup; }
    public void setAadharNo(String aadharNo) { this.aadharNo = aadharNo; }
    public void setDepartmentId(int departmentId) { this.departmentId = departmentId; }

    @Override
    public String toString() {
        return "StudentModel{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                ", year=" + year +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", aadharNo='" + aadharNo + '\'' +
                ", departmentId=" + departmentId +
                '}';
    }
}
