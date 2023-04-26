package com.mycompany.genre;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Genre genre = new Genre(1, "K-Pop");
        AdminGenre ad_genre = new AdminGenre();

        // Insert data
        int insertRowsAffected = ad_genre.insertGenre(genre);
        System.out.println("Insertion affected " + insertRowsAffected + " of rows");
        // Update data
        int updateRowsAffected = ad_genre.updateGenre(genre);
        System.out.println("Update affected " + updateRowsAffected + " of rows");

        // Delete
        int deletedRows = ad_genre.deleteGenre(6);
        System.out.println("Delete affected " + deletedRows + " of rows");

        // All data
        ArrayList<Genre> allGenre = ad_genre.getAll();

        for (int i = 0; i < allGenre.size(); i++) {
            System.out.println("Genre Name: " + allGenre.get(i).getGenreName());
        }
    }
}
