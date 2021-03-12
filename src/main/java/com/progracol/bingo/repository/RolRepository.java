package com.progracol.bingo.repository;

import java.util.Optional;

import com.progracol.bingo.Models.entity.RolEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unused")
@Repository
public interface RolRepository extends JpaRepository<RolEntity, Long> {

    RolEntity findRolById(@Param("id") Long id);

    Optional<RolEntity> findByName(String name);

}
