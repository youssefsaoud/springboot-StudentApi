package com.youssef.springboot_learning.repository;

import com.youssef.springboot_learning.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByEmail(String email);

    @Query("SELECT s FROM Student s WHERE s.age >= :age")
    List<Student> findStudentsOlderThan(@Param("age") int age);

}
