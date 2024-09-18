package com.coherentsolutions.section2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PolymorphismJDBC {

    public static void main(String[] args) {
        performDatabaseOperations();
    }

    public static void performDatabaseOperations() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/JavaSchoolMX", "student", "student");
            System.out.println("Connection established using MySQL JDBC driver.");
        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
        }
    }
}
