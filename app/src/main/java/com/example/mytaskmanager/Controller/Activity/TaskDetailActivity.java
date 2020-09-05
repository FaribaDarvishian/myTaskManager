package com.example.mytaskmanager.Controller.Activity;

import androidx.fragment.app.Fragment;

import com.example.mytaskmanager.Controller.Fragment.TaskDetailFragment;

public class TaskDetailActivity extends SingleFragmentActivity {

    @Override
    public Fragment createFragment() {
        return new TaskDetailFragment();

    }
}