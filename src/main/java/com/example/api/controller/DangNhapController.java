package com.example.api.controller;

import com.example.api.DAO.NhanVienDAO;
import com.example.api.entity.NhanVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
public class DangNhapController {
    @Autowired
    NhanVienDAO nhanVienDAO;
    @GetMapping("/getNhanVien/{tendangnhap}/{pass}")
    public NhanVien getNhanVienByIdAndPass(@PathVariable("tendangnhap") String tendangnhap,@PathVariable("pass") String pass){
        NhanVien nhanVien = nhanVienDAO.findNhanVienByTendangnhapAndMatkhau(tendangnhap,pass);
        return nhanVien;
    }

    @GetMapping("/getNhanVien")
    public List<NhanVien> getNhanVien(){
        List<NhanVien> nhanVien = nhanVienDAO.findAll();
        return nhanVien;
    }

    @PostMapping("/postnhanvien")
    public ResponseEntity<NhanVien> postNhanVien(@RequestBody NhanVien nhanVien){
        NhanVien nv = nhanVienDAO.save(nhanVien);
        return ResponseEntity.ok(nv);
    }

    @GetMapping("/getNhanVienByTen/{tendangnhap}")
    public NhanVien getNhanVienByTen(@PathVariable("tendangnhap") String tdn){
        NhanVien list = nhanVienDAO.findByNhanVienByTenDangNhap(tdn);
        return list;
    }
}
