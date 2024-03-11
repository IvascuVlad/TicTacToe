package com.tictactoe.domain;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class Board implements Serializable {
    private final String[][] plane = {{"", "", ""}, {"", "", ""}, {"", "", ""}};

    public Board() {
    }

    public String[][] getPlane() {
        return plane;
    }

    public boolean makeMove(Move move) {
        if (Objects.equals(this.plane[move.x()][move.y()], "")) {
            this.plane[move.x()][move.y()] = move.symbol();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Board{" + "plane=" + Arrays.toString(plane[0]) + Arrays.toString(plane[1]) + Arrays.toString(plane[2]) + '}';
    }
}
