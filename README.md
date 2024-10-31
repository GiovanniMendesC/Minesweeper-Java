# Minesweeper-Java

Minesweeper is a classic logic-based puzzle game where players clear a grid of squares without setting off hidden mines. The game starts with a grid of covered squares, each square potentially hidding a mine. Players click on squares to uncover them, hoping not ot reveal a mine. If a player clicks on a square with a mine, the game is lost.

When a safe square is uncoverd, it reveals a number indicating how many mines are adjacent to it (this includes diagonally neigboring squares). For exemple, if a square shows the number ` 2 `, there are two bombs mines in the sorrounding eight squares. using this information, players deduce witch nearby squares are safe to uncover and witch likely contains mines.

# How to play in this version

In this version of the game, the position of the player is indicated by a blue bordered square, and the player moves by hitting the up, down, left, and right arrow keys on the keyboard. The squares can be checked by hitting space on the keyboard and it reveals the content of the square only if it does not contain a mine. If the player believes the saquare has a mine, they can add a flag by hitting the ` F ` key on the keyboard and the square will become red, when you hit ` F ` again, the square comes back to normal. Flagging it does not stop the player from revealing the square.

When the player checks a square that has no mines arround them (has the number ` 0 `) then it will begin to reveal the saquares around them that also have '0' as number.

___

# Campo Minado

Campo Minado é um jogo clássico de lógica e quebra-cabeça, onde o jogador precisa limpar uma grade com quadrados que podem conter minas explosivas. O jogo começa com o campo completamente coberto, contendo minas aleatóriamente espalhadas. O jogador precisa selecionar os quadrados revelá-los, na esperança de não haver uma bomba. Se o jogador seleciona um quadrado que esconde uma mina, o jogo é perdido.

Quando um quadrado sem mina é revelado, no seu lugar aparece o número de minas que se encontram nos quadrados adjacentes à ele. Por exemplo, quando o quadrado mostra o número ` 2 `, isso indica que há 2 bombas ao redor do quadrado. Usando essa informação, o jogador deve ser capaz de deduzir qual quadrado próximo é seguro ou não. Algumas situações fazem com que seja impossível deduzir logicamente a posição da mina e exigem que o jogador tenha sorte ao escolher o quadrado.

# Como jogar essa versão

Nessa versão do jogo, a posição do jogador é indicada por um quadrado com bordas azuis. O jogador pode se mover pressionando as setas no teclado, e pode escolher revelar o quadrado selecionado apertando a tecla ` Espaço `. Quando o jogador acredita que naquela posição pode haver uma mina, ele pode colocar uma flag apertando a tecla ` F `. Para remover essa flag, basta apertar a tecla ` F ` novamente. Adicionar uma flag não impede que o quadrado possa ser revelado. 

Quando o jogador revela um quadrado que não possui minas ao seu redor (tem o número ` 0 `), o campo revelará as posições ao redor que também possuem ` 0 ` como número.

# Controles

  Teclas  |            Ações
:-------: | :--------------------------:
   `←`    |    Mover para a esquerda
   `→`    |    Mover para a direita
   `↑`    |      Mover para cima
   `↓`    |      Mover para baixo
`espaço`  |      Revelar quadrado
   `F`    |  Marcar/Descarmcar quadrado

