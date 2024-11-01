package com.example.SpringDataRepositoriesCertification.service;

import com.example.SpringDataRepositoriesCertification.core.Student;
import com.example.SpringDataRepositoriesCertification.repository.StudentRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Collection;

@Named
public class StudentServiceImpl implements StudentService{


    @Inject
    private StudentRepository studentRepository;

    @Override
    public Student get(long id){

        return studentRepository.getOne(id);
    }

    @Override
    public Collection<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    @Override
    public Collection<Student> getStudentsByDepartment(String department) {
        return studentRepository.findByDept(department);
    }
}
