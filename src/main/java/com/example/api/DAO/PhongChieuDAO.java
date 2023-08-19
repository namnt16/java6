package com.example.api.DAO;

import com.example.api.entity.PhongChieu;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhongChieuDAO extends JpaRepository<PhongChieu, Integer> {
}
