package com.example.mytaskmanager.controller.activity;

import androidx.fragment.app.Fragment;

import com.example.mytaskmanager.controller.fragment.TaskDetailFragment;

public class TaskDetailActivity extends SingleFragmentActivity {

    @Override
    public Fragment createFragment() {
        return new TaskDetailFragment();
    }
    }