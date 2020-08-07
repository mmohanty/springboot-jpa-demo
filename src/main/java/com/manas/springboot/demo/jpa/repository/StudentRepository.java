package com.manas.springboot.demo.jpa.repository;

import com.manas.springboot.demo.jpa.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface StudentRepository extends CrudRepository<Student, Serializable> {
}
