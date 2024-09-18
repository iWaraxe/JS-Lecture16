package com.coherentsolutions.section1;

import java.sql.*;

public class JDBCIntroductionDemo {

    public static void main(String[] args) {
        // JDBC Introduction Demo
        System.out.println("Starting JDBC Introduction Demo...");

        // Loading JDBC Driver and Establishing a Connection
        loadAndConnectToDatabase();

        // Create and Populate the Sample Table
        //createAndPopulateSampleTable();


        // Creating a Statement and Executing SQL Queries
        executeSQLQueries();

        // Closing the Database Connection
        closeDatabaseConnection();
    }

    private static void loadAndConnectToDatabase() {
        // 1. Load JDBC Driver: Required to establish a connection to the database.
        // Note: This is a demonstration. In real-world applications, the driver loading is often handled automatically.
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("JDBC Driver loaded successfully.");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading JDBC Driver: " + e.getMessage());
        }

        // 2. Establish Connection: Use DriverManager to connect to the database.
        // Note: Replace with actual database connection details.
        String url = "jdbc:mysql://localhost:3306/JavaSchoolMX";
        String user = "student";
        String password = "student";
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connection to database established successfully.");
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }

    private static void createAndPopulateSampleTable() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/JavaSchoolMX";
        String user = "student";
        String password = "student";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {
            // Create the Students table
            String createTableSQL = "CREATE TABLE Students (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(50), age INT);";
            statement.executeUpdate(createTableSQL);
            System.out.println("Table 'Students' created successfully.");

            // Insert sample data into the table
            statement.executeUpdate("INSERT INTO Students (name, age) VALUES ('Alice', 20);");
            statement.executeUpdate("INSERT INTO Students (name, age) VALUES ('Bob', 22);");
            statement.executeUpdate("INSERT INTO Students (name, age) VALUES ('Charlie', 23);");
            System.out.println("Sample data inserted into 'Students' table.");

        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
    }


    private static void executeSQLQueries() {
        // 3. Create Statement: Execute SQL queries through the statement object.
        // 4. Process ResultSet: Retrieve and process the data returned by SQL queries.
        // Note: This is a demonstration. Replace with actual SQL queries and processing logic.
        try (Connection connection = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/JavaSchoolMX", "student", "student");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Students")) {
            System.out.println("Print Students Table");
            while (resultSet.next()) {
                System.out.println("Data from database: " + resultSet.getString("name") + resultSet.getInt("age"));
            }
        } catch (java.sql.SQLException e) {
            System.out.println("Error executing SQL query: " + e.getMessage());
        }
    }

    private static void closeDatabaseConnection() {
        // 5. Close Connection: Important for resource management and performance.
        // Note: In this demonstration, connections are automatically closed using try-with-resources.
        System.out.println("Database connections closed.");
    }
}
