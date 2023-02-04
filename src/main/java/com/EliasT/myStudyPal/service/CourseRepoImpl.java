package com.EliasT.myStudyPal.service;

import com.EliasT.myStudyPal.model.Course;
import com.EliasT.myStudyPal.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseRepoImpl implements CourseRepoInterface {

    @Autowired

    private CourseRepository courseRepo;

    @Override
    public Course addCourse(Course course){
        return (Course) courseRepo.save(course);
    }
}
