package com.example.googlecalendarcustom.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.googlecalendarcustom.R;
import com.example.googlecalendarcustom.model.Event;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {
    private List<Event> events;

    public EventAdapter(List<Event> events) {
        this.events = events;
    }

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_event, parent, false);
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EventViewHolder holder, int position) {
        Event event = events.get(position);
        holder.eventColor.setBackgroundColor(event.color);
        holder.eventTitle.setText(event.title);
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    static class EventViewHolder extends RecyclerView.ViewHolder {
        View eventColor;
        TextView eventTitle;

        EventViewHolder(View itemView) {
            super(itemView);
            eventColor = itemView.findViewById(R.id.eventColor);
            eventTitle = itemView.findViewById(R.id.eventTitle);
        }
    }
}