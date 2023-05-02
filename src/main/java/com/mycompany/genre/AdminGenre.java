package com.mycompany.genre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AdminGenre {

    private Connection conn = null;

    //  DB Connection
    private DB_Connection connection = new DB_Connection();

    public AdminGenre() {
        try {
            this.conn = connection.connect();
            System.out.println("Database connection Successful 🔥🔥🔥 ");
        } catch (Exception e) {
            System.out.println("Database connection error: ");
            System.out.println(e.getMessage());
        }

    }

    public int insertGenre(Genre genre) throws Exception {

        try {
            //Insert query
            String query = "INSERT INTO genres (genre_name) VALUES (?)";
            PreparedStatement stmt = this.conn.prepareStatement(query);
            stmt.setString(1, genre.getGenreName());

            int rowsAffected = stmt.executeUpdate();

            return rowsAffected;

        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }

    }

    public int updateGenre(Genre genre) throws Exception {

        try {
            //Update data
            String updateQuery = "UPDATE genres SET genre_name = ? WHERE genre_id = ?";
            PreparedStatement stmt = this.conn.prepareStatement(updateQuery);
            stmt.setString(1, genre.getGenreName());
            stmt.setInt(2, genre.getGenreID());

            int rowsAffected = stmt.executeUpdate();
            stmt.close();
            return rowsAffected;

        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
    }

    public int deleteGenre(int genre_id) throws Exception {

        try {
            //Update data
            String updateQuery = "DELETE FROM genres WHERE genre_id = ?";
            PreparedStatement stmt = this.conn.prepareStatement(updateQuery);
            stmt.setInt(1, genre_id);

            int rowsAffected = stmt.executeUpdate();
            stmt.close();
            return rowsAffected;
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
    }

    public ArrayList<Genre> getAll() throws Exception {

        try {
            ArrayList<Genre> genreList = new ArrayList<Genre>();
            //Make query
            String query = "SELECT genre_id, genre_name FROM genres";
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                String name = rs.getString("genre_name");
                int id = rs.getInt("genre_id");

                Genre genre = new Genre(id, name);
                genreList.add(genre);
            }
            stmt.close();
            rs.close();
            return genreList;

        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }

    }
    
}
