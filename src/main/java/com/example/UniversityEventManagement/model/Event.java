package com.example.UniversityEventManagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    private Integer eventid;
    private String eventname;
    private String location;
    private String date;
    private String starttime;
    private String endtime;


}
