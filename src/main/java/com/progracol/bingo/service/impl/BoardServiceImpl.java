package com.progracol.bingo.service.impl;

import com.progracol.bingo.Models.entity.juego.BoardEntity;
import com.progracol.bingo.repository.juego.BoardRepository;
import com.progracol.bingo.service.BoardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired

    private BoardRepository boardRepository;

    public BoardServiceImpl(BoardRepository boardRepository) {

        this.boardRepository = boardRepository;

    }

    @Override
    public Page<BoardEntity> evaluateArrayOnBingoBoard(String[] number, Pageable pageable) {

        Integer[] arrayNumber = new Integer[number.length];

        for (int i = 0; i < arrayNumber.length; i++) {
            if (number[i] != null) {
                arrayNumber[i] = Integer.parseInt(number[i]);
            } else {
                arrayNumber[i] = null;
            }
        }
        Page<BoardEntity> bingoParamBoards = boardRepository.findWinnersInBingoParamBoards(pageable, arrayNumber);

        return bingoParamBoards;
    }

    @Override
    public Page<BoardEntity> findAllBoardEntity(Pageable pageable) {
        Page<BoardEntity> bingoParamBoards = boardRepository.findAllBingoParamBoards(pageable);
        return bingoParamBoards;
    }

}
