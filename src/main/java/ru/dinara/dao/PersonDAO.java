package ru.dinara.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.dinara.models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PersonDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index(){
        return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person show(int id) {
        return jdbcTemplate.query(
                "SELECT * FROM Person WHERE id=?",
                new Object[]{id},
                new BeanPropertyRowMapper<>(Person.class)
        ).stream().findAny().orElse(null);
    }

    public void save(Person person) {
        jdbcTemplate.update(
                "INSERT INTO Person(fullName, yearOfBirth) VALUES(?, ?)",
                person.getFullName(),
                person.getYearOfBirth()
        );
    }

    public void update(int id, Person updatedPerson) {
        jdbcTemplate.update(
                "UPDATE Person SET fullName=?, yearOfBirth=? WHERE id=?",
                updatedPerson.getFullName(),
                updatedPerson.getYearOfBirth(),
                id
        );
    }

    public void delete(int id) {
        jdbcTemplate.update(
                "DELETE FROM Person WHERE id=?",
                id
        );
    }
}
