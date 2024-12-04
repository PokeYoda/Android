package com.example.drawerapp.ui.zad4;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Task4ViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public Task4ViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home2 fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}