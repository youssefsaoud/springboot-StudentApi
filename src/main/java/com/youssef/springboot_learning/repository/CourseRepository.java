package com.youssef.springboot_learning.repository;

import com.youssef.springboot_learning.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
