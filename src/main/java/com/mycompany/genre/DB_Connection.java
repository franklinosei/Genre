package com.mycompany.genre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connection {

    private String url = "jdbc:mysql://localhost/music";
    private String username = "root";
    private String password = "s0249612579S";

    private Connection conn = null;

//    private Statement stmt;
    public Connection connect() throws Exception {
        try {
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(url, username, password);
            }
            return conn;

        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }

    }

    public void closeConnection() throws Exception {
        try {
            if(conn != null && !conn.isClosed()){
                conn.isClosed();
            }
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
    }
}
