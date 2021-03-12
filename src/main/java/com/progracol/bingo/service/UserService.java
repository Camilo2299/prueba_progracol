package com.progracol.bingo.service;

import java.util.ArrayList;

import com.progracol.bingo.Models.entity.UserEntity;

public interface UserService {

    public UserEntity findByUsername(String username);

    public ArrayList<UserEntity> obtenerUsuarios();

}