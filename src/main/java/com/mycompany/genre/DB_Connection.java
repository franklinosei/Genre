package com.mycompany.genre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connection {

    private String url = "jdbc:mysql://localhost/music";
    private String username = "root";
    private String password = "s0249612579S";

//    private Statement stmt;
    public Connection connect() {

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(this.url, this.username, this.password);

        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }

        return conn;
    }


//    public Statement getStatement() {
//        return stmt;
//    }
}
