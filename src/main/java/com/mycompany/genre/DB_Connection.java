package com.mycompany.genre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connection {

    private static Connection conn = null;


//    private Statement stmt;
    public Connection connect() throws Exception {
        try {
            if (conn == null || conn.isClosed()) {
                String password = "password";
                String username = "root";
                String url = "jdbc:mysql://localhost/music";
                conn = DriverManager.getConnection(url, username, password);
            }
            return conn;

        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }

    }

    public static void closeConnection() throws Exception {
        try {
            if(conn != null && !conn.isClosed()){
                conn.close();
            }
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
    }
}
