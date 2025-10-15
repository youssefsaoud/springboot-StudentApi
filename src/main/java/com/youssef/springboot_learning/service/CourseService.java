package com.youssef.springboot_learning.service;


import com.youssef.springboot_learning.model.Course;
import com.youssef.springboot_learning.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService (CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    public List <Course> getCourses(){
        return courseRepository.findAll();
    }

    public Course getCourse (Long id){
        return courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course NOT Found"));
    }

    public Course addCourse (Course course){
        return courseRepository.save(course);
    }

    public void deleteCourse(Long id){
        courseRepository.deleteById(id);
    }

    public Course updatedCourse(Long id, Course updatedCourse){
        Course course = getCourse(id);

        course.setName(updatedCourse.getName());
        course.setDescription(updatedCourse.getDescription());
        return courseRepository.save(course);
    }
}
