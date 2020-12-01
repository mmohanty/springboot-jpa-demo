package com.manas.springboot.demo.jpa.controller;

import com.manas.springboot.demo.dto.StudentDto;
import com.manas.springboot.demo.jpa.entity.Student;
import com.manas.springboot.demo.jpa.service.StudentServiceImpl;
import com.manas.springboot.demo.jpa.service.util.TimeDelayUtil;
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
    public StudentDto getStudent(@PathVariable int id) throws Exception{
        StudentDto StudentDto = (StudentDto) studentService.getStudent(id);
        Thread.sleep(1000L);
        return StudentDto;
    }

}
