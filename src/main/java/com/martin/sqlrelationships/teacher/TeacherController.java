package com.martin.sqlrelationships.teacher;

import com.martin.sqlrelationships.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/teachers")
public class TeacherController {

    @Autowired
    TeacherRepository teacherRepository;

    //http://localhost:8080/api/v1/teachers/
    @GetMapping("")
    List<Teacher> getAllTeachers(){
        return teacherRepository.findAll();
    }

    //http://localhost:8080/api/v1/teachers/
    @PostMapping("")
    public Teacher createTeacher(@RequestBody Teacher teacher){
        return teacherRepository.save(teacher);
    }

}
