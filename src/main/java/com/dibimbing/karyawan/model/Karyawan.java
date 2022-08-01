package com.dibimbing.karyawan.model;

import java.util.Date;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class Karyawan {
    private Long id;
    private String nama;
    private String jk;
    private Date dob;
    private String alamat;
    private String status;
}
