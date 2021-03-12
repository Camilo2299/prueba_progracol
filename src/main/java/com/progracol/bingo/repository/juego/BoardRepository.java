package com.progracol.bingo.repository.juego;

import com.progracol.bingo.Models.entity.juego.BoardEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unused")
@Repository
public interface BoardRepository extends JpaRepository<BoardRepository, Long> {

    @Query("SELECT bpd FROM BoardEntity bpd")
    Page<BoardEntity> findAllBingoParamBoards(Pageable pageable);

    @Query("SELECT bpd FROM BoardEntity bpd where bpd.boardNumbers = :array ")
    Page<BoardEntity> findWinnersInBingoParamBoards(Pageable pageable, @Param("array") Integer[] array);

}
