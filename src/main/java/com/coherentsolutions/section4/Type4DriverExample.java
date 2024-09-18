package com.coherentsolutions.section4;

// Choosing the Right JDBC Driver:
// - Type 4 drivers are typically the best choice for most Java applications due to their portability and performance.
// - Consider the specific requirements of your application and database.
// - For example, if using a specific database like Oracle, the Oracle Type 4 driver is often the best choice.
// - Evaluate factors like the application's deployment environment, performance requirements, and database compatibility.

// Example of a Type 4 JDBC Driver usage:

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
Types of JDBC Drivers:
1. Type 1: JDBC-ODBC Bridge Driver
   - Uses ODBC driver to connect to the database.
   - Not recommended for production due to performance issues.

2. Type 2: Native-API Driver
   - Uses database-specific native client APIs.
   - Requires installation of database-specific client software.

3. Type 3: Network Protocol Driver
   - Communicates with the database server via a middle-tier server.
   - Database-independent and requires a middle-tier server.

4. Type 4: Thin Driver (Pure Java Driver)
   - Directly interacts with the database server using Java.
   - Most popular and does not require native libraries or middleware servers.
*/

public class Type4DriverExample {

    public static void main(String[] args) {
        // Example of using MySQL's Type 4 JDBC Driver
        String url = "jdbc:mysql://localhost:3306/JavaSchoolMX";
        String user = "student";
        String password = "student";

        try {
            // Loading the Type 4 JDBC Driver for MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("MySQL JDBC Driver loaded successfully.");

            // Establishing a connection using the Type 4 driver
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connection established successfully using MySQL's Type 4 JDBC Driver.");

            // Close the connection
            conn.close();
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver class not found: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("SQL Exception occurred while connecting: " + e.getMessage());
        }
    }
}

