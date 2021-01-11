package com.k3518049.alam.controller;

import com.k3518049.alam.dto.PresensiDto;
import com.k3518049.alam.dto.UserDto;
import com.k3518049.alam.entity.Presensi;
import com.k3518049.alam.entity.User;
import com.k3518049.alam.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class UserDataController {
    @Autowired
    private DataService dataService;

    @PostMapping("/register")
    public ResponseEntity<UserDto> registerNewUser(@RequestBody UserDto userDto){
        UserDto result = dataService.saveNewUser(userDto);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> loginUser(@RequestBody UserDto userDto){
        UserDto result = dataService.getSelectedUser(userDto.getUsername(), userDto.getPassword());
        return ResponseEntity.ok(result);
    }

    @GetMapping("/add/{idUser}")
    public ResponseEntity<List<PresensiDto>> saveNewPresensi(@PathVariable("idUser") Integer idUser){
        List<PresensiDto> presensiDtoList = dataService.putNewPresensi(idUser);
        return ResponseEntity.ok(presensiDtoList);
    }

    @GetMapping("/{idUser}")
    public ResponseEntity<List<PresensiDto>> getUserPresensi(@PathVariable("idUser") Integer idUser){
        List<PresensiDto> presensiDtoList = dataService.findPresensiUser(idUser);
        return ResponseEntity.ok(presensiDtoList);
    }

    @GetMapping("/showall")
    public ResponseEntity<List<PresensiDto>> getAllPresensiUser(){
        List<PresensiDto> presensiDtos = dataService.findAll();
        return ResponseEntity.ok(presensiDtos);
    }
}
