package com.leonfriedrichsen.tasks.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.leonfriedrichsen.tasks.room.TasksDatabase;
import com.leonfriedrichsen.tasks.room.TasksEntity;

import java.util.List;

public class TasksRepository {

    private final TasksDatabase database;

    public TasksRepository(Application application) {
        database = TasksDatabase.getInstance(application);
    }

    public LiveData<List<TasksEntity>> tasks() {
        return database.tasksDao().tasks();
    }

    public void insertTask(TasksEntity tasksEntity) {
        AsyncTask.execute(() -> database.tasksDao().insert(tasksEntity));
    }

    public void updateTask(TasksEntity tasksEntity) {
        AsyncTask.execute(() -> database.tasksDao().update(tasksEntity));
    }

    public void deleteTask(int id) {
        AsyncTask.execute(() -> database.tasksDao().delete(id));
    }
}
