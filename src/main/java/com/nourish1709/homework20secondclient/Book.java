package com.nourish1709.homework20secondclient;

import lombok.Data;

import java.util.List;

@Data
public class Book {
    private String bookId;
    private String name;
    private String description;
    private List<String> authors;
    private int yearOfPublication;
    private int numberOfWords;
    private int rating;
}