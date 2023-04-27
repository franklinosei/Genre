package com.mycompany.genre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connection {

    private String url = "jdbc:mysql://localhost/music";
    private String username = "root";
    private String password = "password";

    private Connection conn = null;

//    private Statement stmt;
    public Connection connect() {

        try {
            this.conn = DriverManager.getConnection(this.url, this.username, this.password);
            System.out.println("Coonection successful");

        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }

        return this.conn;
    }

    public void closeConnection() {
        try {
            this.conn.close();
        } catch (SQLException e) {
        }

    }
}
