package com.faisal.spp.repository;

import com.faisal.spp.entity.Siswa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SiswaRepository extends JpaRepository<Siswa, String> {
    Siswa findByName(String name);

    List<Siswa> findByNameIs(String name);

    @Override
    void deleteById(String s);
}
