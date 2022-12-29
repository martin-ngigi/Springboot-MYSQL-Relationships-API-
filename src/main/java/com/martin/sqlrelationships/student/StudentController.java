package com.martin.sqlrelationships.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    //http://localhost:8080/api/v1/students
    @GetMapping("")
    List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    //http://localhost:8080/api/v1/students/
    @PostMapping("")
    public Student createStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }

}
