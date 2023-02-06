package com.EliasT.myStudyPal.service;

import com.EliasT.myStudyPal.model.Course;
import com.EliasT.myStudyPal.model.User;
import com.EliasT.myStudyPal.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@Service
public class CourseRepoImpl implements CourseRepoInterface {

    @Autowired

    private CourseRepository courseRepo;

    @Override
    public Course addCourse(Course course){
        return (Course) courseRepo.save(course);
    }

    @Override
    public void deleteCourse(int id) {
         courseRepo.deleteById(id);
    }

    @Override
    public void deleteAllCourse() {
        courseRepo.deleteAll();
    }

    @Override
    public Optional<Course> findbyID(int id) {
        return courseRepo.findById(id);
    }

    @Override
    public List<Course> getAllcourse() {
        return courseRepo.findAll();
    }


}
