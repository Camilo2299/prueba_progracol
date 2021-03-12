package com.progracol.bingo.Models.entity.juego;

import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "bingo_param_board")
public class BoardEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "bingo_param_board_board_id_seq", sequenceName = "bingo_param_board_board_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "bingo_param_board_board_id_seq")
    @Column(name = "board_id", nullable = false)
    private Long id;

    @NotNull
    @Type(type = "int-array")
    @Column(name = "board_numbers", columnDefinition = "_int4", nullable = false)
    private Integer[] boardNumbers;

    @NotNull
    @Type(type = "int-array")
    @Column(name = "sensor_values", columnDefinition = "_int4", nullable = false)
    private Integer[] sensorValues;

    @Size(max = 1)
    @NotNull
    @Column(name = "status", length = 1, nullable = false)
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer[] getBoardNumbers() {
        return boardNumbers;
    }

    public void setBoardNumbers(Integer[] boardNumbers) {
        this.boardNumbers = boardNumbers;
    }

    public Integer[] getSensorValues() {
        return sensorValues;
    }

    public void setSensorValues(Integer[] sensorValues) {
        this.sensorValues = sensorValues;
    }
}
