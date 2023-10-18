package com.example.test_github;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<SanPham> data_SP = new ArrayList<>();
    RecyclerView recyclerView;

    EditText edtMaSP, edtTenSP, edtSL;

    Button btnThem,btnXoa, btnSua;

    int index = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setControl();
        setEvent();
        EnableItemTrue();
    }

    private void setEvent() {
        KhoiTao();
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(new SanPham_Adapter(this, data_SP));

        SanPham_Adapter sanPhamAdapter = (SanPham_Adapter) recyclerView.getAdapter();
        sanPhamAdapter.setOnItemClickListenner(new SanPham_Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                SanPham sanPham = data_SP.get(position);
                edtMaSP.setText(sanPham.getMaSP());
                edtTenSP.setText(sanPham.getTenSP());
                edtSL.setText(sanPham.getSoLuong()+position);
                index = position;
                EnableItemFalse();
            }

        });

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SanPham sanPham = new SanPham(edtMaSP.getText().toString(),edtTenSP.getText().toString(),edtSL.getText().toString());
                data_SP.add(sanPham);
                recyclerView.getAdapter().notifyDataSetChanged();
                clearItem();
            }
        });


        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                data_SP.remove(index);
                index = -1;
                recyclerView.getAdapter().notifyDataSetChanged();
                EnableItemTrue();
                clearItem();
            }
        });

        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SanPham sanPham = data_SP.get(index);
                sanPham.maSP = edtMaSP.getText().toString();
                sanPham.tenSP = edtTenSP.getText().toString();
                sanPham.soLuong = edtSL.getText().toString();
                EnableItemTrue();
                recyclerView.getAdapter().notifyDataSetChanged();
                clearItem();
            }
        });
    }

    private void KhoiTao() {
        data_SP.add(new SanPham("01", "SamSung A12", "45"));
        data_SP.add(new SanPham("02", "Oppo 14", "10"));
    }

    private void setControl() {
        recyclerView = findViewById(R.id.recysDS);
        edtMaSP = findViewById(R.id.edtMaSP);
        edtTenSP = findViewById(R.id.edtTenSP);
        edtSL = findViewById(R.id.edtSL);
        btnThem = findViewById(R.id.btnThem);
        btnXoa = findViewById(R.id.btnXoa);
        btnSua = findViewById(R.id.btnSua);
    }

    private void clearItem() {
        edtMaSP.setText("");
        edtTenSP.setText("");
        edtSL.setText("");
    }
    private void EnableItemTrue() {
        btnXoa.setEnabled(false);
        btnSua.setEnabled(false);
        edtMaSP.setEnabled(true);
        btnThem.setEnabled(true);
    }
    private void EnableItemFalse() {
        btnXoa.setEnabled(true);
        btnSua.setEnabled(true);
        btnThem.setEnabled(false);
        edtMaSP.setEnabled(false);
    }
}