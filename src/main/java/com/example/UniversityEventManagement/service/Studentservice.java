package com.example.UniversityEventManagement.service;

import com.example.UniversityEventManagement.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class Studentservice {
    private static List<Student> students=new ArrayList<>();
    private static int id;

    static{
        students.add(new Student(++id,"kalpesh","Patil",25,"EXTC"));
        students.add(new Student(++id,"Ajay","Patil",28,"Pharma"));
        students.add(new Student(++id,"Shaunak","ganjave",25,"EXTC"));
        students.add(new Student(++id,"Gayatri","Patil",25,"IT"));
    }

    public List<Student>printallstudents(){
        return students;
    }
    public void add_student(Student student){
        students.add(student);
    }

    public Student findbyName(String name){

          Predicate<? super Student> predicate= student->student.getName().equals(name);

          Student student=students.stream().filter(predicate).findFirst().get();
          return student;

    }

    public void update_student(String name,Student newstudent){
    Student student_=findbyName(name);
//System.out.println("woorking");
    student_.setId(newstudent.getId());
    student_.setName(newstudent.getName());
    student_.setLname(newstudent.getLname());
    student_.setAge(newstudent.getAge());
    student_.setDepartment(newstudent.getDepartment());
    }

    public void deleteStudent(int id){

        Predicate <? super Student>predicate=todo->todo.getId()==id;
        students.removeIf(predicate);

    }
    public Student findbyId(int id){
        for(Student student:students){
            if(student.getId()==id){
                return student;
            }
        }
        return null;
    }



}
