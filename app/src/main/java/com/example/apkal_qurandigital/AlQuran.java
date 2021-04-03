package com.example.apkal_qurandigital;

import java.io.Serializable;

public class AlQuran implements Serializable {
    private String arti;
    private String asma;
    private int ayat;
    private String nama;
    private  String type;
    private String urut;
    private String audio;
    private String keterangan;
    private String nomor;

    public AlQuran(String arti, String asma, int ayat, String nama, String type, String urut, String audio, String keterangan) {
        this.arti = arti;
        this.asma = asma;
        this.ayat = ayat;
        this.nama = nama;
        this.type = type;
        this.urut = urut;
        this.audio = audio;
        this.keterangan = keterangan;
    }

    public String getArti() {
        return arti;
    }

    public void setArti(String arti) {
        this.arti = arti;
    }

    public String getAsma() {
        return asma;
    }

    public void setAsma(String asma) {
        this.asma = asma;
    }

    public int getAyat() {
        return ayat;
    }

    public void setAyat(int ayat) {
        this.ayat = ayat;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrut() {
        return urut;
    }

    public void setUrut(String urut) {
        this.urut = urut;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getNomor() {
        return nomor;
    }

    public void setNomor(String nomor) {
        this.nomor = nomor;
    }
}
