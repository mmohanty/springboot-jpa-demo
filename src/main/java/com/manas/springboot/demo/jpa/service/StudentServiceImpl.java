package com.manas.springboot.demo.jpa.service;

import com.manas.springboot.demo.dto.AddressDto;
import com.manas.springboot.demo.dto.StudentDto;
import com.manas.springboot.demo.jpa.entity.Address;
import com.manas.springboot.demo.jpa.entity.Student;
import com.manas.springboot.demo.jpa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
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
   // @Transactional
    public Student saveStudent(Student student) {
        Student response = studentRepository.save(student);
        return response;

    }

    @Override
    //@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public StudentDto getStudent(int id) {
        // Optional<Student> studentResponse = studentRepository.findById(id);
        Student student = entityManager.find(Student.class, id);

        StudentDto studentDto = new StudentDto();
        AddressDto addressDto = new AddressDto();
        addressDto.setCountry(student.getAddress().getCountry());
        addressDto.setPin(student.getAddress().getPin());
        addressDto.setId(student.getAddress().getId());
        studentDto.setAddress(addressDto);
        studentDto.setId(student.getId());
        studentDto.setName(student.getName());
        studentDto.setRollNumber(student.getRollNumber());
        studentDto.setUniversity(student.getUniversity());
        return studentDto;
    }
}
