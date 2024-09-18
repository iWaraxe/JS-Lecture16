package com.coherentsolutions.section5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionDemo {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/JavaSchoolMX";
        String user = "student";
        String password = "student";

        try {
            // Loading the JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("JDBC Driver loaded successfully.");

            // Establishing a Connection
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection established successfully.");

            // Close the connection
            connection.close();
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver class not found: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("SQL Exception occurred while connecting: " + e.getMessage());
        }
    }
}
