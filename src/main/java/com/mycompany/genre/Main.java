package com.mycompany.genre;

import java.sql.Connection;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        //  DB Connection
        DB_Connection connection = new DB_Connection();
        Connection db_instance = null;

        try {
            db_instance = connection.connect();
            System.out.println("Database connection Successful 🔥🔥🔥 ");
        } catch (Exception e) {
            System.out.println("Database connection error: ");
            System.out.println(e.getMessage());
        }

        // Initialization
        Genre genre = new Genre(10, "Niger drill");
        AdminGenre ad_genre = new AdminGenre(db_instance);

        try {
            // Insert data
            int insertRowsAffected = ad_genre.insertGenre(genre);
            System.out.println("Insertion affected " + insertRowsAffected + " of rows");
        } catch (Exception e) {
            System.out.println("Insertion Error\n");
            System.out.println(e.getMessage());
        }

        try {
            // Update data
            int updateRowsAffected = ad_genre.updateGenre(genre);
            System.out.println("Update affected " + updateRowsAffected + " of rows");
        } catch (Exception e) {
            System.out.println("Update Error\n");
            System.out.println(e.getMessage());
        }

        try {
            // Delete
            int deletedRows = ad_genre.deleteGenre(7);
            System.out.println("Delete affected " + deletedRows + " of rows");
        } catch (Exception e) {
            System.out.println("Delete Error\n");
            System.out.println(e.getMessage());
        }

        try {
            // All data
            ArrayList<Genre> allGenre = ad_genre.getAll();

            for (Genre genreData : allGenre) {
                System.out.println("Genre Name: " + genreData.getGenreName());
            }

        } catch (Exception e) {
            System.out.println("Get all data Error\n");
            System.out.println(e.getMessage());
        }

        //  close db connection
        try {
            connection.closeConnection();
            System.out.println("Database closed\n");
        } catch (Exception e) {
            System.out.println("Closing database error\n");
            System.out.println(e.getMessage());
        }

    }
}
