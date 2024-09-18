package com.coherentsolutions.section7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionExample {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/JavaSchoolMX";
        String user = "student";
        String password = "student";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            // Disabling auto-commit mode
            connection.setAutoCommit(false);

            try (Statement statement = connection.createStatement()) {
                // Executing multiple SQL statements as part of a transaction
                statement.executeUpdate("INSERT INTO Students (name, age) VALUES ('Dave', 21)");
                statement.executeUpdate("UPDATE Students SET age = 22 WHERE name = 'Dave'");

                // Committing the transaction
                connection.commit();
                System.out.println("Transaction committed successfully.");
            } catch (SQLException e) {
                // Rolling back the transaction in case of an error
                connection.rollback();
                System.err.println("Transaction rolled back due to an error: " + e.getMessage());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
