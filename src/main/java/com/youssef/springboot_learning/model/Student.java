package com.youssef.springboot_learning.model;
import jakarta.persistence.*;
import jakarta.persistence.ManyToMany;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;
import com.youssef.springboot_learning.model.Course;

@Entity

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "name cant be blank")
    private String name;

    @Min(value = 1, message = "Age must be at least 1")
    private int age;

    @Email(message = "email cant be blank")
    @NotBlank(message = "invalid email")
    private String email;

    @ManyToMany
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses = new ArrayList<>();

    public Student() {
    }

    public Student(Long id, String name, int age, String email){
        this.id = id;
        this.name = name;
        this.age= age;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public List<Course> getCourses() {
        return courses;
    }
}