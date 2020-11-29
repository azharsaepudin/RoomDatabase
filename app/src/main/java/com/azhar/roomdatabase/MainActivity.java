package com.azhar.roomdatabase;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MahasiswaViewModel mahasiswaViewModel;

    EditText edtNama;
    Button btnInput;

    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final MahasiswaAdapter adapter = new MahasiswaAdapter(new MahasiswaAdapter.WordDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        mahasiswaViewModel = new ViewModelProvider(this).get(MahasiswaViewModel.class);

        mahasiswaViewModel.delete();

        mahasiswaViewModel.getmAllMahasiswa().observe(this, new Observer<List<Mahasiswa>>() {
            @Override
            public void onChanged(@Nullable final List<Mahasiswa> mahasiswas) {

                adapter.submitList(mahasiswas);
            }
        });

        fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showDialogInput();
            }
        });

    }

    public void showDialogInput(){

        final AlertDialog dialogBuilder = new AlertDialog.Builder(this).create();
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.custom_dialog_input, null);

        edtNama = dialogView.findViewById(R.id.edtNama);
        btnInput = dialogView.findViewById(R.id.btnInput);

        btnInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mNama = edtNama.getText().toString();

               saveToDb(mNama);

               dialogBuilder.dismiss();

            }
        });

        dialogBuilder.setView(dialogView);
        dialogBuilder.show();
    }

    public void saveToDb(String mNama){

        Mahasiswa mhs = new Mahasiswa(mNama);

        mahasiswaViewModel.insert(mhs);

    }
}