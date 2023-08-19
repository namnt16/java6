package com.example.api.DAO;

import com.example.api.entity.DatCho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DatChoDAO extends JpaRepository<DatCho,Integer> {
    @Query("SELECT d FROM DatCho d WHERE d.id = IDENT_CURRENT('DatCho')")
    List<DatCho> getDatChoByLats();
}
