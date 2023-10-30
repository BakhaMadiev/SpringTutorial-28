package com.crud.app1.dao;

import com.crud.app1.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

//    private static int PEOPLE_COUNT;

//    private static final String URL = "jdbc:postgresql://localhost:5432/first_db";
//    private static final String USERNAME = "postgres";
//    private static final String PASSWORD = "783209Wek";
//
//    private static Connection connection;
//
//    static {
//        try{
//            Class.forName("org.postgresql.Driver");
//        } catch (ClassNotFoundException e){
//            e.printStackTrace();
//        }
//
//        try {
//            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }


//    private List<Person> people;
//
//    {
//        people = new ArrayList<>();
//
//        people.add(new Person(++PEOPLE_COUNT, "Francesco", 31, "Francesco@resiltech.com"));
//        people.add(new Person(++PEOPLE_COUNT, "Gianluigi", 78, "Gianluigi@resiltech.com"));
//        people.add(new Person(++PEOPLE_COUNT, "Sandro", 58, "Sandro@resiltech.com"));
//        people.add(new Person(++PEOPLE_COUNT, "Marco", 55, "Marco@resiltech.com "));
//    }

    public List<Person> index(){
        return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));

//        List<Person> people = new ArrayList<>();
//
//        try {
//            Statement statement = connection.createStatement();
//            String SQL = "SELECT * FROM Person";
//            ResultSet resultSet = statement.executeQuery(SQL);
//
//            while (resultSet.next()){
//                Person person = new Person();
//
//                person.setId(resultSet.getInt("id"));
//                person.setName(resultSet.getString("name"));
//                person.setAge(resultSet.getInt("age"));
//                person.setEmail(resultSet.getString("email"));
//
//                people.add(person);
//            }
//        } catch (SQLException throwables){
//            throwables.printStackTrace();
//        }
//
//        return people;
    }

    public Person show(int id) {

        return jdbcTemplate.query("SELECT * FROM Person WHERE id=?", new Object[]{id},new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny().orElse(null);
//        Person person = null;
//
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Person WHERE id=?");
//
//            preparedStatement.setInt(1, id);
//
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            resultSet.next();
//
//            person = new Person();
//
//            person.setId(resultSet.getInt("id"));
//            person.setName(resultSet.getString("name"));
//            person.setAge(resultSet.getInt("age"));
//            person.setEmail(resultSet.getString("email"));
//
//            preparedStatement.executeUpdate();
//
//        } catch (SQLException throwables){
//            throwables.printStackTrace();
//        }
//
//        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
//        return person;
    }

    public void save(Person person){
        jdbcTemplate.update("INSERT INTO Person VALUES (1, ?, ?, ?)", person.getName(), person.getAge(), person.getEmail());

//        person.setId(++PEOPLE_COUNT);
//        people.add(person);

//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Person VALUES(1, ?, ?, ?)");
//
//            preparedStatement.setString(1, person.getName());
//            preparedStatement.setInt(2, person.getAge());
//            preparedStatement.setString(3, person.getEmail());
//
//            preparedStatement.executeUpdate();
//
//        } catch (SQLException throwables){
//            throwables.printStackTrace();
//        }
    }

    public void update(int id, Person updatedPerson){
        jdbcTemplate.update("UPDATE Person SET name=?, age=?, email=? WHERE id=?",
                updatedPerson.getName(), updatedPerson.getAge(), updatedPerson.getEmail(), updatedPerson.getId());

//        try {
//            PreparedStatement preparedStatement =
//                    connection.prepareStatement("UPDATE Person SET name=?, age=?, email=? WHERE id=?");
//
//            preparedStatement.setString(1, updatedPerson.getName());
//            preparedStatement.setInt(2, updatedPerson.getAge());
//            preparedStatement.setString(3, updatedPerson.getEmail());
//            preparedStatement.setInt(4, id);
//
//            preparedStatement.executeUpdate();
//        } catch (SQLException throwables){
//            throwables.printStackTrace();
//        }

//        Person personToBeUpdated = show(id);
//
//        personToBeUpdated.setName(updatedPerson.getName());
//        personToBeUpdated.setAge(updatedPerson.getAge());
//        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id){
        jdbcTemplate.update("DELETE FROM Person WHERE id=?", id);

//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Person WHERE id=?");
//
//            preparedStatement.setInt(1, id);
//
//            preparedStatement.executeUpdate();
//        } catch (SQLException throwables){
//            throwables.printStackTrace();
//        }
//        people.removeIf(p -> p.getId() == id);
    }
}
