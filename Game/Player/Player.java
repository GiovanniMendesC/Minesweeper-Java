package Game.Player;

import static Game.Constants.Constants.MAP;
import static Game.Constants.Constants.POSICAO_INCIAL;

public class Player {
    private int[][] viewMap = new int[MAP.length][MAP[0].length];
    private int[] guess = new int[2];
    private int quantidadeFaltando;

    public void freeMap(int x, int y) {
        if (viewMap[x][y] != 0) {
            viewMap[x][y] = 0;
            quantidadeFaltando--;
        }
    }

    public boolean IsFree(int x, int y) {
        if (viewMap[x][y] == 0) {
            return true;
        }
        return false;
    }

    public void freeMap(int[] position) {
        if (viewMap[position[0]][position[1]] != 0) {
            viewMap[position[0]][position[1]] = 0;
            quantidadeFaltando--;
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
