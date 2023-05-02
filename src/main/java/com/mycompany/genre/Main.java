package com.mycompany.genre;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {

        // Initialization
        Genre genre = new Genre(10, "Niger drill");
        AdminGenre ad_genre = new AdminGenre();

        // Insert data
        try {
            int insertRowsAffected = ad_genre.insertGenre(genre);
            System.out.println("Insertion affected " + insertRowsAffected + " of rows");
        } catch (Exception e) {
            System.out.println("Insertion Error\n");
            System.out.println(e.getMessage());
        }

        // Update data
        try {
            int updateRowsAffected = ad_genre.updateGenre(genre);
            System.out.println("Update affected " + updateRowsAffected + " of rows");
        } catch (Exception e) {
            System.out.println("Update Error\n");
            System.out.println(e.getMessage());
        }

        // Delete
        try {
            int deletedRows = ad_genre.deleteGenre(7);
            System.out.println("Delete affected " + deletedRows + " of rows");
        } catch (Exception e) {
            System.out.println("Delete Error\n");
            System.out.println(e.getMessage());
        }

        // All data
        try {
            ArrayList<Genre> allGenre = ad_genre.getAll();

            for (Genre genreData : allGenre) {
                System.out.println("Genre Name: " + genreData.getGenreName());
            }

        } catch (Exception e) {
            System.out.println("Get all data Error\n");
            System.out.println(e.getMessage());
        } finally {
            try {
                DB_Connection.closeConnection();
                System.out.println("connection closed");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        
        
    }
}
