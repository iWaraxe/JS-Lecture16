package com.coherentsolutions.section8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionManagementExample {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/JavaSchoolMX";
        String user = "student";
        String password = "student";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            connection.setAutoCommit(false);

            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate("INSERT INTO Students (name, age) VALUES ('Trans Student', 18)");
                statement.executeUpdate("UPDATE Students SET age = 19 WHERE name = 'Trans Student'");

                connection.commit();
                System.out.println("Transaction committed successfully.");
            } catch (SQLException e) {
                connection.rollback();
                System.err.println("Transaction rolled back due to an error: " + e.getMessage());
            }

        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
        }
    }
}
