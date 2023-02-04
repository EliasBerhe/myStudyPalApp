package com.EliasT.myStudyPal.model;

import jakarta.persistence.*;

@Entity
@Table
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Course Name")
    private String courseName;


    @Column(name = "User Name")
    private String userName;

    public Course(){

    }
    public Course(int id, String courseName, String userName) {
        this.id = id;
        this.courseName = courseName;
        this.userName = userName;
    }


    public int getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getUserName() {
        return userName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}


