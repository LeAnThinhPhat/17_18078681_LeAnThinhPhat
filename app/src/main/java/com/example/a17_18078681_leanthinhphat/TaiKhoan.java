package com.example.a17_18078681_leanthinhphat;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class TaiKhoan implements Serializable {
    @PrimaryKey(autoGenerate = true)
    int id;
    String email;
    String time;

    @Ignore
    public TaiKhoan(int id, String email, String time) {
        this.id = id;
        this.email = email;
        this.time = time;
    }

    public TaiKhoan(String email, String time) {
        this.email = email;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
