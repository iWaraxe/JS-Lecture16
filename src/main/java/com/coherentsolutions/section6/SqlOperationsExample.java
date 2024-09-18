package com.coherentsolutions.section6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlOperationsExample {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/JavaSchoolMX";
        String user = "student";
        String password = "student";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {

            // SELECT Query
            executeSelectQuery(statement);

            // INSERT Query
            executeInsertQuery(statement);
            executeSelectQuery(statement);


            // UPDATE Query
            executeUpdateQuery(statement);
            executeSelectQuery(statement);

            // DELETE Query
            executeDeleteQuery(statement);
            executeSelectQuery(statement);


        } catch (SQLException e) {
            System.err.println("SQL Exception occurred: " + e.getMessage());
        }
    }

    private static void executeSelectQuery(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Students");
        while (resultSet.next()) {
            System.out.println("ID: " + resultSet.getInt("id") + ", Name: " + resultSet.getString("name") + ", Age: " + resultSet.getInt("age"));
        }
        resultSet.close();
    }

    private static void executeInsertQuery(Statement statement) throws SQLException {
        statement.executeUpdate("INSERT INTO Students (name, age) VALUES ('Dave', 21)");
        System.out.println("INSERT query executed.");
    }

    private static void executeUpdateQuery(Statement statement) throws SQLException {
        statement.executeUpdate("UPDATE Students SET age = 22 WHERE name = 'Dave'");
        System.out.println("UPDATE query executed.");
    }

    private static void executeDeleteQuery(Statement statement) throws SQLException {
        statement.executeUpdate("DELETE FROM Students WHERE name = 'Dave'");
        System.out.println("DELETE query executed.");
    }
}

