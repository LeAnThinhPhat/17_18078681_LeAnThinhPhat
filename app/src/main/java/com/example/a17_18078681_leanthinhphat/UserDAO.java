package com.example.a17_18078681_leanthinhphat;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDAO {

    @Query("SELECT * FROM TaiKhoan")
    List<TaiKhoan> getAll();

    @Insert
    void addUser(TaiKhoan... donut);

    @Delete
    void deleteUser(TaiKhoan... donut);

    @Update
    void updateUser(TaiKhoan... donut);

}
