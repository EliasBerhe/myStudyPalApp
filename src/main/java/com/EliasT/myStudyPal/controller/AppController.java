package com.EliasT.myStudyPal.controller;


import com.EliasT.myStudyPal.model.Course;
import com.EliasT.myStudyPal.service.CourseRepoImpl;
import com.EliasT.myStudyPal.service.CourseRepoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController

public class AppController {
    @Autowired
    private CourseRepoImpl couresService;

    @GetMapping("/hello")
    public String hello(){
       return ("Hello World");
    }
    @PostMapping("/hello/add")
    public Course add(@RequestBody @Validated Course course){

         //Course course = new Course(3,"Comp256","Ayoo");
       // Course course2 = new Course(4,"Comp232","nigga");
        couresService.addCourse(course);
       // couresService.addCourse(course2);
        return course;
    }
}
