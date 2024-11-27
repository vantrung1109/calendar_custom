package com.example.googlecalendarcustom.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.googlecalendarcustom.R;

import java.util.List;

public class StaffAdapter extends RecyclerView.Adapter<StaffAdapter.StaffViewHolder> {

    List<String> staffNames;

    public StaffAdapter(List<String> staffNames) {
        this.staffNames = staffNames;
    }

    @NonNull
    @Override
    public StaffViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_staff, parent, false);
        return new StaffViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StaffViewHolder holder, int position) {
        holder.tvStaffName.setText(staffNames.get(position));
    }

    @Override
    public int getItemCount() {
        return staffNames.size();
    }

    public static class StaffViewHolder extends RecyclerView.ViewHolder {
        TextView tvStaffName;
        public StaffViewHolder(View itemView) {
            super(itemView);
            tvStaffName = itemView.findViewById(R.id.tv_staff_name);
        }
    }
}
