package com.example.mytaskmanager.model;

import java.util.Random;
import java.util.UUID;

public class Task {
    private UUID mId;
    private String mName;
    private State mState;

    public UUID getId() {
        return mId;
    }

    public void setId(UUID mId) {
        this.mId = mId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public State getState() {
        return mState;
    }

    public void setState(State mState) {
        this.mState = mState;
    }

    public Task() {
        mId = UUID.randomUUID();
        mState = State.values()[new Random().nextInt(State.values().length)];
    }
}
