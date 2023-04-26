package com.mycompany.genre;

public class Main {

    public static void main(String[] args) {

        Genre genre = new Genre(1, "K-Pop");
        AdminGenre ad_genre = new AdminGenre();

        // Insert data
//        ad_genre.insertGenre(genre);
        // Update data
//        ad_genre.updateGenre(genre);
        
        // Delete
        ad_genre.deleteGenre(6);
    }
}
