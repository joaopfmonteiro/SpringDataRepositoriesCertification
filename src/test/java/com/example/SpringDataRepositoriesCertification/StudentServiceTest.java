package com.example.SpringDataRepositoriesCertification;

import com.example.SpringDataRepositoriesCertification.core.Student;
import com.example.SpringDataRepositoriesCertification.service.StudentService;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.inject.Inject;


import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


@SpringBootTest
public class StudentServiceTest {
    @Inject
    private StudentService studentService;

    @Test
    void testServiceSingle(){
        Student student = studentService.get(1L);
        assertThat(student.getFirstName(), equalTo("Eric"));
        assertThat(student.getLastName(), equalTo("Colbert"));
    }

    @Test
    void testService(){
        Collection<Student> students = studentService.getAllStudents();
        students.forEach(p-> System.out.printf("%.10s %10s%n", p.getFirstName(), p.getLastName()));
    }

}
