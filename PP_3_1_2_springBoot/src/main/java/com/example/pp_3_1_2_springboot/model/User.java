package com.example.pp_3_1_2_springboot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Field \"Name\" cannot be empty")
    @Size(min = 2, max = 30, message = "Name should be from 2 to 30 letters")
    @Column(name = "name")
    private String name;
    @NotEmpty(message = "Field \"Last Name\" cannot be empty")
    @Size(min = 2, max = 30, message = "Last Name should be from 2 to 30 letters")
    @Column(name = "last_name")
    private String lastName;
    @NotEmpty(message = "Field \"Email\" cannot be empty")
    @Email(message = "Email should be valid")
    @Column(name = "email")
    private String email;

    public User(){}

    public User(String name, String lastName, String email) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
    }

    public User(int id, String name, String lastName, String email) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
