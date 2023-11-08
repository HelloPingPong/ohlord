package com.example.rpggame.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Random;

public class GameAction {
    private String actionType;
    private int option;

    @JsonCreator
    public GameAction(
            @JsonProperty("actionType") String actionType,
            @JsonProperty("option") int option) {
        this.actionType = actionType;
        this.option = option;
    }

    // Add a default constructor for deserialization
    public GameAction() {
    }

    public String getActionType() {
        return actionType;
    }

    public int getOption() {
        return option;
    }

    public static GameAction generateRandomAction() {
        Random random = new Random();
        String actionType = "attack";
        int option = random.nextInt(5) + 1;
        return new GameAction(actionType, option);
    }
}




/*package com.example.rpggame.model;

import java.util.Random;

public class GameAction {
    private String actionType;
    private int option;

    public GameAction(String actionType, int option) {
        this.actionType = actionType;
        this.option = option;
    }

    public String getActionType() {
        return actionType;
    }

    public int getOption() {
        return option;
    }

    public static GameAction generateRandomAction() {
        Random random = new Random();
        String actionType = "attack";
        int option = random.nextInt(5) + 1;
        return new GameAction(actionType, option);
    }
}*/


/*package com.example.rpggame.model;

public class GameAction {
    private String actionType;
    private int option;

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public int getOption() {
        return option;
    }

    public void setOption(int option) {
        this.option = option;
    }
}*/