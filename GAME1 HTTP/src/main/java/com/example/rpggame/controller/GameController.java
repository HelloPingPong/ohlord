package com.example.rpggame.controller;

import com.example.rpggame.model.Character;
import com.example.rpggame.model.Game;
import com.example.rpggame.model.GameAction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/game")
public class GameController {

    private final Game game;

    public GameController() {
        this.game = new Game();
    }

    @PostMapping("/start")
    public ResponseEntity<Character[]> startGame() {
        Character[] characters = game.start();
        return ResponseEntity.ok(characters);
    }

    @PostMapping("/action")
    public ResponseEntity<Character[]> performAction(@RequestBody GameAction gameAction) {
        game.processTurn(gameAction);
        Character[] characters = new Character[]{game.getPlayer(), game.getEnemy()};
        if (game.isGameOver()) {
            return ResponseEntity.status(418).body(characters); // Custom status code 418 to indicate game over
        }
        return ResponseEntity.ok(characters);
    }
}



