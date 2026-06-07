package com.collage.application.util;

import javax.management.remote.JMXConnectionNotification;
import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {

        private static final String URL = "jdbc:mysql://localhost:3306/college_db";
        private static final String USER = "root";
        private static final String PASSWORD = "1234";

        public static Connection getConnection(){
            Connection conn = null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL Driver
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("DataBase connected Successfully..!!!");
            }catch (Exception e){
                e.printStackTrace();
            }
            return conn;
        }
    }

