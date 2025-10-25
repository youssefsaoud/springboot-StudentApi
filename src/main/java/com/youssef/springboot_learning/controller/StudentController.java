package com.youssef.springboot_learning.controller;

import com.youssef.springboot_learning.model.Student;
import com.youssef.springboot_learning.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.youssef.springboot_learning.dto.StudentDTO;
import java.util.List;


@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public Page<Student> getStudents(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy) {
        return studentService.getStudents(page, size, sortBy);
    }


    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable Long id) {
        return studentService.getStudent(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/students")
    public Student addStudent(@Valid @RequestBody StudentDTO studentDTO) {
        return studentService.addStudent(studentDTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
    }

    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable Long id, @Valid @RequestBody StudentDTO studentDTO) {
        return studentService.updateStudent(id, studentDTO);
    }

    @GetMapping("/students/email/{email}")
    public Student getStudentByemail(@PathVariable String email) {
        return studentService.getStudentByEmail(email);
    }

    @PostMapping("/students/{studentId}/courses/{courseId}")
    public Student addCourseToStudent(
            @PathVariable Long studentId,
            @PathVariable Long courseId) {
        return studentService.addCourseToStudent(studentId, courseId);
    }

    @GetMapping("/students/older-than/{age}")
    public List<Student> getStudentsOlderThan(@PathVariable int age) {
        return studentService.getStudentsOlderThan(age);
    }



}
