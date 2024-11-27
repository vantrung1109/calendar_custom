package com.example.googlecalendarcustom.ui;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.googlecalendarcustom.ui.adapter.CalendarAdapter;
import com.example.googlecalendarcustom.R;
import com.example.googlecalendarcustom.model.DayItem;
import com.example.googlecalendarcustom.model.Event;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MonthActivity extends AppCompatActivity implements CalendarAdapter.OnItemClickListener {

    private RecyclerView recyclerView;
    private CalendarAdapter adapter;
    private TextView monthYearText;
    private Calendar currentDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.calendarRecyclerView);
        monthYearText = findViewById(R.id.monthYearText);

        // Initialize current date
        currentDate = Calendar.getInstance();

        // Set up RecyclerView
        recyclerView.setLayoutManager(new GridLayoutManager(this, 7));
        adapter = new CalendarAdapter(DayItem.generateListDayItems(currentDate), this);
        recyclerView.setAdapter(adapter);

        // Set up navigation buttons
        findViewById(R.id.previousButton).setOnClickListener(v -> {
            currentDate.add(Calendar.MONTH, -1);
            updateCalendar();
        });

        findViewById(R.id.nextButton).setOnClickListener(v -> {
            currentDate.add(Calendar.MONTH, 1);
            updateCalendar();
        });

        updateCalendar();
    }

    private void updateCalendar() {
        SimpleDateFormat formatter = new SimpleDateFormat("MMMM yyyy", Locale.getDefault());
        monthYearText.setText(formatter.format(currentDate.getTime()));
        adapter.updateData(DayItem.generateListDayItems(currentDate));
    }



    @Override
    public void onItemClick(DayItem day, int position) {
        if (day.hasEvent) {
            // Show events for this day
            StringBuilder events = new StringBuilder();
            for (Event event : day.events) {
                events.append(event.title).append("\n");
            }
            Toast.makeText(this, events.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}