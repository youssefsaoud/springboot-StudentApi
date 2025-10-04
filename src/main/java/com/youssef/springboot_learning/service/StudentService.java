package com.youssef.springboot_learning.service;

import com.youssef.springboot_learning.dto.StudentDTO;
import com.youssef.springboot_learning.exception.StudentNotFoundException;
import com.youssef.springboot_learning.model.Student;
import org.springframework.stereotype.Service;
import com.youssef.springboot_learning.dto.StudentDTO;

import com.youssef.springboot_learning.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
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



}
