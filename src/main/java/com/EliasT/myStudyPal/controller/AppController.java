package com.EliasT.myStudyPal.controller;


import com.EliasT.myStudyPal.model.Course;
import com.EliasT.myStudyPal.model.User;
import com.EliasT.myStudyPal.service.CourseRepoImpl;
import com.EliasT.myStudyPal.service.CourseRepoInterface;
import com.EliasT.myStudyPal.service.UserRepImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController

public class AppController {
    @Autowired
    private CourseRepoInterface couresService;
    @Autowired
    private UserRepImp userService;

    @GetMapping("/hello")
    public List<User> hello(){
       return userService.findByName("abebe");
    }
    @PostMapping("/hello/course/{userId}")
    public String add(@RequestBody @Validated String courseName, @PathVariable  int userId){

/**
        if(! userService.findByName(course.getUser().getName()).isEmpty()){
            userService.addUser(course.getUser());
            couresService.addCourse(course);
            return Optional.of(course);
        }
        else{
            return Optional.empty();
        }
 */

        if(userService.getUser(userId).isPresent()){
            User user = userService.getUser(userId).get();
            Course course = new Course(courseName);
            course.setUser(user);
           couresService.addCourse(course);
           return (user.getName() + Integer.toString(userId));
        }
        else{
            return "no user found";
        }
         //Course course = new Course(3,"Comp256","Ayoo");
       // Course course2 = new Course(4,"Comp232","nigga");

        //}

       //

    }
    @PostMapping("/hello/user")
    public User addUser(@RequestBody @Validated String name){

        //Course course = new Course(3,"Comp256","Ayoo");
        // Course course2 = new Course(4,"Comp232","nigga");
        //couresService.addCourse(user.getCourse());
        User user = new User(name);
        userService.addUser(user);
        // couresService.addCourse(course2);
        return user;
    }

    @DeleteMapping("hello/delete/{id}")
    public String deleteCourse(@PathVariable int id){

        if(couresService.findbyID(id).isPresent()){
            couresService.deleteCourse(id);
            return ("course of " + id +" deleted");
        }
      else{
          return "No course with such id found";
        }

    }
    @DeleteMapping("hello/delete")
    public String deleteCourse(){

        couresService.deleteAllCourse();
        return ("All course Deleted");
    }
    @DeleteMapping("hello/deleteAllUser")
    public String deleteAllUser(){

        userService.deleteALluser();
        return ("All user Deleted");
    }

    @PutMapping("hello/getUser")

    public List<User> getUser(){
       return userService.getAllUser();

    }

    @DeleteMapping("hello/deleteUser/{uId}")
    public String deleteUser(@PathVariable  int uId){

        if(userService.getUser(uId).isPresent()){
            User user = userService.getUser(uId).get();
            couresService.getAllcourse().stream()
                           .filter(course-> course.getUser() ==user)
            .forEach(course -> couresService.deleteCourse(course.getId()));


            userService.deleteUser(uId);
            return ("user of " + uId +" deleted");
        }
        else{
            return "No user with such id found";
        }
    }
}
