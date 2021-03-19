package com.leonfriedrichsen.tasks.view.ui;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.leonfriedrichsen.tasks.R;
import com.leonfriedrichsen.tasks.databinding.BottomSheetAddTaskBinding;
import com.leonfriedrichsen.tasks.room.TasksEntity;
import com.leonfriedrichsen.tasks.viewModel.TasksViewModel;

import java.util.Calendar;
import java.util.Date;

public class AddTaskBottomSheet extends BottomSheetDialogFragment {

    private BottomSheetAddTaskBinding binding;

    private TasksViewModel viewModel;

    private Bundle args;

    public static AddTaskBottomSheet newInstance(TasksEntity tasksEntity) {
        AddTaskBottomSheet bottomSheet = new AddTaskBottomSheet();
        Bundle args = new Bundle();
        args.putInt("id", tasksEntity.getId());
        args.putString("task", tasksEntity.getTask());
        args.putLong("date", tasksEntity.getDate());
        args.putBoolean("isDone", tasksEntity.isDone());
        bottomSheet.setArguments(args);

        return bottomSheet;
    }

    @Override
    public int getTheme() {
        return R.style.BottomSheetDialogTheme;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.bottom_sheet_add_task, container,
                false);

        viewModel = new ViewModelProvider(this).get(TasksViewModel.class);

        args = getArguments();

        binding.setViewModel(viewModel);

        getData();

        setOnClickListener();

        return binding.getRoot();
    }

    private void getData() {
        if(args != null) {
            binding.titleTextView.setText(R.string.editTask);
            binding.addTextView.setText(R.string.save);
            binding.deleteTaskButton.setVisibility(View.VISIBLE);

            viewModel.getBaseObservable().setTask(args.getString("task"));

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date(args.getLong("date")));

            binding.datePicker.updateDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        }
    }

    private void setOnClickListener() {
        binding.deleteTaskButton.setOnClickListener(v -> {
            viewModel.deleteTask(args.getInt("id"));
            dismiss();
        });

        binding.addCardView.setOnClickListener(v -> {
            Editable taskText = binding.taskTextInputEditText.getText();

            if(taskText != null && !TextUtils.isEmpty(taskText)) {
                TasksEntity task = new TasksEntity(taskText.toString(), date().getTime(), false);
                if(args != null) {
                    task.setId(args.getInt("id"));
                    task.setDone(args.getBoolean("isDone"));
                    viewModel.updateTask(task);
                }else {
                    viewModel.insertTask(task);
                }
                dismiss();
            }
        });
    }

    public Date date(){
        int day = binding.datePicker.getDayOfMonth();
        int month = binding.datePicker.getMonth();
        int year =  binding.datePicker.getYear();

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);

        return calendar.getTime();
    }
}
