package com.faisal.spp.service;

import com.faisal.spp.entity.Siswa;
import com.faisal.spp.exception.IdNotFoundException;
import com.faisal.spp.repository.SiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class SiswaService {
    @Autowired
    SiswaRepository siswaRepository;

    public List<Siswa> findAllSiswa(){
        return siswaRepository.findAll();
    }

    public List<Siswa> findByName(String name){
        return siswaRepository.findByNameIs(name);
    }

    public Siswa findById(String id){
        return siswaRepository.findById(id).orElseThrow(() -> new IdNotFoundException("id " + id + " not found"));
    }

    public Siswa AddSiswa(Siswa siswa){
        if(siswaRepository.findByName(siswa.getName()) != null){
            throw new IdNotFoundException("username sudah di gunakan");
        }
        return siswaRepository.save(siswa);
    }

    public void deleteSiswa(String id){
        siswaRepository.deleteById(id);
    }

    public void pembayaran(String id, BigInteger amount){
        Siswa siswa = siswaRepository.findById(id).orElseThrow(() -> new IdNotFoundException("id " + id + " tidak di temukan"));
        siswa.setAmount(siswa.getAmount().add(amount));
        siswaRepository.save(siswa);
    }

}
