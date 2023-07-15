package ru.dinara.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

public class Person {
    private int id;
    @NotEmpty(message = "Поле не может быть пустым")
    @Size(min = 2, max = 100, message = "Допустимое количество символом (min - 2, max - 100)")
    private String fullName;

    @NotEmpty(message = "Поле не может быть пустым")
    @Min(value = 1900, message = "Нужно ввести верный год")
    @DateTimeFormat(pattern = "yyyy")
    @Past(message = "Превышение по текущему году")
    private int yearOfBirth;

    public Person() {}

    public Person(int id, String fullName, int yearOfBirth) {
        this.id = id;
        this.fullName = fullName;
        this.yearOfBirth = yearOfBirth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }
}
