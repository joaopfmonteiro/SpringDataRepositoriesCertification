package com.example.SpringDataRepositoriesCertification.controller;

import com.example.SpringDataRepositoriesCertification.core.Student;
import com.example.SpringDataRepositoriesCertification.repository.StudentRepository;
import com.example.SpringDataRepositoriesCertification.service.StudentService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/student")
@RestController
@CrossOrigin
public class StudentController {

    @Inject
    private StudentService studentService;

    @Inject
    private StudentRepository studentRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Student> getAll(){
        return studentService.getAllStudents();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student getStudent(@PathVariable("id") long id) {
        return studentService.get(id);
    }

    @GetMapping(path = "/search/department", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getDepartment() {
        return studentService.getAllStudents().stream().map(p-> p.getDept()).distinct().collect(Collectors.toList());
    }

    @GetMapping(path = "search/department/{department}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Student> getStudentsByDepartment(@PathVariable("department") String department){
        return studentService.getStudentsByDepartment(department);
    }

    @PostMapping
    public ResponseEntity<String> add(@RequestBody Student student){
        studentRepository.save(student);
        return ResponseEntity.accepted().header("location", "/student/" + student.getId()).build();
    }
}
