package Game.Controller;

import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static Game.Constants.Constants.BLOCK_SIZE;
import static Game.Constants.Constants.MAP;
import static Game.Constants.Constants.TAXA_TELA;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.Timer;

import Game.Map.Map;
import Game.Player.Player;

import java.awt.event.ActionListener;

public class GameController extends JPanel implements ActionListener, KeyListener {
    private Player player = new Player();
    private Map bombMap = new Map();
    private boolean perdeu = false;
    private boolean acabou = true;
    private Timer timer;
    private int direcao = 0;// 1 cima
                            // 2 baixo
                            // 3 direita
                            // 4 esquerda

    // Colocando as Keys para setar as direções e os comandos do jogador
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        System.out.println("Bombas presentes: " + bombMap.getBombas().length);
        System.out.println("Bombas restantes: " + player.getQuantidadeFaltando());
        if (keyCode == KeyEvent.VK_LEFT) {
            direcao = 1;
            MoveAround(direcao);
        }
        if (keyCode == KeyEvent.VK_RIGHT) {
            direcao = 2;
            MoveAround(direcao);

        }
        if (keyCode == KeyEvent.VK_DOWN) {
            direcao = 3;
            MoveAround(direcao);

        }
        if (keyCode == KeyEvent.VK_UP) {
            direcao = 4;
            MoveAround(direcao);

        }
        if (keyCode == KeyEvent.VK_SPACE || keyCode == KeyEvent.VK_ENTER) {
            if (!bombMap.HasBomb(player.getGuess())) {
                Libera(player.getGuess()[0], player.getGuess()[1]);
            } else {
                acabou = true;
                perdeu = true;
            }
        }
        if (keyCode == KeyEvent.VK_F) {
            player.markUnmarkBomb(player.getGuess()[0], player.getGuess()[1]);
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

    // Inicia o timer e o mapa de bombas
    public GameController() {
        for (int i = 0; i < bombMap.getBombas().length; i++) {
            bombMap.GenerateBomb();
        }

        timer = new Timer(TAXA_TELA, e -> {
            repaint();
        });

        timer.start();
        addKeyListener(this);
        setFocusable(true);
    }

    // Desenha os components da tela
    protected void paintComponent(Graphics g) {
        Font font = new Font("Arial", Font.PLAIN, BLOCK_SIZE);

        // Fundo do mapa
        for (int i = 0; i < MAP.length; i++) {
            for (int j = 0; j < MAP[0].length; j++) {
                if (Map.CheckMapPosition(i, j) == 0) {
                    g.setColor(Color.LIGHT_GRAY);
                    g.fillRect(i * BLOCK_SIZE, j * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
                } else {
                    g.setColor(Color.BLUE);
                    g.fillRect(i * BLOCK_SIZE, j * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
                }
            }
        }

        // Números
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

        // O que o player consegue ver
        for (int i = 0; i < player.getViewMap().length; i++) {
            for (int j = 0; j < player.getViewMap()[0].length; j++) {
                if (player.getViewMap()[i][j] == 1) {
                    g.setColor(Color.GREEN);
                    g.fillRect(i * 50, j * 50, BLOCK_SIZE, BLOCK_SIZE);
                } else if (player.getViewMap()[i][j] == -1) {
                    g.setColor(Color.RED);
                    g.fillRect(i * 50, j * 50, BLOCK_SIZE, BLOCK_SIZE);
                }
            }
        }

        // o que o player vai selecionar
        g.setColor(Color.CYAN);
        g.fillRect((player.getGuess()[0]) * BLOCK_SIZE, (player.getGuess()[1] + 1) * BLOCK_SIZE, BLOCK_SIZE, 5);
        g.fillRect((player.getGuess()[0]) * BLOCK_SIZE, player.getGuess()[1] * BLOCK_SIZE, BLOCK_SIZE, 5);
        g.fillRect((player.getGuess()[0] + 1) * BLOCK_SIZE, player.getGuess()[1] * BLOCK_SIZE, 5, BLOCK_SIZE + 5);
        g.fillRect((player.getGuess()[0]) * BLOCK_SIZE, player.getGuess()[1] * BLOCK_SIZE, 5, BLOCK_SIZE);

        // Quantas bombas faltam
        g.setColor(Color.WHITE);
        g.drawString("Faltam: " + (player.getQuantidadeFaltando() - bombMap.getBombas().length), 1 * BLOCK_SIZE,
                1 * BLOCK_SIZE);

        // Verifica se o jogo acabou
        if (acabou) {
            if (perdeu) {
                repaint();
                timer.stop();
            } else {
                repaint();
                timer.stop();
            }
        }

    }

    // Faz a movimentação do jogador
    public void MoveAround(int direcao) {
        int[] posicao = new int[] { player.getGuess()[0], player.getGuess()[1] };
        switch (direcao) {
            case 1:
                if (Map.CheckMapPosition(player.getGuess()[0] - 1, player.getGuess()[1]) == 0) {
                    posicao[0]--;
                }
                break;
            case 2:
                if (Map.CheckMapPosition(player.getGuess()[0] + 1, player.getGuess()[1]) == 0) {
                    posicao[0]++;
                }
                break;
            case 3:
                if (Map.CheckMapPosition(player.getGuess()[0], player.getGuess()[1] + 1) == 0) {
                    posicao[1]++;
                }
                break;
            case 4:
                if (Map.CheckMapPosition(player.getGuess()[0], player.getGuess()[1] - 1) == 0) {
                    posicao[1]--;
                }
                break;
            default:
                break;
        }
        player.setGuess(posicao);
    }

    // Libera ou não o espaço selecionado no mapa
    public void Libera(int x, int y) {
        if (bombMap.BombsAround(x, y) == 0) {
            for (int i = x - 1; i < x + 2; i++) {
                for (int j = y - 1; j < y + 2; j++) {
                    if (!bombMap.HasBomb(i, j)) {
                        if (Map.CheckMapPosition(i, j) == 0) {
                            if (bombMap.BombsAround(i, j) == 0 && !player.IsFree(i, j) && (i != x && j != y)) {
                                Libera(i, j);
                            }
                            System.out.println("Liberou { " + i + ", " + j + " }");
                            player.freeMap(i, j);

                        }
                    } else {
                        System.out.println("Não liberou { " + i + ", " + j + " }");
                    }
                }
            }
        } else {
            player.freeMap(x, y);

        }

        VerifyIfEnd();

    }

    // Verifica se acabou o jogo
    public void VerifyIfEnd() {
        if (player.getQuantidadeFaltando() == bombMap.getBombas().length) {
            acabou = true;
        }
    }
}
