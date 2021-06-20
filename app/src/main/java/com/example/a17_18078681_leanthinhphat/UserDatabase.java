package com.example.a17_18078681_leanthinhphat;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

public abstract class UserDatabase extends RoomDatabase {
    private static final String DATABASE_NAME="user01.db";
    private static UserDatabase instance;

    public static synchronized UserDatabase getInstance(Context context) {
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),UserDatabase.class,DATABASE_NAME)
                    .allowMainThreadQueries().build();
        }
        return instance;
    }
    public abstract UserDAO userDao();
}
