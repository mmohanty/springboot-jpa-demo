package com.manas.springboot.demo.jpa.service;

import com.manas.springboot.demo.jpa.entity.Student;
import org.springframework.stereotype.Component;

@Component
public interface StudentService {
    public Student saveStudent(Student student);
    public Student getStudent(int id);
}
