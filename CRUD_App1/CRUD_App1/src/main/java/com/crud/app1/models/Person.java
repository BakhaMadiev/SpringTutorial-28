package com.crud.app1.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class Person {

    private int id;
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 15, message = "Name is too long or too short")
    private String name;

    @Min(value = 16, message = "Age should be greater than 16")
    private int age;
    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Email should be valid")
    private String email;

    public Person() {

    }

    public Person(int id, String name, int age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

}
