package com.example.test_github;

public class SanPham {
    String maSP, tenSP, soLuong;

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
    }

    public SanPham(String maSP, String tenSP, String soLuong) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.soLuong = soLuong;
    }
}
