package com.codecool.Luxon;

public class main {
    public static void main(String[] args) {
        FilePartReader reader = new FilePartReader();

        reader.setup("src/resources/lorem.txt", 2, 5);
        String line = reader.readLines();
        System.out.println(line);
    }
}
