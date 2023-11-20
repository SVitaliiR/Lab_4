package com.example.notepad.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.notepad.Models.Notes;
import static androidx.room.OnConflictStrategy.REPLACE;

import java.util.List;

@Dao
public interface DataAccessObject {
    @Insert(onConflict = REPLACE)
    void insert(Notes notes);

    @Query("SELECT * FROM notes ORDER BY id DESC")
    List<Notes> getAll();

    @Query("UPDATE notes SET title = :title, notes = :notes WHERE ID = :id")
    void toUpdate(int id, String title, String notes);

    @Delete
    void delete(Notes notes);
}
