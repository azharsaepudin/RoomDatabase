package com.azhar.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    EditText edtNamaEdit;
    Button btnUpdate, btnDelete;
    String paramUpdateMhs;

    private MahasiswaViewModel mahasiswaViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        edtNamaEdit = findViewById(R.id.edtNamaEdit);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);

        mahasiswaViewModel = new ViewModelProvider(this).get(MahasiswaViewModel.class);

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            String namaMhs = extras.getString("nama_mhs");
            paramUpdateMhs = namaMhs;
            edtNamaEdit.setText(namaMhs);
        }

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mNama = edtNamaEdit.getText().toString();

                updateData(mNama);
                finish();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mNama = edtNamaEdit.getText().toString();

                deleteData(mNama);
                finish();

            }
        });
    }

    public void deleteData(String mNama){

        Mahasiswa mhs = new Mahasiswa(mNama);
        mahasiswaViewModel.deleteMhs(mhs);

    }

    public void updateData(String mNama){
        mahasiswaViewModel.updateMhs(mNama, paramUpdateMhs);
    }
}