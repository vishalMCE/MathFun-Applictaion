package com.vishal.vishalsinghmcedtu.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This app contains 10 Amazing Maths and Logic games in English");
    }

    public LiveData<String> getText() {
        return mText;
    }
}