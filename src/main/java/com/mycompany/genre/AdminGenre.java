package com.mycompany.genre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminGenre {

    Connection conn = null;

    public AdminGenre() {
        DB_Connection connection = new DB_Connection();
        this.conn = connection.connect();
    }

    public void insertGenre(Genre genre) {
        try {
            //Insert query
            String query = "INSERT INTO genres (genre_name) VALUES (?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, genre.getGenreName());

            int rowsAffected = stmt.executeUpdate();

            System.out.print("Rows affected: " + rowsAffected);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateGenre(Genre genre) {
        try {
            //Update data
            String updateQuery = "UPDATE genres SET genre_name = ? WHERE genre_id = ?";
            PreparedStatement stmt = conn.prepareStatement(updateQuery);
            stmt.setString(1, genre.getGenreName());
            stmt.setInt(2, genre.getGenreID());

            int rowsAffected = stmt.executeUpdate();

            System.out.println(rowsAffected + " row(s) updated.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteGenre(int genre_id) {
        try {
            //Update data
            String updateQuery = "DELETE FROM genres WHERE genre_id = ?";
            PreparedStatement stmt = conn.prepareStatement(updateQuery);
            stmt.setInt(1, genre_id);

            int rowsAffected = stmt.executeUpdate();

            System.out.println(rowsAffected + " row(s) deleted.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getAll() {
        try {
            //Make query
            String query = "SELECT genre_id, genre_name FROM genres";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String name = rs.getString("student_name");
                String id = rs.getString("student_id");
                System.out.print("id: " + id + " Name: " + name + "\n");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
