package com.example.drawerapp.ui.zad1;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Task1ViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public Task1ViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home2 fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}