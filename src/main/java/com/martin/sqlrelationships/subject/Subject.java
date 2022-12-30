package com.martin.sqlrelationships.subject;

import com.martin.sqlrelationships.student.Student;
import com.martin.sqlrelationships.teacher.Teacher;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToMany //Subject can have many students and student can have many subjects.
    @JoinTable(
            name = "student_enrolled",
            joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private Set<Student> enrolledStudents = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL) //ManyToOne because there are may subjects and each subject has only one teacher. One subject can have one teacher.   But one teacher can have many subjects
    @JoinColumn(name = "teacher_id", referencedColumnName = "id") // "id" is the teachers id
    private Teacher teacher;

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

    public Set<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void enrolledStudent(Student student) {
        enrolledStudents.add(student);
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void assignedTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
