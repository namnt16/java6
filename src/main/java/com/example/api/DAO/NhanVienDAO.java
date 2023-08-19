package com.example.api.DAO;

import com.example.api.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface NhanVienDAO extends JpaRepository<NhanVien,Integer> {
    @Query("SELECT o FROM NhanVien o WHERE o.tendangnhap = ?1 and o.matkhau = ?2")
    NhanVien findNhanVienByTendangnhapAndMatkhau(String tendangnhap,String pass);

    @Query("select o from  NhanVien o where  o.tendangnhap = :tendangnhap and  o.matkhau = :matkhau")
    NhanVien findByNhanVien(String tendangnhap, String matkhau);
    @Query("select o from  NhanVien o where o.tendangnhap = ?1")
    NhanVien findByNhanVienByTenDangNhap(String tendangnhap);
}
