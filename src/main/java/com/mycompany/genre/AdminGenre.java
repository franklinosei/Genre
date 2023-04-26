package com.mycompany.genre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AdminGenre {

    Connection conn = null;

    public AdminGenre() {
        DB_Connection connection = new DB_Connection();
        this.conn = connection.connect();
    }

    public int insertGenre(Genre genre) {
        try {
            //Insert query
            String query = "INSERT INTO genres (genre_name) VALUES (?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, genre.getGenreName());

            int rowsAffected = stmt.executeUpdate();

            return rowsAffected;

        } catch (SQLException e) {
            return -1;
        }
    }

    public int updateGenre(Genre genre) {
        try {
            //Update data
            String updateQuery = "UPDATE genres SET genre_name = ? WHERE genre_id = ?";
            PreparedStatement stmt = conn.prepareStatement(updateQuery);
            stmt.setString(1, genre.getGenreName());
            stmt.setInt(2, genre.getGenreID());

            int rowsAffected = stmt.executeUpdate();

            return rowsAffected;

        } catch (SQLException e) {
            return -1;
        }
    }

    public int deleteGenre(int genre_id) {
        try {
            //Update data
            String updateQuery = "DELETE FROM genres WHERE genre_id = ?";
            PreparedStatement stmt = conn.prepareStatement(updateQuery);
            stmt.setInt(1, genre_id);

            int rowsAffected = stmt.executeUpdate();

            return rowsAffected;
        } catch (SQLException e) {

            return -1;
        }
    }

    public ArrayList<Genre> getAll() {
        ArrayList<Genre> genreList = new ArrayList<Genre>();
        try {
            //Make query
            String query = "SELECT genre_id, genre_name FROM genres";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                String name = rs.getString("genre_name");
                int id = rs.getInt("genre_id");

                Genre genre = new Genre(id, name);
                genreList.add(genre);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return genreList;
    }
}
