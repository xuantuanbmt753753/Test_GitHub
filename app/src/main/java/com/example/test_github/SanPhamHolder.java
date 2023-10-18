package com.example.test_github;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SanPhamHolder extends RecyclerView.ViewHolder {
TextView tvTenSP, tvMaSP, tvSL;



    public SanPhamHolder(@NonNull View itemView) {
        super(itemView);
        tvTenSP = itemView.findViewById(R.id.tvTenSP);
        tvMaSP = itemView.findViewById(R.id.tvMaSP);
        tvSL = itemView.findViewById(R.id.tvSL);

    }
}
