package com.example.colleges.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.colleges.dao.model_dao;
import com.example.colleges.models.model;

import org.jetbrains.annotations.NotNull;

@Database(entities = {model.class}, version = 2)
public abstract class universities_database extends RoomDatabase {

    private static final String DATABASE_NAME = "UNIVERSITIESDATABSE";
    private static volatile universities_database INSTANCE;

    public abstract model_dao model_dao();

    public static universities_database getInstance(Context context){
        if(INSTANCE == null){
            synchronized (universities_database.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context,universities_database.class,DATABASE_NAME)
                            .addCallback(callback).fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    static Callback callback = new Callback() {
        @Override
        public void onCreate(@NonNull @NotNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateAsynTask(INSTANCE);
        }
    };

    static class PopulateAsynTask extends AsyncTask<Void,Void,Void>{

        private  model_dao model_dao;
        PopulateAsynTask(universities_database universities_database){
            model_dao = universities_database.model_dao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            model_dao.deletealluniversities();
            return null;
        }
    }
}
