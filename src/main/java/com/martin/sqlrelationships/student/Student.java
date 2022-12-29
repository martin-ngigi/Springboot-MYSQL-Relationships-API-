package com.martin.sqlrelationships.student;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.martin.sqlrelationships.subject.Subject;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @JsonIgnore //This will solve the recursive error
    @ManyToMany(mappedBy = "enrolledStudents")
    private  Set<Subject> subjects = new HashSet<>();

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }
}
