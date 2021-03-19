package com.leonfriedrichsen.tasks.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.leonfriedrichsen.tasks.R;
import com.leonfriedrichsen.tasks.room.TasksEntity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class TasksAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<TasksEntity> tasks;

    private final OnTaskClickListener onTaskClickListener;

    public interface OnTaskClickListener {
        void onTaskClick(TasksEntity tasksEntity);

        void onTaskDone(TasksEntity tasksEntity);
    }

    public TasksAdapter(OnTaskClickListener onTaskClickListener) {
        tasks = new ArrayList<>();

        this.onTaskClickListener = onTaskClickListener;
    }

    public void setTasks(List<TasksEntity> tasks) {
            this.tasks = tasks;
            notifyDataSetChanged();
    }

    public List<TasksEntity> getTasks() {
        return tasks;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        TasksEntity task = tasks.get(position);

        ViewHolder viewHolder = ((ViewHolder) holder);

        Calendar today = Calendar.getInstance();

        Date date = new Date(task.getDate());

        boolean isDateItem = position == 0 || !sameDay(task.getDate(), tasks.get(position - 1).getDate());
        viewHolder.day.setVisibility(isDateItem ? View.VISIBLE : View.GONE);
        viewHolder.date.setVisibility(isDateItem ? View.VISIBLE : View.GONE);

        viewHolder.cardView.setOnClickListener(v -> onTaskClickListener.onTaskClick(task));

        viewHolder.cardView.setAlpha(task.isDone() ? 0.5f : 1f);

        viewHolder.checkBox.setOnClickListener(v -> {
            task.setDone(viewHolder.checkBox.isChecked());
            onTaskClickListener.onTaskDone(task);
        });

        viewHolder.task.setText(task.getTask());

        viewHolder.checkBox.setChecked(task.isDone());

        if(sameYear(task.getDate(), today.getTime().getTime())) {
            viewHolder.date.setText(new SimpleDateFormat("dd. MMMM", Locale.getDefault()).format(date));
        }else {
            viewHolder.date.setText(new SimpleDateFormat("dd. MMMM yyyy", Locale.getDefault()).format(date));
        }

        if(sameDay(task.getDate(), today.getTime().getTime())) {
            viewHolder.day.setText(R.string.today);
            return;
        }

        Calendar tomorrow = Calendar.getInstance();
        tomorrow.add(Calendar.DATE, 1);

        if(sameDay(date.getTime(), tomorrow.getTime().getTime())) {
            viewHolder.day.setText(R.string.tomorrow);
            return;
        }

        viewHolder.day.setText(new SimpleDateFormat("EEEE", Locale.getDefault()).format(date));
    }

    @Override
    public int getItemCount() {
        return tasks == null ? 0 : tasks.size();
    }

    private boolean sameDay(long date1, long date2) {
        Calendar calendar1 = calendar(date1);
        Calendar calendar2 =  calendar(date2);

        return calendar1.get(Calendar.DAY_OF_YEAR) == calendar2.get(Calendar.DAY_OF_YEAR) &&
                calendar1.get(Calendar.YEAR) == calendar2.get(Calendar.YEAR);
    }

    private boolean sameYear(long date1, long date2) {
        Calendar calendar1 = calendar(date1);
        Calendar calendar2 =  calendar(date2);

        return calendar1.get(Calendar.YEAR) == calendar2.get(Calendar.YEAR);
    }

    private Calendar calendar(long date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(date));

        return calendar;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private final MaterialCardView cardView;
        private final CheckBox checkBox;
        private final TextView task;
        private final TextView day;
        private final TextView date;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardView);
            checkBox = itemView.findViewById(R.id.checkBox);
            task = itemView.findViewById(R.id.taskTextView);
            day = itemView.findViewById(R.id.dayTextView);
            date = itemView.findViewById(R.id.dateTextView);
        }
    }
}

