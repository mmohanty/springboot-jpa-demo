package com.manas.springboot.demo.jpa.controller;

import com.manas.springboot.demo.jpa.entity.Student;
import com.manas.springboot.demo.jpa.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Student save(@RequestBody Student student) {
        Student studentResponse = (Student) studentService.saveStudent(student);
        return studentResponse;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Student getStudent(@PathVariable int id) {
        Student studentResponse = (Student) studentService.getStudent(id);
        return studentResponse;
    }

}
