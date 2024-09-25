package Game.Controler;

import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static Game.Constants.Constants.BLOCK_SIZE;
import static Game.Constants.Constants.MAP;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.Timer;

import Game.Map.Map;
import Game.Player.Player;

import java.awt.event.ActionListener;

public class GameControler extends JPanel implements ActionListener, KeyListener {
    Player player = new Player();
    Map bombMap = new Map();
    boolean comecou = false;
    
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        System.out.println("key pressed: " + keyCode);
        if (keyCode == KeyEvent.VK_RIGHT) {
            comecou = true;
        }
        if (keyCode == KeyEvent.VK_LEFT) {
            comecou = true;

        }
        if (keyCode == KeyEvent.VK_DOWN) {
            comecou = true;

        }
        if (keyCode == KeyEvent.VK_UP) {
            comecou = true;

        }
        if (keyCode == KeyEvent.VK_SPACE) {

        }
        if (keyCode == KeyEvent.VK_ENTER) {
            
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    public GameControler() {
        for (int i = 0; i < bombMap.getBombas().length; i++) {
            bombMap.GenerateBomb();
        }


    }

    protected void paintComponent(Graphics g) {
        Font font = new Font("Arial", Font.PLAIN, BLOCK_SIZE);

        //Fundo do mapa
        for (int i = 0; i < MAP.length; i++) {
            for (int j = 0; j < MAP[0].length; j++) {
                if (Map.CheckMapPosition(i, j) == 0) {
                    g.setColor(Color.LIGHT_GRAY);
                    g.fillRect(j * BLOCK_SIZE, i * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
                } else {
                    g.setColor(Color.BLUE);
                    g.fillRect(j * BLOCK_SIZE, i * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
                }
            }
        }

        //Números
        for (int i = 1; i < MAP.length - 1; i++) {
            for (int j = 1; j < MAP[0].length - 1; j++) {
                if (bombMap.HasBomb(i, j)) {
                    g.setColor(Color.white);
                    g.setFont(font);
                    g.drawString("X", i * BLOCK_SIZE + 15, (j + 1) * BLOCK_SIZE);
                } else {
                    int bombas = bombMap.BombsAround(i, j);
                    switch (bombas) {
                        case 1:
                            g.setColor(Color.BLUE);
                            break;
                        case 2:
                            g.setColor(Color.GREEN);
                            break;
                        case 3:
                            g.setColor(Color.YELLOW);
                            break;
                        case 4:
                            g.setColor(Color.RED);
                            break;
                        case 5:
                            g.setColor(Color.black);
                            break;
                        default:
                            g.setColor(Color.WHITE);
                            break;
                    }
                    g.setFont(font);
                    g.drawString(Integer.toString(bombas), i * BLOCK_SIZE + 15, (j + 1) * BLOCK_SIZE);
                }
            }
        }

        //O que o player consegue ver
        for (int i = 0; i < player.getViewMap().length; i++) {
            for (int j = 0; j < player.getViewMap()[0].length; j++) {
                if (player.getViewMap()[i][j] == 1) {
                    g.setColor(Color.GREEN);
                    g.fillRect(j * 50, i * 50, BLOCK_SIZE, BLOCK_SIZE);
                }
            }
        }

        //o que o player vai selecionar
        g.setColor(Color.CYAN);
        g.fillRect((player.getGuess()[0]) * BLOCK_SIZE, (player.getGuess()[1]+1) * BLOCK_SIZE, BLOCK_SIZE, 5);
        g.fillRect((player.getGuess()[0]) * BLOCK_SIZE, player.getGuess()[1] * BLOCK_SIZE, BLOCK_SIZE, 5);
        g.fillRect((player.getGuess()[0]+1) * BLOCK_SIZE, player.getGuess()[1] * BLOCK_SIZE, 5, BLOCK_SIZE+5);
        g.fillRect((player.getGuess()[0]) * BLOCK_SIZE, player.getGuess()[1] * BLOCK_SIZE, 5, BLOCK_SIZE);
        
        
    }
}
