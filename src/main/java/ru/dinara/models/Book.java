package ru.dinara.models;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Book {
    private int id;

    @NotNull
    @Size(min = 2, max = 100, message = "Допустимое количество символом (min - 2, max - 100)")
    private String name;

    @NotNull
    @Size(min = 2, max = 100, message = "Допустимое количество символом (min - 2, max - 100)")
    private String author;

    @NotNull
    @Min(value = 0, message = "Нужно ввести верный год")
    private int year;

    public Book() {

    }
    public Book(int id, String name, String author, int year) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.year = year;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
