package com.azhar.roomdatabase;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MahasiswaViewModel extends AndroidViewModel {

    private MahasiswaRepository mahasiswaRepository;
    private final LiveData<List<Mahasiswa>> mAllMahasiswa;

    public MahasiswaViewModel(Application application) {
        super(application);

        mahasiswaRepository = new MahasiswaRepository(application);
        mAllMahasiswa = mahasiswaRepository.getAllMahasiswa();
    }

    public LiveData<List<Mahasiswa>> getmAllMahasiswa(){
        return mAllMahasiswa;
    }

    void insert(Mahasiswa mahasiswa){
        mahasiswaRepository.insert(mahasiswa);
    }

    void delete(){
        mahasiswaRepository.delete();
    }

    void deleteMhs(Mahasiswa mahasiswa){
        mahasiswaRepository.deleteMhs(mahasiswa);
    }

    void updateMhs(String mNama, String paramUpdateMhs){
        mahasiswaRepository.updateMhs(mNama, paramUpdateMhs);
    }
}
