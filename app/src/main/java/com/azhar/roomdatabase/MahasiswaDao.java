package com.azhar.roomdatabase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MahasiswaDao {

@Query("SELECT * FROM mahasiswa_table")
    LiveData<List<Mahasiswa>> getMahasiswa();

    @Query("DELETE FROM mahasiswa_table")
    void deleteAll();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Mahasiswa mahasiswa);


//    @Query("INSERT INTO mahasiswa_table VALUES(:mahasiswa_database)")
//    void insert(String mahasiswa_database);
}
