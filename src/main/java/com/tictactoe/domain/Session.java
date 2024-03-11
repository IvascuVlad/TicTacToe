package com.tictactoe.domain;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Session implements Serializable {

    private final Integer sessionId;

    private final Board board;

    private final List<String> userList;

    public Session(Integer sessionId) {
        this.sessionId = sessionId;
        this.board = new Board();
        this.userList = new LinkedList<>();
    }

    public Integer getSessionId() {
        return sessionId;
    }

    public Board getBoard() {
        return board;
    }

    public List<String> getUserList() {
        return userList;
    }

    public boolean makeMove(Move move) {
        return this.board.makeMove(move);
    }

    public void addUser(String userName) {
        this.userList.add(userName);
    }

    @Override
    public String toString() {
        return "Session{" +
                "sessionId=" + sessionId +
                ", board=" + board +
                ", userList=" + userList +
                '}';
    }
}
