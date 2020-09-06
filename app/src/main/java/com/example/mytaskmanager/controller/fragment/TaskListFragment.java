package com.example.mytaskmanager.controller.fragment;

import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mytaskmanager.R;
import com.example.mytaskmanager.model.Task;
import com.example.mytaskmanager.repository.TaskRepository;

import java.util.List;

public class TaskListFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private String name;
    private int number;
    private int counterRow;

    private TaskRepository mRepository;
    private Button mButtonAddTask;

    public TaskListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRepository = TaskRepository.getInstance();

        name = getActivity().getIntent().
                getStringExtra(TaskDetailFragment.EXTRA_USER_NAME);
        number = (int) getActivity().getIntent().
                getIntExtra(TaskDetailFragment.EXTRA_NUMBER_OF_TASKS, 0);

        mRepository.setDetail(name, number);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_task_list, container, false);

        findViews(view);
        initViews();
        setListeners();
        return view;
    }


    private void findViews(View view) {
        mRecyclerView = view.findViewById(R.id.recycler_view_task_list);
        mButtonAddTask = view.findViewById(R.id.btn_add);
    }

    private void initViews() {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
            mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        else
            mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        final TaskAdapter taskAdapter = new TaskAdapter(mRepository.getTasks());
        mRecyclerView.setAdapter(taskAdapter);
        mButtonAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Task task = new Task();
                task.setName(name);
                mRepository.getTasks().add(task);
                taskAdapter.notifyItemInserted(++number);

            }
        });
    }

    private void setListeners() {

    }

    public class TaskHolder extends RecyclerView.ViewHolder {

        private TextView mTextViewUsername;
        private TextView mTextViewState;
        private RelativeLayout mRootLayout;

        private Task mTask;

        public TaskHolder(@NonNull View itemView) {
            super(itemView);
            mTextViewUsername = itemView.findViewById(R.id.row_item_user_name);
            mTextViewState = itemView.findViewById(R.id.row_item_number);
            mRootLayout = itemView.findViewById(R.id.row_root_layout);
        }

        public void bindTask(Task task) {
            mTask = task;

            mTextViewUsername.setText(task.getName());
            mTextViewState.setText(task.getState().toString());
        }
    }

    public class TaskAdapter extends RecyclerView.Adapter<TaskHolder> {

        private List<Task> mTasks;

        public List<Task> getTasks() {
            return mTasks;
        }

        public void setTasks(List<Task> tasks) {
            mTasks = tasks;
        }

        public TaskAdapter(List<Task> tasks) {
            mTasks = tasks;
        }

        @Override
        public int getItemCount() {
            return mTasks.size();
        }

        @NonNull
        @Override
        public TaskHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.
                    from(getActivity()).
                    inflate(R.layout.task_row_list, parent, false);
            TaskHolder taskHolder = new TaskHolder(view);
            return taskHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull TaskHolder holder, int position) {
            Task task = mTasks.get(position);
            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {

                if (position % 2 == 0) {
                    holder.mRootLayout.setBackgroundColor(Color.parseColor("#FFC5E85F"));
                } else {
                    holder.mRootLayout.setBackgroundColor(Color.parseColor("#FF58CFE1"));
                }
            }
            else{
                if (counterRow == 4)
                    counterRow = 0;
                if (counterRow == 0 || counterRow == 3) {
                    holder.mRootLayout.setBackgroundColor(Color.parseColor("#FFC5E85F"));
                    counterRow++;
                } else {
                    holder.mRootLayout.setBackgroundColor(Color.parseColor("#FF58CFE1"));
                    counterRow++;
                }

            }

            holder.bindTask(task);
        }
    }
}