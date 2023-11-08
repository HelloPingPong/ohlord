RPG Game
A simple RPG game built with Java, JavaScript, Spring Boot, and Vue.js. 
The game features player and enemy characters, different attack, buff, and debuff options
and a WebSocket server for seamless communication between the backend and frontend.
I built this game to learn more about Spring Boot and WebSocket communication and to practice my Java and JavaScript skills.
I've intentionally kept the game simple and focused on the core functionality 
in order to create different versions of it in the future with different game mechanics and features.
You're welcome to use this project as a starting point for your own projects 
as I have intentionally kept the code simple,, easy to understand, and left both characters and attacks nameless and generic.


----------------------------------------------------------------------------------------------------------------------------

FILE LAYOUT
Backend (Java)
1. src/main/java/com/example/rpggame/RpgGameApplication.java
    The main class responsible for running the Spring Boot application.

2. src/main/java/com/example/rpggame/config/WebSocketConfig.java
    WebSocket configuration class that sets up WebSocket support.

3. src/main/java/com/example/rpggame/controller/GameWebSocketHandler.java
    WebSocket handler class that processes incoming messages and communicates with the frontend.

4. src/main/java/com/example/rpggame/model/Character.java
    Character class that represents the player and enemy characters in the game.

5. src/main/java/com/example/rpggame/model/Game.java
    Game class that handles game logic, actions, and turn processing.

6. src/main/java/com/example/rpggame/model/GameAction.java
    GameAction class that represents the actions chosen by the player.

----------------------------------------------------------------------------------------------------------------------------

Frontend (HTML, CSS, JavaScript)
1. src/main/resources/static/index.html
    Main HTML file that contains the game's structure and layout.

2. src/main/resources/static/styles.css
    CSS file that contains the styling for the game.

3. src/main/resources/static/script.js
    JavaScript file that handles the frontend game logic, Vue.js instance, and WebSocket communication.

----------------------------------------------------------------------------------------------------------------------------

Functionality
Player can choose between different actions: attack, heal, apply buff, and apply debuff to the enemy.
Player can select different attack, buff, and debuff types.
The game provides a preview of attack options without losing a turn.
Enemy AI selects random actions and types each turn.
The game continues until either the player or enemy's health reaches zero.
The game features a starting menu and restart functionality.

----------------------------------------------------------------------------------------------------------------------------

Dependencies
Java 11
Spring Boot 2.5.5
spring-boot-starter-websocket
Vue.js 2.6.14
Maven

----------------------------------------------------------------------------------------------------------------------------

Running the Game
1. Install Java 11 and Maven, if not already installed.
2. Navigate to the project directory in a terminal.
3. Run mvn spring-boot:run to start the Spring Boot application.
4. Open a web browser and navigate to http://localhost:8080/ to access the game.
5. Play the game and enjoy!

----------------------------------------------------------------------------------------------------------------------------

I also owe a huge thank you to several people in particular. This is the first large project I've completed on my own
and I couldn't have done it without the help of the following people:

1. My instructor Brian, who has been a huge help and has provided me with valuable training as a software developer. Let him cook.

2. My good friend and fellow developer, Luke, who has been a great mentor and has helped me with many of the problems I've encountered
while undertaking the 14-week Java bootcamp at Tech Elevator. he personally recommended me to take this course in the first place and 
I wouldnt have been here without him.

3. My girlfriend Kate, who has been a huge support and incredible encouragement. Our time together is always a joy.

4. My family, who have always been there for me and have always supported me. I love you all.

5. My friends Colby and Alec. I've always struggled with timeliness and organization, but you guys have helped me to improve in those areas
and I'm so grateful for that. I would have been kicked out from the program for being late if it weren't for your advice, loyalty, and help.

6. My campus director, Kevin, who has been both a frequent encourager and willing disciplinarian. I'm grateful for and often in need of both.

7. My friends at Tech Elevator. I've made so many friends at Tech Elevator and I'm so grateful for that. I've learned so much from you guys
and I'm so glad I got to spend the last 14 weeks with you. I'm looking forward to seeing what the future holds for us all and our friendships.


 -------Be the person Will Gainsborough thinks you are: Azure19--------


NEW VERSION README:::::
# Simple RPG Game

This is a simple turn-based RPG game built using Java with Spring Boot for the backend and JavaScript with Vue.js for the frontend. The game uses HTTP for communication between the frontend and backend.

## Features (some may not be fully implemented. buffs and debuffs for example are in the code, but not fully enabled I think)

- Turn-based combat system
- Multiple attack types, buffs, and debuffs
- Basic character stats and attributes
- Game state management and game over detection
- Responsive frontend design

## File Layout
src
└── main
├── java
│ └── com.example.rpggame
│ ├── controller
│ │ └── GameController.java
│ ├── model
│ │ ├── Character.java
│ │ ├── Game.java
│ │ └── GameAction.java
│ └── RpgGameApplication.java
└── resources
├── static
│ ├── css
│ │ └── styles.css
│ ├── js
│ │ └── script.js
│ └── index.html
└── application.properties

## Dependencies

- Java 8 or later
- Maven
- Spring Boot 2.6.2
- Spring Web
- Jackson (included in Spring Boot)

## Frontend

The frontend is built using Vue.js and communicates with the backend using HTTP fetch requests. The user interface is responsive and allows players to start a game, perform actions, and restart the game when it's over.

## How to Run

1. Install Java and Maven on your system.
2. Clone the repository or download the project files.
3. Open a terminal (or Command Prompt on Windows) and navigate to the project directory.
4. Build the project using Maven by running the command: `mvn clean install`
5. Start the Spring Boot application by running the command: `mvn spring-boot:run`
6. Open a web browser and navigate to `http://localhost:8080/` to access the game.

## Future Improvements To Be Made

1- Add more character attributes and abilities, that can be customized by the player.
2- Implement a more advanced combat system with additional gameplay mechanics.
3- Add a system for leveling up characters and improving their attributes.
4- Introduce a variety of enemies with different abilities and AI strategies.
5- Implement a story or quest system to provide a more immersive experience.
6- implement an item/inventory system to obtain, equip, or consume different objects that can affect character/enemy attributes and abilities during combat.
7- introduce a drastically improved responsive and reactive visual UI. It should include a visual representation of items, player/enemy stats+abilities, and a procedurally generated pixel/sprite based map that displays the game world and can be moved around within by the player and enemies.
