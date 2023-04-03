package com.faisal.spp.controller;

import com.faisal.spp.entity.Siswa;
import com.faisal.spp.service.SiswaService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.faisal.spp.dto.Pembayaran;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin()
public class SiswaController {
    @Autowired
    SiswaService siswaService;

    @GetMapping("/findAll")
    public ResponseEntity<List<Siswa>> findAllSiswa(){
        return new ResponseEntity<List<Siswa>>(siswaService.findAllSiswa(), HttpStatus.OK);
    }

    @GetMapping("/result")
    public ResponseEntity<List<Siswa>> findByName(@RequestParam String name){
        return new ResponseEntity<List<Siswa>>(siswaService.findByName(name), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Siswa> findById(@PathVariable String id){
        return new ResponseEntity<Siswa>(siswaService.findById(id),HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Siswa> addSiswa(@RequestBody Siswa siswa){
        return new ResponseEntity<Siswa>(siswaService.AddSiswa(siswa), HttpStatus.OK);
    }

    @PutMapping("/pembayaran")
    public void pembayaran(@RequestBody Pembayaran pembayaran){
        siswaService.pembayaran(pembayaran.getId(), pembayaran.getAmount());
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable String id){
        siswaService.deleteSiswa(id);
    }

}
