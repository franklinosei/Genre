package com.mycompany.genre;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        // Initialization

        AdminGenre ad_genre = new AdminGenre();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Add new genre");
            System.out.println("2. Update genre");
            System.out.println("3. Delete genre");
            System.out.println("4. Show all genres");
            System.out.println("5. Exit");

            System.out.print("Please choose an option from the Menu..: ");
            int option = sc.nextInt();

            switch (option) {
                case 1 -> {
                    System.out.print("Enter genre name to add new genre: ");
                    String name = sc.next();
                    try {
                        Genre genre = new Genre(name);
                        int insertRowsAffected = ad_genre.insertGenre(genre);
                        System.out.println("Insertion affected " + insertRowsAffected + " of rows");
                    } catch (Exception e) {
                        System.out.println("Insertion Error\n");
                        System.out.println(e.getMessage());
                    }

                }
                case 2 -> {
                    System.out.print("Enter genre id to update: ");
                    int genre_id = sc.nextInt();
                    System.out.print("Enter the genre name: ");
                    String genre_Name = sc.next();
                    try {
                        Genre genre = new Genre(genre_id, genre_Name);
                        int updateRowsAffected = ad_genre.updateGenre(genre);
                        System.out.println("Update affected " + updateRowsAffected + " of rows");
                    } catch (Exception e) {
                        System.out.println("Update Error\n");
                        System.out.println(e.getMessage());
                    }
                }

                case 3 -> {
                    System.out.print("Enter genre id to delete: ");
                    int gen_id = sc.nextInt();
                    try {
                        Genre genre;
                        genre = new Genre(gen_id);
                        int deletedRows = ad_genre.deleteGenre(genre.getGenreID());
                        System.out.println("Delete affected " + deletedRows + " of rows");
                    } catch (SQLException e) {
                        System.out.println("Delete Error\n");
                        System.out.println(e.getMessage());
                    }
                }
                case 4 -> {
                    try {
                        ArrayList<Genre> allGenre = ad_genre.getAll();
                        for (Genre genreData : allGenre) {
                            System.out.println("Genre Name: " + genreData.getGenreName());
                        }
                    } catch (Exception e) {
                        System.out.println("Get all data Error\n");
                        System.out.println(e.getMessage());
                    }
                }
                case 5 -> {
                    System.out.println("Closing Database connection...");
                    System.out.println("Exiting program...");
                    DB_Connection.closeConnection();
                    System.out.println("BYE!!!");
                    System.exit(0);
                    break;
                }
                default -> System.out.println("Please CHOOSE a VALID option from the MENU!!");
            }
        }

    }
}
