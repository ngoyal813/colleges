package com.example.colleges.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.colleges.models.model;

import java.util.List;

@Dao
public interface model_dao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<model> universities_list);

    @Query("SELECT * FROM universities")
    LiveData<List<model>> getuniversities();

    @Query("DELETE FROM universities")
    void deletealluniversities();
}
