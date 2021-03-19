package com.leonfriedrichsen.tasks.view.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.leonfriedrichsen.tasks.R;
import com.leonfriedrichsen.tasks.databinding.ActivityMainBinding;
import com.leonfriedrichsen.tasks.room.TasksEntity;
import com.leonfriedrichsen.tasks.view.adapter.TasksAdapter;
import com.leonfriedrichsen.tasks.viewModel.TasksViewModel;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TasksAdapter.OnTaskClickListener  {

    private ActivityMainBinding binding;

    public TasksViewModel viewModel;

    public TasksAdapter adapter;

    public LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(TasksViewModel.class);

        adapter = new TasksAdapter(this);

        linearLayoutManager = new LinearLayoutManager(this);

        binding.setViewModel(viewModel);

        setOnClickListener();

        setRecyclerView();
    }

    private void setOnClickListener() {
        binding.addFab.setOnClickListener(v -> new AddTaskBottomSheet().show(getSupportFragmentManager(), null));

        binding.todayButton.setOnClickListener(v -> scrollToToday(adapter.getTasks()));
    }

    private void setRecyclerView() {
        binding.recyclerView.setLayoutManager(linearLayoutManager);
        binding.recyclerView.setAdapter(adapter);

        viewModel.tasks().observe(this, tasksEntities -> {
            if(adapter.getItemCount() == 0) {
                adapter.setTasks(tasksEntities);
                scrollToToday(tasksEntities);
            }else {
                adapter.setTasks(tasksEntities);
            }
            binding.noTasksLayout.setVisibility(adapter.getItemCount() == 0 ? View.VISIBLE : View.GONE);
        });
    }

    @Override
    public void onTaskClick(TasksEntity tasksEntity) {
        AddTaskBottomSheet.newInstance(tasksEntity).show(getSupportFragmentManager(), null);
    }

    @Override
    public void onTaskDone(TasksEntity tasksEntity) {
        viewModel.updateTask(tasksEntity);
    }

    public void scrollToToday(List<TasksEntity> tasksEntities) {
        for(int i = 0; i < tasksEntities.size(); i++) {
            if(sameDay(tasksEntities.get(i).getDate())) {
                linearLayoutManager.scrollToPositionWithOffset(i, 0);
                break;
            }
        }
    }

    private boolean sameDay(long date) {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(new Date(date));

        Calendar calendar2 =  Calendar.getInstance();

        return calendar1.get(Calendar.DAY_OF_YEAR) == calendar2.get(Calendar.DAY_OF_YEAR) &&
                calendar1.get(Calendar.YEAR) == calendar2.get(Calendar.YEAR);
    }
}