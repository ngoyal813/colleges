package com.example.colleges.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.colleges.dao.model_dao;
import com.example.colleges.database.universities_database;
import com.example.colleges.models.model;

import java.util.List;

public class universities_repository {

    private universities_database database;

    public LiveData<List<model>> getGetuniversities() {
        return getuniversities;
    }

    public LiveData<List<model>> getuniversities;
    private model_dao dao;

    public universities_repository(Application application){
        database = universities_database.getInstance(application);
        dao = database.model_dao();
        getuniversities = database.model_dao().getuniversities();
    }

    public void insertuniversities(List<model> universitiesList){
        new InsertAsynctask(database).execute(universitiesList);
    }

    static class InsertAsynctask extends AsyncTask<List<model>,Void,Void> {
        private model_dao model_dao;
        InsertAsynctask(universities_database database){
            model_dao = database.model_dao();
        }
        @Override
        protected Void doInBackground(List<model>... lists) {
            model_dao.insert(lists[0]);
            return null;
        }
    }
    public  void deleteall(){
        new deleteallasynctask(dao).execute();
    }

    private static  class deleteallasynctask extends AsyncTask<Void,Void,Void> {
        private model_dao Dao;
        public deleteallasynctask(model_dao dao) {
            Dao = dao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            Dao.deletealluniversities();
            return null;
        }
    }
}
