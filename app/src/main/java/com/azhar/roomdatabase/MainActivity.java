package com.azhar.roomdatabase;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MahasiswaViewModel mahasiswaViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final MahasiswaAdapter adapter = new MahasiswaAdapter(new MahasiswaAdapter.WordDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mahasiswaViewModel = new ViewModelProvider(this).get(MahasiswaViewModel.class);

        mahasiswaViewModel.getmAllMahasiswa().observe(this, new Observer<List<Mahasiswa>>() {
            @Override
            public void onChanged(@Nullable final List<Mahasiswa> mahasiswas) {
                // Update the cached copy of the words in the adapter.
                adapter.submitList(mahasiswas);
            }
        });

    }
}