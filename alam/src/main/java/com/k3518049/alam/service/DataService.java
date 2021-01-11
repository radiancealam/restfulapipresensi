package com.k3518049.alam.service;

import com.k3518049.alam.dto.PresensiDto;
import com.k3518049.alam.dto.UserDto;
import com.k3518049.alam.entity.Presensi;
import com.k3518049.alam.entity.User;
import com.k3518049.alam.repository.PresensiRepository;
import com.k3518049.alam.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DataService {
    @Autowired
    private PresensiRepository presensiRepository;
    @Autowired
    private UserRepository userRepository;

    public UserDto saveNewUser(UserDto userDto){
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        User result = userRepository.save(user);
        userDto = new UserDto();
        userDto.setId(result.getId());
        userDto.setUsername(result.getUsername());
        userDto.setPassword(result.getPassword());
        return userDto;
    }

    public UserDto getSelectedUser(String username, String password){
        Optional<User> userOpt = userRepository.findSelectedUser(username, password);
        UserDto userDto = new UserDto();
        if (userOpt.isPresent()){
            User user = userOpt.get();
            userDto.setId(user.getId());
            userDto.setUsername(user.getUsername());
            userDto.setPassword(user.getPassword());
        }
        return userDto;
    }

    public List<PresensiDto> putNewPresensi(Integer idUser){
        Optional<User> userOpt = userRepository.findById(idUser);
        if (userOpt.isPresent()){
            User user = userOpt.get();
            Presensi presensi = new Presensi();
            Date date = new Date();
            presensi.setTglMasuk(date);
            presensi.setIdUser(user);
            presensiRepository.save(presensi);
        }
        return findPresensiUser(idUser);
    }

    public List<PresensiDto> findPresensiUser(Integer idUser){
        List<PresensiDto> presensiDtos = new ArrayList<>();
        Optional<User> userOpt = userRepository.findById(idUser);
        if (userOpt.isPresent()){
            User user = userOpt.get();
            List<Presensi> presensis = user.getPresensiList();
            for (int i = 0; i < presensis.size(); i++){
                PresensiDto presensiDto = new PresensiDto(presensis.get(i).getId(), presensis.get(i).getTglMasuk().toString(), presensis.get(i).getIdUser().getId());
                presensiDtos.add(presensiDto);
            }
        }
        return presensiDtos;
    }

    public List<PresensiDto> findAll(){
        List<PresensiDto> presensiDtoList = new ArrayList<>();
        List<Presensi> presensiList= presensiRepository.findAll();
        for (int i = 0; i < presensiList.size(); i++){
            PresensiDto presensiDto = new PresensiDto(presensiList.get(i).getId(), presensiList.get(i).getTglMasuk().toString(), presensiList.get(i).getIdUser().getId());
            presensiDtoList.add(presensiDto);
        }
        return presensiDtoList;
    }
}
