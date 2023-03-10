package com.EliasT.myStudyPal.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table()
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Name" ,nullable = false)
    private String name;






    public User() {

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





    public User( String name) {

        this.name = name;

    }
}