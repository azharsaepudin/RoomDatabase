package com.azhar.roomdatabase;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class MahasiswaRepository {

    private MahasiswaDao mMahasiswaDao;
    private LiveData<List<Mahasiswa>> allMahasiswa;


    MahasiswaRepository(Application application){
        MahasiswaRoomDatabase db = MahasiswaRoomDatabase.getDatabase(application);
        mMahasiswaDao = db.mahasiswaDao();
        allMahasiswa = mMahasiswaDao.getMahasiswa();
    }


    LiveData<List<Mahasiswa>> getAllMahasiswa() {
        return allMahasiswa;
    }

    void insert(Mahasiswa mahasiswa) {
        MahasiswaRoomDatabase.databaseWriteExecutor.execute(() -> {
            mMahasiswaDao.insert(mahasiswa);
        });
    }

    void delete(){
        MahasiswaRoomDatabase.databaseWriteExecutor.execute(() -> {
            mMahasiswaDao.deleteAll();
        });
    }
}
