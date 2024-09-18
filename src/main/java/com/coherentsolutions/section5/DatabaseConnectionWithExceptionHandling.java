package com.coherentsolutions.section5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionWithExceptionHandling {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/JavaSchoolMX";
        String user = "student";
        String password = "student";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection established successfully.");

            // Perform database operations...

            // Close the connection
            connection.close();
        } catch (SQLException e) {
            System.err.println("SQL Exception occurred: " + e.getMessage());
        }
    }
}

