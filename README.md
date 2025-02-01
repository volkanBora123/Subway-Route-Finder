# Subway Route Finder

## Overview
This project is a subway route finder that takes two subway station names as input and calculates the optimal path between them. The program determines whether a direct route exists or if multiple transfers are needed. The result is displayed as text and animated on a graphical canvas.

## Features
- Accepts two subway station names from the user.
- Checks if the input stations are valid.
- Determines the optimal path with up to four transfers.
- Displays the path in text format.
- Animates the path visually on a canvas.

## Technologies Used
- Java (Core logic and algorithm implementation)
- StdDraw (For visualization and animation)
- Data Structures (Arrays, Lists for managing station data efficiently)

## Installation & Usage
### Prerequisites
Ensure you have:
- Java installed (JDK 8 or later recommended)
- An IDE or terminal for execution

## Logic Breakdown
1. Input Handling:
   - Takes two station names as input.
   - Validates station names against predefined lists.
2. Route Calculation:
   - Checks if the stations are on the same line.
   - If not, determines the minimal number of transfers needed.
   - Uses a recursive approach to find paths with 1, 2, 3, or 4 transfers.
3. Visualization:
   - Displays the route in text format.
   - Uses StdDraw to animate the train movement between stations.

## Example
```sh
Yenikapi
Taksim

Yenikapi
Veznecilee
Halic
Sishane
Taksim
(Visual animation follows)
```

## Future Enhancements
- Implementing a GUI-based interface for user-friendly interaction.
- Adding real-time transit data integration.
- Optimizing route calculation using graph algorithms.

## Author
- Volkan Bora Seki

