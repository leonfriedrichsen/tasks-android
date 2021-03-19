package com.leonfriedrichsen.tasks.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.leonfriedrichsen.tasks.repository.TasksRepository;
import com.leonfriedrichsen.tasks.room.TasksEntity;
import com.leonfriedrichsen.tasks.viewModel.baseObservable.TasksBaseObservable;

import java.util.List;

public class TasksViewModel extends AndroidViewModel {

    private final TasksRepository repository;

    private final TasksBaseObservable baseObservable;

    public TasksViewModel(@NonNull Application application) {
        super(application);

        repository = new TasksRepository(application);

        baseObservable = new TasksBaseObservable();
    }

    public TasksBaseObservable getBaseObservable() {
        return baseObservable;
    }

    public LiveData<List<TasksEntity>> tasks() {
        return repository.tasks();
    }

    public void insertTask(TasksEntity tasksEntity) {
        repository.insertTask(tasksEntity);
    }

    public void updateTask(TasksEntity tasksEntity) {
        repository.updateTask(tasksEntity);
    }

    public void deleteTask(int id) {
        repository.deleteTask(id);
    }
}
