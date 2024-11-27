package com.example.googlecalendarcustom.model;

import java.util.List;

public class StaffCalendarData {
    private String staffName;
    private List<Event> events;

    public StaffCalendarData(String staffName, List<Event> events) {
        this.staffName = staffName;
        this.events = events;
    }

    // Getters
    public String getStaffName() { return staffName; }
    public List<Event> getEvents() { return events; }
}
