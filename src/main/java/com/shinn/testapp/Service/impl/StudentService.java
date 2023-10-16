package com.shinn.testapp.Service.impl;

import com.shinn.testapp.Model.Student;
import com.shinn.testapp.Repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StudentService {
    private final StudentRepository studentRepository;
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        Boolean existsEmail = studentRepository.existsByEmail(student.getEmail());
        if(existsEmail) {
            throw new RuntimeException("Email: " + student.getEmail() + " taken.");

        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }


}
