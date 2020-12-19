package com.azhar.roomdatabase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MahasiswaDao {

@Query("SELECT * FROM mahasiswa_table")
    LiveData<List<Mahasiswa>> getMahasiswa();

    @Query("DELETE FROM mahasiswa_table")
    void deleteAll();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Mahasiswa mahasiswa);

    @Delete
    void deleteMhs(Mahasiswa mahasiswa);

    @Query("UPDATE mahasiswa_table SET nama = :mNama WHERE nama = :paramUpdateMhs")
    void updateMhs(String mNama, String paramUpdateMhs);

}
