package com.azhar.roomdatabase;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class MahasiswaViewHolder extends RecyclerView.ViewHolder {

    private final TextView mNamaMahasiswa;
    CardView item_list;

    private MahasiswaViewHolder(View itemView) {
        super(itemView);

        mNamaMahasiswa = itemView.findViewById(R.id.mNamaMahasiswa);
        item_list = itemView.findViewById(R.id.item_list);


        item_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mNama = mNamaMahasiswa.getText().toString();

                Intent i = new Intent(v.getContext(), EditActivity.class);
                i.putExtra("nama_mhs", mNama);
                v.getContext().startActivity(i);


            }
        });


    }

    public void bind(String text) {
        mNamaMahasiswa.setText(text);
    }

    static MahasiswaViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new MahasiswaViewHolder(view);
    }
}
