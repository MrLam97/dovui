package com.example.mrlam.dovui;

public class Tonghopcauhoi {
    private String Cauhoi;
    private boolean Dapan;

    public Tonghopcauhoi(String cauhoi, boolean dapan) {
        Cauhoi = cauhoi;
        Dapan = dapan;
    }

    public String getCauhoi() {
        return Cauhoi;
    }

    public void setCauhoi(String cauhoi) {
        Cauhoi = cauhoi;
    }

    public boolean isDapan() {
        return Dapan;
    }

    public void setDapan(boolean dapan) {
        Dapan = dapan;
    }
}
