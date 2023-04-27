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
    public Connection connect() throws Exception {

        try {
            this.conn = DriverManager.getConnection(this.url, this.username, this.password);

            return this.conn;

        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }

    }

    public void closeConnection() throws Exception {
        try {
            this.conn.close();
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }

    }
}
