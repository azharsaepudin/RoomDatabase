package com.azhar.roomdatabase;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

public class MahasiswaAdapter extends ListAdapter<Mahasiswa, MahasiswaViewHolder> {

    public MahasiswaAdapter(@NonNull DiffUtil.ItemCallback<Mahasiswa> diffCallback) {
        super(diffCallback);
    }


    @NonNull
    @Override
    public MahasiswaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return MahasiswaViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull MahasiswaViewHolder holder, int position) {
        Mahasiswa current = getItem(position);
        holder.bind(current.getNama());
    }

    static class WordDiff extends DiffUtil.ItemCallback<Mahasiswa> {

        @Override
        public boolean areItemsTheSame(@NonNull Mahasiswa oldItem, @NonNull Mahasiswa newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Mahasiswa oldItem, @NonNull Mahasiswa newItem) {
            return oldItem.getNama().equals(newItem.getNama());
        }
    }
}