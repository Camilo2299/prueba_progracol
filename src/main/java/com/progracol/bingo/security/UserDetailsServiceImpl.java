package com.progracol.bingo.security;

import com.progracol.bingo.Models.entity.RolEntity;
import com.progracol.bingo.Models.entity.UserEntity;
import com.progracol.bingo.repository.RolRepository;
import com.progracol.bingo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RolRepository rolRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username);
        // .orElseThrow(() -> new UsernameNotFoundException("Usuario no encotrado: " +
        // username));
        RolEntity r = rolRepository.findRolById(user.getRolId());
        user.setRol(r);
        return UserPrincipal.build(user);
    }

}