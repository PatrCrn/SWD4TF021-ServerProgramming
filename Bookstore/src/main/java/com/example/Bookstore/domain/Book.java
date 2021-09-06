package com.example.Bookstore.domain;

public class Book {
    private String title;
    private String author;
    private int year;
    private int isbn;
    private float price;

    public Book(String title, String author, int year, int isbn, float price) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.isbn = isbn;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public int getIsbn() {
        return isbn;
    }

    public float getPrice() {
        return price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}