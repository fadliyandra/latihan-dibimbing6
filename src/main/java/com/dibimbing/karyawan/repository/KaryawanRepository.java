package com.dibimbing.karyawan.repository;

import com.dibimbing.karyawan.model.Karyawan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface KaryawanRepository extends PagingAndSortingRepository<Karyawan, Long> {

    //jpq
    @Query("selec c from Karyawan c")
    public Page<Karyawan> getAllData(Pageable pageable);

    //jpq
    @Query("select c from Karyawan c WHERE c.id = :idkaryawan")
    public Karyawan getbyID(@Param("idkaryawan") Long idbebas);
    //jpql
    public Karyawan findOneById(Long id);

    //native query
    @Query(value = "select c from karyawan c WHERE c.id = :idkaryawan", nativeQuery = true)
    public Object getbyIDNNativeQuery(@Param("idkaryawan") Long idbebas);
}
