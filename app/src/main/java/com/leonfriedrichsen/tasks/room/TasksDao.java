package com.leonfriedrichsen.tasks.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TasksDao {

    @Insert
    void insert(TasksEntity tasksEntity);

    @Update
    void update(TasksEntity tasksEntity);

    @Query("DELETE FROM tasks WHERE id = :id")
    void delete(int id);

    @Query("SELECT * FROM tasks ORDER BY date")
    LiveData<List<TasksEntity>> tasks();
}
