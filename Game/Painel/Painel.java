package Game.Painel;

import static Game.Constants.Constants.COMPRIMENTO_TELA;
import static Game.Constants.Constants.LARGURA_TELA;

import javax.swing.JFrame;

import Game.Controler.GameControler;

public class Painel {
    
    public static void GamePainel() {
        GameControler gc = new GameControler();
        JFrame frame = new JFrame("Minesweeper Console");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(LARGURA_TELA + 20, COMPRIMENTO_TELA + 55);
        frame.add(gc);

        frame.setVisible(true);
    }
}
