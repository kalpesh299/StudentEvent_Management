package com.example.UniversityEventManagement.controller;


import com.example.UniversityEventManagement.model.Event;
import com.example.UniversityEventManagement.model.Student;
import com.example.UniversityEventManagement.service.Eventservice;
import com.example.UniversityEventManagement.service.Studentservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/universitymanagment")
public class Controller {
    @Autowired
    private Eventservice eventservice;

    @Autowired
    private Studentservice studentservice;



    //http://localhost:8080/api/universitymanagment/addstudent
    @PostMapping("/addstudent")//adding the student
    public void addstudent(@RequestBody Student newstudent){
        studentservice.add_student(newstudent);
    }



    //http://localhost:8080/api/universitymanagment/updatedepartment/{name}
    @PutMapping("/updatedepartment/{name}")//updating the student
    public void update_student(@PathVariable String name,@RequestBody Student newstudent){
        studentservice.update_student(name,newstudent);
    }



    //http://localhost:8080/api/universitymanagment/deletebyid/{id}
    @DeleteMapping("deletebyid/{id}")//deleteing the student by id
    public void deletestudent(@PathVariable int id){
        studentservice.deleteStudent(id);
    }



    //http://localhost:8080/api/universitymanagment/allstudents
    @GetMapping("/allstudents")//printing all student data
    public List<Student>printallstudents(){
        return studentservice.printallstudents();
    }


    //http://localhost:8080/api/universitymanagment/getstudentbyid/{id}
    @GetMapping("/getstudentbyid/{id}")//pring the student by its id
    public Student findbyid(@PathVariable int id){
        return studentservice.findbyId(id);
    }



    //http://localhost:8080/api/universitymanagment/addevent
    @PostMapping("/addevent")//adding the evennt
    public void addevent(@RequestBody Event newevent){
        eventservice.addEvent(newevent);
    }


    //http://localhost:8080/api/universitymanagment/allevents
    @GetMapping("/allevents")//printing all events
    public List<Event> printallevents(){
        return eventservice.printallEvents();
    }

    //http://localhost:8080/api/universitymanagment/updateevent/{eventname}
    @PutMapping("updateevent/{eventname}")//updating the event
    public void updateevent(@PathVariable String eventname,@RequestBody Event event){
      eventservice.updateEvent(eventname,event);
    }

    //http://localhost:8080/api/universitymanagment/deletebyname/{eventname}
    @DeleteMapping("deletebyname/{eventname}")//deleteing the event by its name
    public void deletebyname(@PathVariable String eventname){
        eventservice.deleteby_name(eventname);
    }


    //http://localhost:8080/api/universitymanagment/printbydate/{eventdate}
    @GetMapping("/printbydate/{eventdate}")//printing the events by its date
    public List<Event> findbydate(@PathVariable String eventdate){
        return eventservice.findbyDate(eventdate);
    }


}
