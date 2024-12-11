# Snakes and Ladders Game

This project implements a console-based Snakes and Ladders game using Java. The game simulates rolling dice, moving players on the board, and interacting with snakes and ladders.

## Features

- Dynamic board size and dice rolls.
- Configurable snakes and ladders.
- Multiple players with unique buttons for interaction.
- Winner announcements with ranks.
- Handles scenarios like exceeding board size and snake-ladder interactions.

## Prerequisites

- Java Development Kit (JDK) installed.
- Basic knowledge of Java and object-oriented programming.

## How to Run

1. Clone the repository or download the source code.
2. Compile the Java files using a Java compiler:
   ```bash
   javac *.java
   ```
3. Run the `Board` class to start the game:
   ```bash
   java Board
   ```
4. Follow the on-screen instructions to input player details and play the game.

## Classes and Responsibilities

### Dice

Responsible for simulating dice rolls based on the number of dice.

### Ladder

Represents a ladder on the board with a starting and ending position.

### Snake

Represents a snake on the board with a starting and ending position.

### Player

Holds player details like name, unique button, and ID.

### Board

The main class handling the game logic, interactions between players, dice, snakes, and ladders.

## Example Game Setup

- Board size: 10
- Ladders:
  - Start: 2, End: 6
  - Start: 4, End: 9
- Snakes:
  - Start: 9, End: 3
- Dice: 1

## Known Limitations

- The game doesn't check if the end of a ladder is the start of a snake or vice versa.
- No graphical interface, purely console-based.

## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

.
