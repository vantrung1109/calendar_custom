package com.example.googlecalendarcustom.ui.adapter;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.googlecalendarcustom.R;
import com.example.googlecalendarcustom.model.Event;
import com.example.googlecalendarcustom.model.StaffCalendarData;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

public class StaffTaskAdapter extends RecyclerView.Adapter<StaffTaskAdapter.StaffTaskViewHolder> {
    private List<StaffCalendarData> staffList;
    private Context context;
    private OnEventClickListener onEventClickListener;

    public StaffTaskAdapter(Context context, List<StaffCalendarData> staffList, OnEventClickListener onEventClickListener) {
        this.context = context;
        this.staffList = staffList;
        this.onEventClickListener = onEventClickListener;
    }

    @Override
    public StaffTaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_staff_tasks, parent, false);
        return new StaffTaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StaffTaskViewHolder holder, int position) {
        StaffCalendarData staff = staffList.get(position);

        // Clear previous events
        holder.eventContainer.removeAllViews();

        // Add all events for this staff
        for (Event event : staff.getEvents()) {
            addEventView(holder.eventContainer, event);
        }
    }

    @Override
    public int getItemCount() {
        return staffList.size();
    }



    public interface OnEventClickListener {
        void onEventClick(Event event);
    }

    private void addEventView(FrameLayout container, Event event) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            RelativeLayout mainViewEvent = (RelativeLayout) LayoutInflater.from(context)
                    .inflate(R.layout.item_event_day, container, false);
            TextView eventTime = mainViewEvent.findViewById(R.id.tv_event_time);
            TextView eventTitle = mainViewEvent.findViewById(R.id.tv_event_title);
            ImageView icStatus = mainViewEvent.findViewById(R.id.ic_status);

            // Set status icon
            if (event.getStatus() == 0) {
                Glide
                        .with(context)
                        .load(R.drawable.ic_created)
                        .into(icStatus);
            } else if (event.getStatus() == 1) {
                Glide
                        .with(context)
                        .load(R.drawable.ic_reject)
                        .into(icStatus);
            } else if (event.getStatus() == 2) {
                Glide
                        .with(context)
                        .load(R.drawable.ic_completed)
                        .into(icStatus);
            }

            mainViewEvent.setOnClickListener(v -> {
                // Handle event click
                onEventClickListener.onEventClick(event);
            });

            eventTime.setText(event.getStartTime().toString() + " - " + event.getEndTime().toString());
            eventTitle.setText(event.getTitle());
            LocalTime calendarStart = LocalTime.of(0, 0); // Changed to start at 00:00
            int startMinutesFromMidnight = (int) Duration.between(calendarStart, event.getStartTime()).toMinutes();
            int durationMinutes = (int) Duration.between(event.getStartTime(), event.getEndTime()).toMinutes();
            int slotHeight = context.getResources().getDimensionPixelSize(com.intuit.sdp.R.dimen._30sdp);
            // HEIGHT - Calculate height and top margin using _30sdp as base
            int height = (durationMinutes * slotHeight) / 30;
            int topMargin = (startMinutesFromMidnight * slotHeight) / 30;
            // Create layout parameters
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.MATCH_PARENT,
                    height
            );
            params.topMargin = topMargin;
            mainViewEvent.setLayoutParams(params);
            // BackgroundColor
            GradientDrawable shape = new GradientDrawable();
            shape.setShape(GradientDrawable.RECTANGLE);
            shape.setCornerRadius(context.getResources().getDimensionPixelSize(com.intuit.sdp.R.dimen._4sdp));
            shape.setColor(ContextCompat.getColor(context,event.getColor()));
            mainViewEvent.setBackground(shape);
            container.addView(mainViewEvent);
        }
    }

    static class StaffTaskViewHolder extends RecyclerView.ViewHolder {
        FrameLayout eventContainer;

        StaffTaskViewHolder(View itemView) {
            super(itemView);
            eventContainer = itemView.findViewById(R.id.eventContainer);
        }
    }
}
