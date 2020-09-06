package com.example.mytaskmanager.repository;

import com.example.mytaskmanager.model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskRepository {
    public static TaskRepository sInstance;

    private List<Task> mTasks;
    private static String mUserName;
    private static int mNumber;

    public static TaskRepository getInstance() {
        if (sInstance == null)
            sInstance = new TaskRepository();

        return sInstance;
    }

    private TaskRepository() {
        mTasks = new ArrayList<>();
    }

}
