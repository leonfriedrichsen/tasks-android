package com.leonfriedrichsen.tasks.viewModel.baseObservable;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.leonfriedrichsen.tasks.BR;

public class TasksBaseObservable extends BaseObservable {

    private String task;

    @Bindable
    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
        notifyPropertyChanged(BR.task);
    }
}
