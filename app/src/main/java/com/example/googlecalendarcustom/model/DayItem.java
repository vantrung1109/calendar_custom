package com.example.googlecalendarcustom.model;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DayItem {
    public int date;
    public boolean isCurrentMonth;
    public boolean hasEvent;
    public List<Event> events;

    public DayItem(int date, boolean isCurrentMonth) {
        this.date = date;
        this.isCurrentMonth = isCurrentMonth;
        this.events = new ArrayList<>();
    }

    public static List<DayItem> generateListDayItems(Calendar currentDate) {
        List<DayItem> days = new ArrayList<>();
        Calendar calendar = (Calendar) currentDate.clone();

        // Set to first day of month
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        // Get the day of week for the first day
        int firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        // Add previous month's days
        calendar.add(Calendar.DAY_OF_MONTH, -firstDayOfWeek + 1);
        for (int i = 0; i < firstDayOfWeek - 1; i++) {
            days.add(new DayItem(
                    calendar.get(Calendar.DAY_OF_MONTH), false));
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }
        // Add current month's days
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int i = 1; i <= daysInMonth; i++) {
            DayItem day = new DayItem(i, true);
            // Example: Add events to some days
            if (i % 3 == 0) {
                day.hasEvent = true;
                Event event = new Event();
                event.title = "Event " + i;
                event.color = Color.RED;
                day.events.add(event);
                day.events.add(event);
                day.events.add(event);
                day.events.add(event);
                day.events.add(event);
                day.events.add(event);
            }
            days.add(day);
        }
        // Add next month's days to complete the grid
        int remainingDays = 42 - days.size(); // 6 rows * 7 days
        for (int i = 1; i <= remainingDays; i++) {
            days.add(new DayItem(i, false));
        }
        return days;
    }
}
