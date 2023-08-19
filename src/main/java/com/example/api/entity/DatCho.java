package com.example.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Datcho")
public class DatCho implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "suatchieu_id", referencedColumnName = "id")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    SuatChieu suatchieuId;
    //    int nhanvien_thanhtoan_id;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "nhanvien_nhandat_id", referencedColumnName = "id")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    NhanVien nhanVienDat;


    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "nhanvien_thanhtoan_id", referencedColumnName = "id")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    NhanVien nhanVienThanhToan;
    boolean thanhtoan;
    boolean tangthai;
    String lienhe;
    Date thoigiantao;

}
