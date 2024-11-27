package com.example.googlecalendarcustom.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.googlecalendarcustom.R;
import com.example.googlecalendarcustom.model.Event;
import com.example.googlecalendarcustom.model.StaffCalendarData;
import com.example.googlecalendarcustom.ui.adapter.StaffAdapter;
import com.example.googlecalendarcustom.ui.adapter.StaffTaskAdapter;

import java.util.ArrayList;
import java.util.List;

public class DayActivity extends AppCompatActivity {
    int viewIsScrolling = 1;
    boolean firstIsTouched = false;
    boolean secondIsTouched = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day);
        RecyclerView recyclerViewStaffTasks = findViewById(R.id.rcv);
        RecyclerView recyclerViewStaff = findViewById(R.id.rcv_staffs);
        // Create sample data
        List<StaffCalendarData> staffList = new ArrayList<>();

        // Example for one staff member
        List<Event> event1s = Event.generateListEvents1();
        List<Event> event2s = Event.generateListEvents2();
        List<Event> event3s = Event.generateListEvents3();
        List<Event> event4s = Event.generateListEvents4();

        staffList.add(new StaffCalendarData("1.Phương", event1s));
        staffList.add(new StaffCalendarData("2.Nhím", event1s));
        staffList.add(new StaffCalendarData("3.Cinnamoroll", event1s));
        staffList.add(new StaffCalendarData("4.Trung", event2s));
        staffList.add(new StaffCalendarData("5.Trọng", event3s));
        staffList.add(new StaffCalendarData("6.Công", event4s));
        staffList.add(new StaffCalendarData("7.Toàn", event3s));

        staffList.add(new StaffCalendarData("8.Phương", event4s));
        staffList.add(new StaffCalendarData("9.Nhím", event4s));
        staffList.add(new StaffCalendarData("10.Cinnamoroll", event2s));
        staffList.add(new StaffCalendarData("11.Trung", event2s));
        staffList.add(new StaffCalendarData("12.Trọng", event2s));
        staffList.add(new StaffCalendarData("13.Công", event2s));
        staffList.add(new StaffCalendarData("14.Toàn", event1s));

        staffList.add(new StaffCalendarData("15.Phương", event1s));
        staffList.add(new StaffCalendarData("16.Nhím", event1s));
        staffList.add(new StaffCalendarData("17.Cinnamoroll", event1s));
        staffList.add(new StaffCalendarData("18.Trung", event2s));
        staffList.add(new StaffCalendarData("19.Trọng", event3s));
        staffList.add(new StaffCalendarData("20.Công", event4s));
        staffList.add(new StaffCalendarData("21.Toàn", event3s));

        staffList.add(new StaffCalendarData("22.Phương", event4s));
        staffList.add(new StaffCalendarData("23.Nhím", event4s));
        staffList.add(new StaffCalendarData("24.Cinnamoroll", event2s));
        staffList.add(new StaffCalendarData("25.Trung", event2s));
        staffList.add(new StaffCalendarData("26.Trọng", event2s));
        staffList.add(new StaffCalendarData("27.Công", event2s));
        staffList.add(new StaffCalendarData("28.Toàn", event1s));

        recyclerViewStaff.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        List<String> staffNames = new ArrayList<>();
        for (StaffCalendarData staff : staffList) {
            staffNames.add(staff.getStaffName());
        }
        Log.e("Staff", staffNames.toString());
        StaffAdapter staffAdapter = new StaffAdapter(staffNames);
        recyclerViewStaff.setAdapter(staffAdapter);
//         Set up RecyclerView
        recyclerViewStaffTasks.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        StaffTaskAdapter adapter = new StaffTaskAdapter(this, staffList, new StaffTaskAdapter.OnEventClickListener() {
            @Override
            public void onEventClick(Event event) {
                Toast.makeText(DayActivity.this, "Event clicked: " + event.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
        recyclerViewStaffTasks.setAdapter(adapter);

        SelfScrolListener firstOSL= new SelfScrolListener() {
            @Override
            public void onScrolled(@NonNull final RecyclerView recyclerView, final int dx, final int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (firstIsTouched) {
                    if (viewIsScrolling == -1) {
                        viewIsScrolling = 0;
                    }
                    if (viewIsScrolling == 0) {
                        recyclerViewStaffTasks.scrollBy(dx, dy);
                    }
                }
            }
        };
        SelfScrolListener secondOSL= new SelfScrolListener() {
            @Override
            public void onScrolled(@NonNull final RecyclerView recyclerView, final int dx, final int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if(secondIsTouched){
                    if (viewIsScrolling == -1) {
                        viewIsScrolling = 1;
                    }
                    if (viewIsScrolling == 1) {
                        recyclerViewStaff.scrollBy(dx, dy);
                    }
                }
            }
        };
        recyclerViewStaff.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                firstIsTouched= true;
                return false;
            }
        });
        recyclerViewStaffTasks.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                secondIsTouched= true;
                return false;
            }
        });
        recyclerViewStaff.addOnScrollListener(firstOSL);
        recyclerViewStaffTasks.addOnScrollListener(secondOSL);

    }
    public class SelfScrolListener extends RecyclerView.OnScrollListener {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                viewIsScrolling = -1;
            }
        }
    }

}