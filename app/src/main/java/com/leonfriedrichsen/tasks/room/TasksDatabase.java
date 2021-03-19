package com.leonfriedrichsen.tasks.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {TasksEntity.class}, version = 1, exportSchema = false)
public abstract class TasksDatabase extends RoomDatabase {

    private static TasksDatabase instance;

    public abstract TasksDao tasksDao();

    public static synchronized TasksDatabase getInstance(Context context) {
        if(instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    TasksDatabase.class, "TasksDatabase")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}