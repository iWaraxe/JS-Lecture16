package com.coherentsolutions.section3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectivityExample {

    public static void main(String[] args) {
        // Example of connecting to the JavaSchoolMX database
        String url = "jdbc:mysql://localhost:3306/JavaSchoolMX";
        String user = "student";
        String password = "student";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection established between Java application and JavaSchoolMX database server.");
        } catch (SQLException e) {
            System.err.println("Error connecting to the JavaSchoolMX database: " + e.getMessage());
        }
    }
}

