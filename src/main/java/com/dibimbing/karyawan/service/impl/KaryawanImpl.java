package com.dibimbing.karyawan.service.impl;

import com.dibimbing.karyawan.model.Karyawan;
import com.dibimbing.karyawan.repository.KaryawanRepository;
import com.dibimbing.karyawan.service.KaryawanService;
import com.dibimbing.karyawan.utils.TemplateResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class KaryawanImpl implements KaryawanService {

    public static final Logger log = LoggerFactory.getLogger(KaryawanImpl.class);

    // public static final Logger log =  LoggerFactory.getLogger(BarangImpl.class);
    @Autowired
    public KaryawanRepository karyawanRepository;


    @Autowired
    public TemplateResponse templateResponse;

    @Override
    public Map insert(Karyawan karyawan) {
        try {
            if (templateResponse.chekNull(karyawan.getNama())) {
                return templateResponse.templateEror("Nama is Requiered");
            }

            Karyawan karyawanSave = karyawanRepository.save(karyawan);
            return templateResponse.templateSukses(karyawanSave);
        } catch (Exception e) {
            log.info("{}","Eror:" +e);
            return templateResponse.templateEror(e);
        }
    }




    @Override
    public Map update(Karyawan karyawanReq) {
        try {

            if (templateResponse.chekNull(karyawanReq.getId())) {
                return templateResponse.templateEror("Id Karyawan is required");
            }
            Karyawan chekIdKaryawan = karyawanRepository.getbyID(karyawanReq.getId());
            if (templateResponse.chekNull(chekIdKaryawan)) {
                return templateResponse.templateEror("Id Karyawan Not found");
            }

            chekIdKaryawan.setNama(karyawanReq.getNama());
            chekIdKaryawan.setJk(karyawanReq.getJk());
            chekIdKaryawan.setDob(karyawanReq.getDob());
            chekIdKaryawan.setAlamat(karyawanReq.getAlamat());
            chekIdKaryawan.setStatus(karyawanReq.getStatus());
            Karyawan dosave = karyawanRepository.save(chekIdKaryawan);

            return templateResponse.templateSukses(dosave);
        } catch (Exception e) {
            log.info("{}","Error: "+e);
            return templateResponse.templateEror(e);
        }

    }

    @Override
    public Map delete(Long karyawan) {
        try {
            if (templateResponse.chekNull(karyawan)) {
                return templateResponse.templateEror("Id karyawan is required");
            }

            Karyawan chekIdKaryawan = karyawanRepository.getbyID(karyawan);
            if (templateResponse.chekNull(chekIdKaryawan)) {
                return templateResponse.templateEror("Id karyawan Not found");
            }

            //      chekIdBarang.setDeleted_date(new Date());//
            karyawanRepository.save(chekIdKaryawan);

            return templateResponse.templateSukses("sukses deleted");

        } catch (Exception e) {
            return templateResponse.templateEror(e);
        }
    }
    @Override
    public Map getAll(int size, int page) {
        try {
            Pageable show_data = PageRequest.of(page, size);
            Page<Karyawan> list = karyawanRepository.getAllData(show_data);
            return templateResponse.templateSukses(list);
        } catch (Exception e) {
            log.error("ada eror di method getAll:" + e);
            return templateResponse.templateEror(e);
        }
    }
}
