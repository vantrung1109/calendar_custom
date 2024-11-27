package com.example.googlecalendarcustom.model;

import android.graphics.Color;
import android.os.Build;

import androidx.annotation.NonNull;

import com.example.googlecalendarcustom.R;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    public String title;
    public int color;
    private LocalTime startTime;
    private LocalTime endTime;
    private int status;
    // Add other event properties as needed

    @NonNull
    public static List<Event> generateListEvents4() {
        List<Event> event4s = new ArrayList<>();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            event4s.add(new Event(
                    "Meeting",
                    R.color.red_light,
                    LocalTime.of(0, 0),
                    LocalTime.of(1, 0),
                    0

            ));

            event4s.add(new Event(
                    "Meeting",
                    R.color.blue_light,
                    LocalTime.of(2, 20),
                    LocalTime.of(3, 35),
                    1

            ));

            event4s.add(new Event(
                    "Event2",
                    R.color.green_light,
                    LocalTime.of(4, 0),
                    LocalTime.of(4, 30),
                    2

            ));

            event4s.add(new Event(
                    "Have a meeting with the another team for beers",
                    R.color.blue_light,
                    LocalTime.of(5, 30),
                    LocalTime.of(6, 30),
                    0
            ));

            event4s.add(new Event(
                    "Have an another event at the same time",
                    R.color.blue_light,
                    LocalTime.of(7, 30),
                    LocalTime.of(8, 30),
                    0
            ));

            event4s.add(new Event(
                    "Event 4: Do the task for boss",
                    R.color.blue_light,
                    LocalTime.of(9, 30),
                    LocalTime.of(10, 10),
                    0
            ));

            event4s.add(new Event(
                    "Event2",
                    R.color.green_light,
                    LocalTime.of(13, 0),
                    LocalTime.of(14, 30),
                    2

            ));

            event4s.add(new Event(
                    "Have a meeting with the another team for beers",
                    R.color.blue_light,
                    LocalTime.of(15, 30),
                    LocalTime.of(16, 30),
                    0
            ));

            event4s.add(new Event(
                    "Have an another event at the same time",
                    R.color.blue_light,
                    LocalTime.of(17, 30),
                    LocalTime.of(18, 30),
                    0
            ));

            event4s.add(new Event(
                    "Event 4: Do the task for boss",
                    R.color.blue_light,
                    LocalTime.of(19, 30),
                    LocalTime.of(20, 10),
                    0
            ));
        }
        return event4s;
    }

    @NonNull
    public static List<Event> generateListEvents3() {
        List<Event> event3s = new ArrayList<>();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            event3s.add(new Event(
                    "Meeting",
                    R.color.red_light,
                    LocalTime.of(0, 0),
                    LocalTime.of(1, 0),
                    0

            ));

            event3s.add(new Event(
                    "Have a meeting with the another team for beers",
                    R.color.blue_light,
                    LocalTime.of(1, 30),
                    LocalTime.of(2, 30),
                    0
            ));

            event3s.add(new Event(
                    "Have an another event at the same time",
                    R.color.blue_light,
                    LocalTime.of(3, 30),
                    LocalTime.of(4, 30),
                    0
            ));

            event3s.add(new Event(
                    "Event 4: Do the task for boss",
                    R.color.blue_light,
                    LocalTime.of(4, 30),
                    LocalTime.of(5, 10),
                    0
            ));

            event3s.add(new Event(
                    "Meeting",
                    R.color.orange_light,
                    LocalTime.of(5, 20),
                    LocalTime.of(6, 55),
                    1

            ));

            event3s.add(new Event(
                    "Event2",
                    R.color.blue_light,
                    LocalTime.of(6, 0),
                    LocalTime.of(7, 45),
                    2

            ));

            event3s.add(new Event(
                    "Event2",
                    R.color.green_light,
                    LocalTime.of(8, 0),
                    LocalTime.of(9, 30),
                    2

            ));

            event3s.add(new Event(
                    "Event2",
                    R.color.green_light,
                    LocalTime.of(10, 0),
                    LocalTime.of(11, 30),
                    2

            ));

            event3s.add(new Event(
                    "Event2",
                    R.color.green_light,
                    LocalTime.of(12, 0),
                    LocalTime.of(13, 30),
                    2

            ));

            event3s.add(new Event(
                    "Event2",
                    R.color.green_light,
                    LocalTime.of(14, 0),
                    LocalTime.of(15, 30),
                    2

            ));

            event3s.add(new Event(
                    "Have a meeting with the another team for beers",
                    R.color.blue_light,
                    LocalTime.of(15, 30),
                    LocalTime.of(16, 30),
                    0
            ));

            event3s.add(new Event(
                    "Have an another event at the same time",
                    R.color.blue_light,
                    LocalTime.of(17, 30),
                    LocalTime.of(18, 30),
                    0
            ));

            event3s.add(new Event(
                    "Event 4: Do the task for boss",
                    R.color.blue_light,
                    LocalTime.of(19, 30),
                    LocalTime.of(20, 10),
                    0
            ));
        }
        return event3s;
    }

    @NonNull
    public static List<Event> generateListEvents2() {
        List<Event> event2s = new ArrayList<>();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            event2s.add(new Event(
                    "Have a meeting with the another team for beers",
                    R.color.blue_light,
                    LocalTime.of(1, 0),
                    LocalTime.of(2, 0),
                    0
            ));

            event2s.add(new Event(
                    "Meeting",
                    R.color.blue_light,
                    LocalTime.of(3, 0),
                    LocalTime.of(4, 0),
                    0

            ));

            event2s.add(new Event(
                    "Meeting",
                    R.color.blue_light,
                    LocalTime.of(5, 0),
                    LocalTime.of(6, 0),
                    0

            ));
            event2s.add(new Event(
                    "Meeting",
                    R.color.blue_light,
                    LocalTime.of(6, 30),
                    LocalTime.of(7, 0),
                    0

            ));

            event2s.add(new Event(
                    "Meeting",
                    R.color.blue_light,
                    LocalTime.of(8, 0),
                    LocalTime.of(9, 0),
                    0

            ));

            event2s.add(new Event(
                    "Meeting",
                    R.color.blue_light,
                    LocalTime.of(9, 0),
                    LocalTime.of(10, 0),
                    0

            ));

            event2s.add(new Event(
                    "Meeting",
                    R.color.blue_light,
                    LocalTime.of(12, 0),
                    LocalTime.of(13, 40),
                    0

            ));

            event2s.add(new Event(
                    "Event2",
                    R.color.green_light,
                    LocalTime.of(14, 0),
                    LocalTime.of(15, 30),
                    2

            ));

            event2s.add(new Event(
                    "Have a meeting with the another team for beers",
                    R.color.blue_light,
                    LocalTime.of(15, 30),
                    LocalTime.of(16, 30),
                    0
            ));

            event2s.add(new Event(
                    "Have an another event at the same time",
                    R.color.blue_light,
                    LocalTime.of(17, 30),
                    LocalTime.of(18, 30),
                    0
            ));

            event2s.add(new Event(
                    "Event 4: Do the task for boss",
                    R.color.blue_light,
                    LocalTime.of(19, 30),
                    LocalTime.of(20, 10),
                    0
            ));
        }
        return event2s;
    }

    @NonNull
    public static List<Event> generateListEvents1() {
        List<Event> event1s = new ArrayList<>();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            event1s.add(new Event(
                    "Meeting",
                    R.color.blue_light,
                    LocalTime.of(1, 0),  // 14:00
                    LocalTime.of(2, 0),  // 16:00
                    0
            ));
            event1s.add(new Event(
                    "Meeting",
                    R.color.blue_light,
                    LocalTime.of(3, 0),  // 14:00
                    LocalTime.of(4, 0),  // 16:00
                    0
            ));

            event1s.add(new Event(
                    "Meeting",
                    R.color.blue_light,
                    LocalTime.of(6, 0),  // 14:00
                    LocalTime.of(7, 0),  // 16:00
                    0
            ));

            event1s.add(new Event(
                    "Meeting",
                    R.color.blue_light,
                    LocalTime.of(7, 0),  // 14:00
                    LocalTime.of(8, 0),  // 16:00
                    0
            ));

            event1s.add(new Event(
                    "Meeting",
                    R.color.blue_light,
                    LocalTime.of(9, 0),  // 14:00
                    LocalTime.of(11, 0),  // 16:00
                    0
            ));

            event1s.add(new Event(
                    "Event2",
                    R.color.green_light,
                    LocalTime.of(10, 0),
                    LocalTime.of(11, 30),
                    2

            ));

            event1s.add(new Event(
                    "Event2",
                    R.color.green_light,
                    LocalTime.of(12, 0),
                    LocalTime.of(13, 30),
                    2

            ));

            event1s.add(new Event(
                    "Event2",
                    R.color.green_light,
                    LocalTime.of(14, 0),
                    LocalTime.of(15, 30),
                    2

            ));

            event1s.add(new Event(
                    "Have a meeting with the another team for beers",
                    R.color.blue_light,
                    LocalTime.of(15, 30),
                    LocalTime.of(16, 30),
                    0
            ));

            event1s.add(new Event(
                    "Have an another event at the same time",
                    R.color.blue_light,
                    LocalTime.of(17, 30),
                    LocalTime.of(18, 30),
                    0
            ));

            event1s.add(new Event(
                    "Event 4: Do the task for boss",
                    R.color.blue_light,
                    LocalTime.of(19, 30),
                    LocalTime.of(20, 10),
                    0
            ));
        }
        return event1s;
    }
}