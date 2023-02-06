package com.EliasT.myStudyPal.model;

import jakarta.persistence.*;
import org.hibernate.engine.internal.Cascade;

@Entity
@Table
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "CourseName", nullable = false)
    private String courseName;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id",nullable = false)

    private User user;






    public Course() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Transient
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Course( String courseName) {

        this.courseName = courseName;

    }
}