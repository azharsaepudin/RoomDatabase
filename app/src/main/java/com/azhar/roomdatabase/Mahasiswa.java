package com.azhar.roomdatabase;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "mahasiswa_table")
public class Mahasiswa {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "nama")
    private String nama;

    public Mahasiswa(@NonNull String nama) {
        this.nama = nama;
    }

    @NonNull
    public String getNama() {
        return this.nama;
    }
}
