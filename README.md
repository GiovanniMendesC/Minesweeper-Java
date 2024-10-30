# Minesweeper-Java

Minesweeper is a classic logic-based puzzle game where players clear a grid of squares without setting off hidden mines. The game starts with a grid of covered squares, each square potentially hidding a mine. Players click on squares to uncover them, hoping not ot reveal a mine. If a player clicks on a square with a mine, the game is lost.

When a safe square is uncoverd, it reveals a number indicating how many mines are adjacent to it (this includes diagonally neigboring squares). For exemple, if a square shows the number "2", there are two bombs mines in the sorrounding eight squares. using this information, players deduce witch nearby squares are safe to uncover and witch likely contains mines.

# How to play in this version

In this version of the game, the position of the player is indicated by a blue bordered square, and the player moves by hitting the up, down, left, and right arrow keys on the keyboard. The squares can be checked by hitting space on the keyboard and it reveals the content of the square only if it does not contain a mine. 

When the player checks a square that has no mines arround them (has the number '0') then it will begin to reveal the saquares around them that also have '0' as number.
