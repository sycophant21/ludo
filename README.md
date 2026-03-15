# ludo

> Four tokens. One board. Infinite frustration.

A full **Ludo board game** implementation built as a Spring Boot application. Complete game logic: dice rolling, token movement, safe squares, captures, and win detection.

## What it does

- Supports the classic Ludo game with up to 4 players
- Manages token positions, movement rules, and player turns
- Handles dice rolls, token selection, captures (sending opponent tokens home), and victory conditions
- Exposes game state through a Spring Boot application context

## How it works

`GameManager` orchestrates the game loop: it uses `Dice` to generate rolls, delegates token selection to `ChooseToken`, and applies movement via `PositionSetter` and `PositionCalculatorHelper`. `Token` and `Tokens` represent individual pieces and collections. `Relationship` and `RelationshipManager` model the board graph (which squares connect to which). `Initializer` sets up the board at game start. `PrintAll` renders the board state to the console.

## Tech stack

- **Java**
- **Spring Boot** (application context / dependency injection)

## Getting started

### Prerequisites

- Java 11+
- Maven 3.6+

### Run

```bash
mvn spring-boot:run
```

Or import into IntelliJ IDEA and run `LudoApplication.java` directly.

### Build

```bash
mvn clean package
java -jar target/ludo-*.jar
```

## Project structure

```
src/
├── ChooseToken.java               # token selection logic
├── Dice.java                      # dice roll generator
├── GameManager.java               # main game loop orchestrator
├── Initializer.java               # board + player setup
├── Main.java                      # entry point
├── PositionCalculatorHelper.java  # board position arithmetic
├── PositionSetter.java            # applies moves to token state
├── PrintAll.java                  # console board renderer
├── Relationship.java              # square-to-square graph node
├── RelationshipManager.java       # board graph manager
├── Token.java                     # single game token
└── Tokens.java                    # collection of tokens for a player
```
