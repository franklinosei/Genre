package com.mycompany.genre;

import java.sql.Connection;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // Initialization
        Genre genre = new Genre(10, "Niger drill");
        AdminGenre ad_genre = new AdminGenre();

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
    }
}
