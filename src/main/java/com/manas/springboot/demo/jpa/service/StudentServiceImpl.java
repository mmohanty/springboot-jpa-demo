package com.manas.springboot.demo.jpa.service;

import com.manas.springboot.demo.jpa.entity.Student;
import com.manas.springboot.demo.jpa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service("studentServiceImpl")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

   // @PersistenceContext
    @Autowired
    private EntityManager entityManager;

    @Override
    //@Transactional
    public Student saveStudent(Student student) {
        Student response = studentRepository.save(student);
        return response;

    }

    @Override
    //@Transactional(readOnly = true)
    public Student getStudent(int id) {
        // Optional<Student> studentResponse = studentRepository.findById(id);
        Student student = entityManager.find(Student.class, id);
        return student;
    }
}
