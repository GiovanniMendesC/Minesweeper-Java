package Game.Player;

import static Game.Constants.Constants.MAP;
import static Game.Constants.Constants.POSICAO_INCIAL;

public class Player {
    private int[][] viewMap = new int[MAP.length][MAP[0].length];
    private int[] guess = new int[2];
    private int quantidadeFaltando;

    // Libera a posição no mapa que bloqueia a visão do jogador
    public void freeMap(int x, int y) {
        if (viewMap[x][y] != 0) {
            viewMap[x][y] = 0;
            quantidadeFaltando--;
        }
    }

    // Liberaa posição do mapa que bloqueia a visão do jogador
    public void freeMap(int[] position) {
        if (viewMap[position[0]][position[1]] != 0) {
            viewMap[position[0]][position[1]] = 0;
            quantidadeFaltando--;
        }
    }

    // Verifica se a posição está liberada ou não
    public boolean IsFree(int x, int y) {
        if (viewMap[x][y] == 0) {
            return true;
        }
        return false;
    }

    public void markUnmarkBomb(int x, int y) {
        if (!IsFree(x, y)) {
            viewMap[x][y] = viewMap[x][y] == -1 ? 1 : -1;
        }
    }

    public int[][] getViewMap() {
        return this.viewMap;
    }

    public void setViewMap(int[][] viewMap) {
        this.viewMap = viewMap;
    }

    public int[] getGuess() {
        return this.guess;
    }

    public void setGuess(int[] guess) {
        this.guess = guess;
    }

    public int getQuantidadeFaltando() {
        return this.quantidadeFaltando;
    }

    public void setQuantidadeFaltando(int quantidadeFaltando) {
        this.quantidadeFaltando = quantidadeFaltando;
    }

    // Inicializa a classe com o mapa de visualização inverso ao do mapa de jogo
    // e seta a posição inicial e a quantidade de espaços não liberados do mapa
    public Player() {
        for (int i = 0; i < MAP.length; i++) {
            for (int j = 0; j < MAP[0].length; j++) {
                if (MAP[i][j] == 1) {
                    viewMap[i][j] = 0;
                } else {
                    viewMap[i][j] = 1;
                }
            }
        }
        guess = new int[] { POSICAO_INCIAL[0], POSICAO_INCIAL[1] };
        quantidadeFaltando = (MAP.length - 2) * (MAP[0].length - 2);
    }
}
