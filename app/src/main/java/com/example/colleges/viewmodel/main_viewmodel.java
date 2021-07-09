package com.example.colleges.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.colleges.models.model;
import com.example.colleges.repository.universities_repository;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class main_viewmodel extends AndroidViewModel {

    public main_viewmodel(@NonNull @NotNull Application application) {
        super(application);
        repository = new universities_repository(application);
        getuniversities_list = repository.getGetuniversities();
    }

    private universities_repository repository;

    public LiveData<List<model>> getGetuniversities_list() {
        return getuniversities_list;
    }

    private LiveData<List<model>> getuniversities_list;
    public void insertuniversities(List<model> list){
        repository.insertuniversities(list);
    }
    public  void  deleteall(){
        repository.deleteall();
    }

}
