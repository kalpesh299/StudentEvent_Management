package com.example.UniversityEventManagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {
    private Integer id;
    private String name;
    private String lname;
    private Integer age;
    private String department;
}
