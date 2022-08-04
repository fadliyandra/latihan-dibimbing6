package com.dibimbing.karyawan.service;

import com.dibimbing.karyawan.model.Karyawan;

import java.util.Map;

public interface KaryawanService {
    public Map insert(Karyawan karyawan);

    public Map update(Karyawan karyawan);

    public Map delete(Long karyawan);

    public Map getAll(int size, int page);
}
