package com.example.SpringDataRepositoriesCertification.service;

import com.example.SpringDataRepositoriesCertification.core.Student;

import java.util.Collection;

public interface StudentService {

    Student get(long id);
    Collection<Student> getAllStudents();
    Collection<Student> getStudentsByDepartment(String department);
}
