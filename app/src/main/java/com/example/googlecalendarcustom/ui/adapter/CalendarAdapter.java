package com.example.googlecalendarcustom.ui.adapter;

import android.content.res.Resources;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.googlecalendarcustom.R;
import com.example.googlecalendarcustom.model.DayItem;
import com.example.googlecalendarcustom.model.Event;

import java.util.List;

public class CalendarAdapter extends RecyclerView.Adapter<CalendarAdapter.CalendarViewHolder> {
    private List<DayItem> days;
    RecyclerView eventRecyclerView;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(DayItem day, int position);
    }

    public CalendarAdapter(List<DayItem> days, OnItemClickListener listener) {
        this.days = days;
        this.listener = listener;
    }

    @Override
    public CalendarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_calendar_cell, parent, false);

        // Get the total height of RecyclerView
        int totalHeight = Resources.getSystem().getDisplayMetrics().heightPixels;
        int heightBasedSize = totalHeight / 7;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = heightBasedSize;
        view.setLayoutParams(layoutParams);

        return new CalendarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CalendarViewHolder holder, int position) {
        DayItem day = days.get(position);

        // Set the day number
        holder.dayText.setText(String.valueOf(day.date));

        // Set text color based on whether the day is in the current month
        holder.dayText.setTextColor(day.isCurrentMonth ?
                Color.BLACK : Color.GRAY);

        // Set up events
        if (day.hasEvent && day.events != null && !day.events.isEmpty()) {
            Log.e("DayHasEvent", "Day " + day.date + " has events");
            holder.rcvEvents.setVisibility(View.VISIBLE);
            EventAdapter eventAdapter = new EventAdapter(day.events);
            holder.rcvEvents.setAdapter(eventAdapter);
            holder.rcvEvents.setLayoutManager(new LinearLayoutManager(holder.rcvEvents.getContext()));
        } else {
            holder.rcvEvents.setVisibility(View.GONE);
        }

        // Set click listener
        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(day, position);
            }
        });

        if (day.hasEvent && day.events != null && !day.events.isEmpty()) {
            holder.rcvEvents.setVisibility(View.VISIBLE);
            // Limit to first 3 events
            List<Event> visibleEvents = day.events;
            if (day.events.size() > 3) {
                visibleEvents = day.events.subList(0, 3);
                // You could add a "+X more" item here
            }
            EventAdapter eventAdapter = new EventAdapter(visibleEvents);
            holder.rcvEvents.setAdapter(eventAdapter);
        }
    }

    @Override
    public int getItemCount() {
        return days.size();
    }

    private int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }

    // Method to update calendar data
    public void updateData(List<DayItem> newDays) {
        this.days = newDays;
        notifyDataSetChanged();
    }

    public static class CalendarViewHolder extends RecyclerView.ViewHolder {
        TextView dayText;
        View eventDot;
        RecyclerView rcvEvents;

        public CalendarViewHolder(View view) {
            super(view);
            dayText = view.findViewById(R.id.cellDayText);
            rcvEvents = view.findViewById(R.id.rcvEvents);
        }
    }
}
