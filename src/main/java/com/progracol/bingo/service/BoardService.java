package com.progracol.bingo.service;

import com.progracol.bingo.Models.entity.juego.BoardEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardService {
    Page<BoardEntity> evaluateArrayOnBingoBoard(String[] number, Pageable pageable);

    Page<BoardEntity> findAllBoardEntity(Pageable pageable);

}
