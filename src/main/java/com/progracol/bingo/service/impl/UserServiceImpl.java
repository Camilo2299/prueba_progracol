package com.progracol.bingo.service.impl;

import java.util.ArrayList;

import com.progracol.bingo.Models.entity.UserEntity;
import com.progracol.bingo.repository.UserRepository;
import com.progracol.bingo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class UserServiceImpl implements UserService {

    @Autowired

    UserRepository userRepository;

    @Override
    public UserEntity findByUsername(String username) {

        return userRepository.findByUsername(username);
    }

    @Override
    public ArrayList<UserEntity> obtenerUsuarios() {
        return (ArrayList<UserEntity>) userRepository.findAll();
    }

}
