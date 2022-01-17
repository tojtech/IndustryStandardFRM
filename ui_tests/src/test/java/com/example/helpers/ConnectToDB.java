package com.example.helpers;

import java.sql.*;

public class ConnectToDB {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
            // Step 1: "Load" the JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Step 2: Establish the connection to the database
        String url = "jdbc:mysql://31.550.44.131:23";
        Connection conn = DriverManager.getConnection(url, "test", "testpass");

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT Lname FROM Customers WHERE Snum = 2001");

        rs.getArray(1);

    }
}
