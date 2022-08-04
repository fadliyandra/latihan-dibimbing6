package com.dibimbing.karyawan.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
//import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@Data
@Entity
@Table(name = "karyawan")
//@Where(clause = "delete_date is null")
public class Karyawan implements Serializable {


    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nama", nullable = false, length = 45)
    private  String nama;

    @Column(name= "Jk", nullable = true,length = 11)
    private int jk;

    @Column(name = "Dob", nullable = true,length = 20)
    private Date dob;

    @Column(name = "Alamat", nullable = true,length = 45)
    private String alamat;

    @Column(name = "Status", nullable = true,length = 11)
    private String status;




//    private Long id;
//    private String nama;
//    private String jk;
//    private Date dob;
//    private String alamat;
//    private String status;
}
