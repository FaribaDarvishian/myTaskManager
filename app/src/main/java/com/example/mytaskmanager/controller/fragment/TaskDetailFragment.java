package com.example.mytaskmanager.controller.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.mytaskmanager.R;
import com.google.android.material.textfield.TextInputLayout;

public class TaskDetailFragment extends Fragment {

    private TextInputLayout mEditTextUserName;
    private TextInputLayout mEditTextNumber;
    private Button mButtonCreate;

    public TaskDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_task_detail, container, false);
        findViews(view);
        initViews();
        setListeners();
        return view;
    }

    private void findViews(View view) {
        mEditTextUserName = view.findViewById(R.id.edit_txt_username);
        mEditTextNumber = view.findViewById(R.id.edit_txt_number);
        mButtonCreate = view.findViewById(R.id.btn_create);
    }

    private void initViews() {

    }

    private void setListeners() {
        mButtonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(mEditTextUserName.getEditText().getText().toString().trim().isEmpty()) {
                    mEditTextUserName.setErrorEnabled(true);
                    mEditTextUserName.setError("Complete Field");
                }

                else if(mEditTextNumber.getEditText().getText().toString().length() == 0) {
                    mEditTextUserName.setErrorEnabled(false);
                    mEditTextNumber.setErrorEnabled(true);
                    mEditTextNumber.setError("Complete Field");
                }



                else
                    {
                    mEditTextUserName.setErrorEnabled(false);
                    mEditTextNumber.setErrorEnabled(false);

                   //ToDo we should StartActivity whit Intent
                }
            }
        });
    }
}