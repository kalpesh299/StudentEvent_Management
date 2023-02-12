package com.example.UniversityEventManagement.service;

import com.example.UniversityEventManagement.model.Event;
import com.example.UniversityEventManagement.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class Eventservice {
    private static List<Event> events=new ArrayList<>();
   private static int id;
    static{
        events.add(new Event(++id,"Football","Gate No 2","12 feb 2023","2PM","4PM"));
        events.add(new Event(++id,"EDM Night","University Ground","12 feb 2023","7PM","12PM"));
        events.add(new Event(++id,"ROBOT Exibition","Conferance Hall","12 feb 2023","2PM","4PM"));
        events.add(new Event(++id,"Awards Night","Poditorium","12 feb 2023","4PM","9PM"));
    }

    public List<Event>printallEvents(){
        return events;
    }

    public void addEvent(Event newevenet){
        events.add(newevenet);
    }

    public Event findbyName(String eventname){

        Predicate<? super Event> predicate= event->event.getEventname().equals(eventname);

        Event event=events.stream().filter(predicate).findFirst().get();
        return event;

    }

    public void updateEvent(String eventname,Event newevent){
        Event event=findbyName(eventname);
        event.setEventid(newevent.getEventid());
        event.setEventname(newevent.getEventname());
        event.setLocation(newevent.getLocation());
        event.setDate(newevent.getDate());
        event.setStarttime(newevent.getStarttime());
        event.setEndtime(newevent.getEndtime());
    }

    public void deleteby_name(String name){
        Predicate <? super Event>predicate=event->event.getEventname().equals(name);
        events.removeIf(predicate);
    }

    public List <Event> findbyDate(String eventdate){

        List<Event>newList=new ArrayList<>();

        for(Event event:events){

            if(event.getDate().equals(eventdate)){
                newList.add(event);
            }

        }

        return newList;
    }

}

