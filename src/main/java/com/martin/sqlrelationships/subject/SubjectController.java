package com.martin.sqlrelationships.subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/subjects")
public class SubjectController {

    @Autowired
    SubjectRepository subjectRepository;

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

}
