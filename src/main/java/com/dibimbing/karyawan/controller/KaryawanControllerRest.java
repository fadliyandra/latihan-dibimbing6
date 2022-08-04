package com.dibimbing.karyawan.controller;


import com.dibimbing.karyawan.model.Karyawan;
import com.dibimbing.karyawan.service.KaryawanService;
import com.dibimbing.karyawan.utils.TemplateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/v1/karyawan")
public class KaryawanControllerRest {
    @Autowired
    public KaryawanService karyawanService;

    @Autowired
    public TemplateResponse templateResponse;

    @PostMapping("/save")
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map> save(@Valid @RequestBody Karyawan kryModel) {
        Map kry = karyawanService.insert(kryModel);
        return new ResponseEntity<Map>(kry, HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Map>update(@RequestBody Karyawan kryModel) {
        Map kry = karyawanService.update(kryModel);
        return new ResponseEntity<Map>(kry, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map>delete(@PathVariable(value = "id") Long id) {
        Map kry = karyawanService.delete(id);
        return new ResponseEntity<Map>(kry, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<Map>listByNama(
            @RequestParam() Integer page,
            @RequestParam() Integer size) {
        Map list = karyawanService.getAll(size, page);
        return new ResponseEntity<Map>(list, new HttpHeaders(), HttpStatus.OK);
    }

}
