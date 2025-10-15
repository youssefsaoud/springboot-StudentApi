package com.youssef.springboot_learning.service;

import com.youssef.springboot_learning.dto.StudentDTO;
import com.youssef.springboot_learning.exception.StudentNotFoundException;
import com.youssef.springboot_learning.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.youssef.springboot_learning.model.Course;
import com.youssef.springboot_learning.dto.StudentDTO;

import com.youssef.springboot_learning.repository.StudentRepository;
import com.youssef.springboot_learning.repository.CourseRepository;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public StudentService(StudentRepository studentRepository,
                          CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    public Page<Student> getStudents(int page, int size, String sortBy) {
        return studentRepository.findAll(
                PageRequest.of(page, size, Sort.by(sortBy))
        );
    }

    public Student getStudent(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not found"));
    }

    public Student addStudent(StudentDTO studentDTO) {

        Student student = new Student();

        student.setName(studentDTO.getName());
        student.setAge(studentDTO.getAge());
        student.setEmail(studentDTO.getEmail());

        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new StudentNotFoundException("Student not found");
        }

        studentRepository.deleteById(id);
    }

    public Student updateStudent(Long id, StudentDTO studentDTO) {

        Student student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not found"));

        student.setName(studentDTO.getName());
        student.setAge(studentDTO.getAge());
        student.setEmail(studentDTO.getEmail());

        return studentRepository.save(student);
    }

    public Student getStudentByEmail(String email) {
        return studentRepository.findByEmail(email)
                .orElseThrow(() -> new StudentNotFoundException("Student not found"));
    }

    public Student addCourseToStudent(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException("student not found with id: " + studentId));

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        student.getCourses().add(course);

        return studentRepository.save(student);
    }

    public List<Student> getStudentsOlderThan(int age) {
        return studentRepository.findStudentsOlderThan(age);
    }



}
