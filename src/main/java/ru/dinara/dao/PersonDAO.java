package ru.dinara.dao;

import org.springframework.stereotype.Component;
import ru.dinara.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Tom Tom Tom", 2010));
        people.add(new Person(++PEOPLE_COUNT, "Tom1 Tom Tom", 2015));
        people.add(new Person(++PEOPLE_COUNT, "Tom2 Tom Tom", 2016));
        people.add(new Person(++PEOPLE_COUNT, "Tom3 Tom Tom", 2017));
        people.add(new Person(++PEOPLE_COUNT, "Tom4 Tom Tom", 2018));
        people.add(new Person(++PEOPLE_COUNT, "Tom5 Tom Tom", 2019));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        people.add(new Person(++PEOPLE_COUNT, person.getFullName(), person.getYearOfBirth()));
    }

    public void update(int id, Person updatedPerson) {
        Person person = show(id);
        person.setFullName(updatedPerson.getFullName());
        person.setYearOfBirth(updatedPerson.getYearOfBirth());
    }

}
