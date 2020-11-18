package com.example.listandgrid;

public class ListviewModel {
    int image;
    String tenSP, mota;
    int img;
    String tichluy;

    public ListviewModel(int image, String tenSP, String mota, int img, String tichluy) {
        this.image = image;
        this.tenSP = tenSP;
        this.mota = mota;
        this.img = img;
        this.tichluy = tichluy;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTichluy() {
        return tichluy;
    }

    public void setTichluy(String tichluy) {
        this.tichluy = tichluy;
    }
}
