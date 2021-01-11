package com.k3518049.alam.dto;

import java.util.Date;

public class PresensiDto{
    private Integer id;
    private String tgl_masuk;
    private Integer id_user;

    public PresensiDto() {
    }

    public PresensiDto(Integer id, String tgl_masuk, Integer id_user) {
        this.id = id;
        this.tgl_masuk = tgl_masuk;
        this.id_user = id_user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTgl_masuk() {
        return tgl_masuk;
    }

    public void setTgl_masuk(String tgl_masuk) {
        this.tgl_masuk = tgl_masuk;
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }
}
