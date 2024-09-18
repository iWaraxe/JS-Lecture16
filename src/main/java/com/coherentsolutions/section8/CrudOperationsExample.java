package com.coherentsolutions.section8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CrudOperationsExample {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/JavaSchoolMX";
        String user = "student";
        String password = "student";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {

            // INSERT Operation
            statement.executeUpdate("INSERT INTO Students (name, age) VALUES ('New Student', 19)");

            // UPDATE Operation
            statement.executeUpdate("UPDATE Students SET age = 20 WHERE name = 'New Student'");

            // DELETE Operation
            statement.executeUpdate("DELETE FROM Students WHERE name = 'New Student'");

        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
        }
    }
}

