package com.example.SpringDataRepositoriesCertification.core;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "person", types = Student.class)
public interface Person {
    String getFirstName();
    String getLastName();
    String getId();
}
