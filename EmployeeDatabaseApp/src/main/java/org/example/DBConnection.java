package org.example;
import java.sql.*;
public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/corporate";
    private static final String USER = "root";
    private static final String PASSWORD = "Prathu@0311";
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }
}


