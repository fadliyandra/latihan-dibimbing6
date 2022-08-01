package com.dibimbing.karyawan.service.impl;

import com.dibimbing.karyawan.model.Karyawan;
import com.dibimbing.karyawan.service.KaryawanService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class implKaryawan implements KaryawanService {
    static List<Karyawan> listKaryawan = new ArrayList<>();
    @Override
    public Karyawan save(Karyawan obj) {
        obj.setId(1L);
        listKaryawan.add(obj);
        return obj;
    }

    @Override
    public Karyawan update(Karyawan obj) {
        for(Karyawan data : listKaryawan){
            if(obj.getId() == data.getId()){
                Karyawan update = new Karyawan();
                update.setId(data.getId());
                update.setNama(data.getNama());
                update.setJk(data.getJk());
                update.setDob(data.getDob());
                update.setAlamat(data.getAlamat());
                update.setStatus(data.getStatus());
                listKaryawan.remove(data);
                listKaryawan.add(update);
                return update;
            }
        }
        return null;
    }

    @Override
    public List<Karyawan>deleted(Long id) {
        for(Karyawan data : listKaryawan){
            if(id == data.getId()){
                Karyawan update = new Karyawan();
                update.setId(data.getId());
                update.setNama(data.getNama());
                update.setJk(data.getJk());
                update.setDob(data.getDob());
                update.setAlamat(data.getAlamat());
                update.setStatus(data.getStatus());
                listKaryawan.remove(data);

                return listKaryawan;
            }
        }
        return null;
    }

    @Override
    public List<Karyawan>dataKaryawan(int row,int page) {
        return listKaryawan;
    }

    @Override
    public Karyawan findById(long obj) {
        for(Karyawan data : listKaryawan){
            if(obj == data.getId()){
                return data;
            }
        }
        return null;
    }
}
