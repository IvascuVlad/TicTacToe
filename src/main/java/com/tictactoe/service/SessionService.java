package com.tictactoe.service;

import com.tictactoe.domain.Move;
import com.tictactoe.domain.Session;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class SessionService {
    private final Map<Integer, Session> sessions;

    public SessionService() {
        this.sessions = new HashMap<>();
    }

    public Optional<Session> getSession(Integer sessionId) {
        return Optional.ofNullable(sessions.get(sessionId));
    }

    public Optional<Integer> createSession(String userName) {
        if (userName.isEmpty()) {
            return Optional.empty();
        }

        Integer currentId = sessions.keySet().size() + 1;
        sessions.put(currentId, new Session(currentId));

        sessions.get(currentId).addUser(userName);

        return Optional.of(currentId);
    }

    public Boolean joinSession(String userName, Integer sessionId) {
        if (!sessions.containsKey(sessionId)) {
            return false;
        }
        sessions.get(sessionId).addUser(userName);

        return true;
    }

    public Boolean makeMove(Move move, Integer sessionId) {
        if (!sessions.containsKey(sessionId)) {
            return false;
        }
        return sessions.get(sessionId).makeMove(move);
    }
}
