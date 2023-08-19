package com.example.api.DAO;

import com.example.api.entity.SuatChieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

public interface SuatChieuDAO extends JpaRepository<SuatChieu,Integer> {
    @Query("SELECT p FROM SuatChieu p WHERE p.phimid = ?1 AND p.thoigianchieu = ?2")
    SuatChieu getSuatChieuAndMuave(int id, Date time);
}
