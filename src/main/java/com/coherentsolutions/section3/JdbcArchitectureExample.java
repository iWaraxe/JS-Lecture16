package com.coherentsolutions.section3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcArchitectureExample {

    public static void main(String[] args) {
        // Example of using JDBC Architecture components
        String url = "jdbc:mysql://localhost:3306/JavaSchoolMX";
        String user = "student";
        String password = "student";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Students");

            while (rs.next()) {
                System.out.println("Student ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") + ", Age: " + rs.getInt("age"));
            }

            // Closing resources
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
        }
    }
}
