package com.example.api.DAO;

import com.example.api.entity.GheDatCho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GheDatChoDAO extends JpaRepository<GheDatCho,Integer> {
}
