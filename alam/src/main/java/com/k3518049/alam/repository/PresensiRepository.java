package com.k3518049.alam.repository;

import com.k3518049.alam.entity.Presensi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PresensiRepository extends JpaRepository<Presensi, Integer> {
}
