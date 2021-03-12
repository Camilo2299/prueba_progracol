package com.progracol.bingo.controller;

import com.progracol.bingo.Models.entity.juego.BoardEntity;
import com.progracol.bingo.service.BoardService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping
    public Page<BoardEntity> getAllBingoParamBoardsPageable(@RequestParam(name = "page") Integer page,
            @RequestParam(name = "size") Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return boardService.findAllBoardEntity(pageable);
    }
}