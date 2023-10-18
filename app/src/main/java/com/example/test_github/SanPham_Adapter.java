package com.example.test_github;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SanPham_Adapter extends RecyclerView.Adapter<SanPhamHolder> {
    Context context;
    List<SanPham> data = new ArrayList<>();
    private  OnItemClickListener mListener;

    public SanPham_Adapter(Context context, List<SanPham> data) {
        this.context = context;
        this.data = data;
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListenner(OnItemClickListener listenner){
        mListener = listenner;
    }

    @NonNull
    @Override
    public SanPhamHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SanPhamHolder(LayoutInflater.from(context).inflate(R.layout.layout_sanpham,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull SanPhamHolder holder, int position) {
        SanPham sanPham = data.get(position);

        holder.tvMaSP.setText(sanPham.maSP);
        holder.tvTenSP.setText(sanPham.tenSP);
        holder.tvSL.setText(sanPham.soLuong);

        final int clickedPosition = position;
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mListener != null){
                    mListener.onItemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
