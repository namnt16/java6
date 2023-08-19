package com.example.api.controller;


import com.example.api.DAO.*;
import com.example.api.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@CrossOrigin("*")
public class RestController {
    @Autowired
    PhimDAO phimDAO;

    @Autowired
    SuatChieuDAO suatChieuDAO;

    @Autowired
    GheDAO gheDAO;
    @Autowired
    PhongChieuDAO phongChieuDAO;
    @Autowired
    DatChoDAO choDAO;

    @Autowired
    GheDatChoDAO gheDatChoDAO;

    @GetMapping("/getPhim")
    public List<Phim> index(){
        List<Phim> newl = phimDAO.findAll();
        return newl;
    }
    @GetMapping("/getPhim/{id}")
    public Phim getPhimById(@PathVariable("id") int id){
        Phim p = phimDAO.findById(id).get();
        return p;
    }

    @GetMapping("/chonsuat")
    public List<SuatChieu> getSuatChieu(){
        List<SuatChieu> newl = suatChieuDAO.findAll();
        return newl;
    }

    @GetMapping("/chonsuat/{id}/{time}")
    public SuatChieu getById(@PathVariable("id") int id,@PathVariable("time") String time){
        Phim get = phimDAO.findById(id).get();
        List<SuatChieu> getsc = suatChieuDAO.findAll();
        SuatChieu sc = new SuatChieu();
        getsc.forEach(item ->{
            if (id == get.getId() && time.equals(item.getThoigianchieu().toString().substring(11,16))){
                sc.setId(item.getId());
                sc.setPhimid(get);
                sc.setThoigianchieu(item.getThoigianchieu());

            }
        });
        return sc;
    }

    @GetMapping("/ghe")
    public List<Ghe> getAllGheA(){
        List<Ghe> newl = gheDAO.findAll();
        List<Ghe> listA = new ArrayList<>();
        newl.forEach(item ->{
            if (item.getHang().equals("A")){
               listA.add(item);
            }
        });
        return listA;
    }

    @GetMapping("/gheB")
    public List<Ghe> getAllGheB(){
        List<Ghe> newl = gheDAO.findAll();
        List<Ghe> listB = new ArrayList<>();
        newl.forEach(item ->{
            if (item.getHang().equals("B")){
                listB.add(item);
            }
        });
        return listB;
    }
    @GetMapping("/gheC")
    public List<Ghe> getAllGheC(){
        List<Ghe> newl = gheDAO.findAll();
        List<Ghe> listC = new ArrayList<>();
        newl.forEach(item ->{
            if (item.getHang().equals("C")){
                listC.add(item);
            }
        });
        return listC;
    }

    @PostMapping("/datve")
    public ResponseEntity<DatCho> datVe(@RequestBody DatCho datCho){
        DatCho saveVe = choDAO.save(datCho);
        return ResponseEntity.ok(saveVe);
    }

    @GetMapping("/datves")
    public List<DatCho> datVes(){
        List<DatCho> list = choDAO.getDatChoByLats();
        return list;
    }

    @GetMapping("/datvess")
    public List<GheDatCho> datVess(){
        List<GheDatCho> list = gheDatChoDAO.findAll();
        return list;
    }

    @PostMapping("/datvevaghe")
    public ResponseEntity<GheDatCho> datVeVaGhe(@RequestBody GheDatCho gheDatCho){
        GheDatCho saveVe = gheDatChoDAO.save(gheDatCho);
        return ResponseEntity.ok(saveVe);
    }

    @GetMapping("/getGheDaDat")
    public List<GheDatCho> getGheDaDat(){
        List<GheDatCho> list = gheDatChoDAO.findAll();
        return list;
    }


}
