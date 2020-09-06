package com.example.mytaskmanager.controller.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.mytaskmanager.R;
import com.example.mytaskmanager.controller.fragment.TaskListFragment;

public class TaskListActivity extends SingleFragmentActivity {
    @Override
    public Fragment createFragment() {
        return new TaskListFragment();
    }
}