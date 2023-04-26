package com.mycompany.genre;

public class Genre {

    private int genre_id;
    private String genre_name;

    public Genre(int genre_id, String genre_name) {
        this.genre_id = genre_id;
        this.genre_name = genre_name;
    }

    public String getGenreName() {
        return this.genre_name;
    }

    public int getGenreID() {
        return this.genre_id;
    }

}
