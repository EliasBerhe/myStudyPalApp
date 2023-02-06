package com.EliasT.myStudyPal.service;

import com.EliasT.myStudyPal.model.Course;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public interface CourseRepoInterface {

    public Course addCourse(Course course);
    public void deleteCourse(int id);

    public void deleteAllCourse();

    public Optional<Course> findbyID(int id);


    public List<Course> getAllcourse();



 ///   public void queryCoures(int userId, Consumer<Course> callback);



}
