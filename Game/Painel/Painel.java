package Game.Painel;

import static Game.Constants.Constants.COMPRIMENTO_TELA;
import static Game.Constants.Constants.LARGURA_TELA;
import static Game.Constants.Constants.BLOCK_SIZE;

import javax.swing.JFrame;

import Game.Controller.GameController;

public class Painel {

    // Cria a janela com os componentes
    public static void GamePainel() {
        GameController gc = new GameController();
        JFrame frame = new JFrame("Minesweeper Console");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(LARGURA_TELA + BLOCK_SIZE / 2, COMPRIMENTO_TELA + BLOCK_SIZE);
        frame.add(gc);

        frame.setVisible(true);
    }
}
