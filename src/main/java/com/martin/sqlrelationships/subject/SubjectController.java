package com.martin.sqlrelationships.subject;

import com.martin.sqlrelationships.student.Student;
import com.martin.sqlrelationships.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/subjects")
public class SubjectController {

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    StudentRepository studentRepository;


    //http://localhost:8080/api/v1/subjects/
    @GetMapping("")
    List<Subject> getAllSubjects(){
        return subjectRepository.findAll();
    }

    //http://localhost:8080/api/v1/subjects/
    @PostMapping("")
    public Subject createSubject(@RequestBody Subject subject){
        return subjectRepository.save(subject);
    }

    @PutMapping("/{subjectId}/students/{studentId}")
    public Subject enrolledStudentToSubject(
            @PathVariable("subjectId") Long subjectId,
            @PathVariable("studentId") Long studentId
    ){
        Subject subject = subjectRepository.findById(subjectId).get();
        Student student = studentRepository.findById(studentId).get();
        subject.enrolledStudent(student);
        return subjectRepository.save(subject);
    }
}
