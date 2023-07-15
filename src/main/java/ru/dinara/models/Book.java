package ru.dinara.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

public class Book {
    private int id;

    @NotEmpty(message = "Поле не может быть пустым")
    @Size(min = 2, max = 100, message = "Допустимое количество символом (min - 2, max - 100)")
    private String name;

    @NotEmpty(message = "Поле не может быть пустым")
    @Size(min = 2, max = 100, message = "Допустимое количество символом (min - 2, max - 100)")
    private String author;

    @NotEmpty(message = "Поле не может быть пустым")
    @Min(value = 0000, message = "Нужно ввести верный год в формате yyyy")
    @DateTimeFormat(pattern = "yyyy")
    @Past(message = "Превышение по текущему году")
    private int year;

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
