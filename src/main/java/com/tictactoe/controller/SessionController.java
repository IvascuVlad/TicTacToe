package com.tictactoe.controller;

import com.tictactoe.domain.Move;
import com.tictactoe.domain.Session;
import com.tictactoe.service.SessionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/session")
public class SessionController {

    private final SessionService sessionService;

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @GetMapping("/{sessionId}")
    public ResponseEntity<Session> retrieveSession(@PathVariable Integer sessionId) {
        Optional<Session> session = sessionService.getSession(sessionId);
        return session.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<Integer> createSession(@RequestParam String userName) {
        Optional<Integer> sessionId = sessionService.createSession(userName);
        return sessionId.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PostMapping("/join/{sessionId}")
    public ResponseEntity<String> joinSession(@RequestParam String userName, @PathVariable Integer sessionId) {
        Boolean joiningResult = sessionService.joinSession(userName, sessionId);
        return joiningResult ? ResponseEntity.ok("Added successfully") : ResponseEntity.badRequest().build();
    }

    @PostMapping("/move/{sessionId}")
    public ResponseEntity<String> makeMove(@RequestBody Move move, @PathVariable Integer sessionId) {
        Boolean movingResult = sessionService.makeMove(move, sessionId);
        return movingResult ? ResponseEntity.ok("Successful move") : ResponseEntity.badRequest().build();
    }
}
