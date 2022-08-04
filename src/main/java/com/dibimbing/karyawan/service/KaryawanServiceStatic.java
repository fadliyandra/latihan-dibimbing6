package com.dibimbing.karyawan.service;

import com.dibimbing.karyawan.model.Karyawan;

import java.util.List;

public interface KaryawanServiceStatic {
    public Karyawan save(Karyawan obj);
    public Karyawan update(Karyawan obj);
    public List<Karyawan> deleted(Long id);
    public List<Karyawan> dataKaryawan(int row, int page);
    public Karyawan findById(long obj);


}
