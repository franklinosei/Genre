package com.mycompany.genre;

public class Genre {

    private int genre_id;
    private String genre_name;

    public Genre() {
    }

    public Genre(int genre_id, String genre_name) {
        this.genre_id = genre_id;
        this.genre_name = genre_name;
    }

    public void setGenreName(String genreName) {
        this.genre_name = genreName;
    }

    public void setGenreID(int genreID) {
        this.genre_id = genreID;
    }

    public String getGenreName() {
        return this.genre_name;
    }

    public int getGenreID() {
        return this.genre_id;
    }

}
