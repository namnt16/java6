package com.example.api.controller;


import com.example.api.DAO.NhanVienDAO;
import com.example.api.DAO.PhimDAO;
import com.example.api.entity.NhanVien;
import com.example.api.entity.Phim;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

@org.springframework.web.bind.annotation.RestController
@CrossOrigin("*")
public class NhanVienController {
    @Autowired
    NhanVienDAO Dao;
    @Autowired
    PhimDAO daoPhim;
    @GetMapping("/postnhanvien/{tendangnhap}/{matkhau}")
    public NhanVien getNhanVien(@PathVariable("tendangnhap")String tendangnhap, @PathVariable("matkhau")String matkhau){
        NhanVien nhanVien = Dao.findByNhanVien(tendangnhap,matkhau);
        System.out.println(nhanVien);
        if(tendangnhap.equals(nhanVien.getTendangnhap()) && matkhau.equals(nhanVien.getMatkhau())){
            return nhanVien;
        }
        return null;
    }



    @PostMapping("/postnhanvien/{tendangnhap}/{matkhau}/{matkhau1}/{matkhau2}")
    public ResponseEntity<NhanVien> postNhanVienMatKhau(@PathVariable("tendangnhap")String tendangnhap,
                                                        @PathVariable("matkhau")String matkhau,
                                                        @PathVariable("matkhau1")String matkhau1,
                                                        @PathVariable("matkhau2")String matkhau2){
        NhanVien nv = Dao.findByNhanVien(tendangnhap, matkhau);
        if(nv.getTendangnhap().equals(tendangnhap) && nv.getMatkhau().equals(matkhau)){
            if(matkhau1.equals(matkhau2)){
                nv.setMatkhau(matkhau1);
                Dao.save(nv);
                ResponseEntity.ok("Đổi mật khẩu thành công");
            }
        }
        return null;
    }

    @PostMapping("/postnhanvien/{tieude}/{tacgia}/{gioithieu}/{thoiluong}/{photo}/{theloai}")
    public ResponseEntity<Phim> postPhim(
            @PathVariable("tieude")String tieude,
            @PathVariable("tacgia")String tacgia,
            @PathVariable("gioithieu")String gioithieu,
            @PathVariable("thoiluong")String thoiluong,
            @PathVariable("photo") MultipartFile photo,
            @PathVariable("theloai")String theloai){

        Phim phim = new Phim();
        phim.setTieude(tieude);
        phim.setTacgia(tacgia);
        phim.setGioithieu(gioithieu);
        phim.setThoiluong(thoiluong);
        phim.setTheloai(theloai);
        daoPhim.save(phim);
        Path path = Paths.get("./resources/static/uploads/");
        try {
            InputStream inputStream = photo.getInputStream();
            Files.copy(inputStream,path.resolve(photo.getOriginalFilename()),
                    StandardCopyOption.REPLACE_EXISTING);
            phim.setHinhanh(photo.getOriginalFilename().toLowerCase());
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping("/postnhanvien/{tieude}/{tacgia}")
    public ResponseEntity<Phim> postXoaPhim(@PathVariable("tieude")String tieude,
                                            @PathVariable("tacgia")String tacgia){
        Optional<Phim> phim = daoPhim.findByPhim(tieude,tacgia);
        Phim phimget = phim.get();
        daoPhim.delete(phimget);
        ResponseEntity.ok("Đã xóa thành công");
        return null;
    }

}

