package Game.Map;

import static Game.Constants.Constants.MAX_BOMBAS;
import static Game.Constants.Constants.MIN_BOMBAS;
import static Game.Constants.Constants.POSICAO_INCIAL;
import static Game.Constants.Constants.MAP;

public class Map {
    private int[][] bombas;
    private int contador = 0;

    // Gera uma bomba
    public void GenerateBomb() {
        int x = (int) (Math.random() * (MAP.length - 3) + 1);
        int y = (int) (Math.random() * (MAP[0].length - 3) + 1);

        if (ValidateBombPosition(x, y)) {
            AddBomb(x, y);
        } else {
            GenerateBomb();
        }
    }

    // Verifica se a posição (x, y) da bomba é valida
    public boolean ValidateBombPosition(int x, int y) {
        if (CheckMapPosition(x, y) == 0) {
            for (int i = 0; i < contador; i++) {
                if (bombas[i][0] == x && bombas[i][1] == y) {
                    return false;
                }
            }
            if (x != POSICAO_INCIAL[0] && y != POSICAO_INCIAL[1]) {
                return true;
            }
        }
        return false;
    }

    // Adiciona a bomba no array de bombas e soma no contador
    public void AddBomb(int x, int y) {
        bombas[contador][0] = x;
        bombas[contador][1] = y;
        contador++;
        System.out.println(contador + ": { " + x + ", " + y + " }");
    }

    // Verifica se a poisição (x, y) tem uma bomba ou não
    public boolean HasBomb(int x, int y) {
        for (int i = 0; i < contador; i++) {
            if (bombas[i][0] == x && bombas[i][1] == y) {
                return true;
            }
        }
        return false;
    }

    // Verifica se a posição (x, y) tem uma bomba ou não
    public boolean HasBomb(int[] position) {
        for (int i = 0; i < contador; i++) {
            if (bombas[i][0] == position[0] && bombas[i][1] == position[1]) {
                return true;
            }
        }
        return false;
    }

    // Verifica quantas bombas tem ao redor da poisção (x, y)
    public int BombsAround(int x, int y) {
        int soma = 0;
        for (int i = x - 1; i < x + 2; i++) {
            for (int j = y - 1; j < y + 2; j++) {
                if (CheckMapPosition(i, j) == 0 && (x != i || y != j)) {
                    if (HasBomb(i, j)) {
                        soma++;
                    }
                }
            }
        }
        return soma;
    }

    // Verifica quantas bombas tem ao redor da posição (x, y)
    public int BombsAround(int[] position) {
        int soma = 0;
        for (int i = position[0] - 1; i < position[0] + 2; i++) {
            for (int j = position[1] - 1; j < position[1] + 2; j++) {
                if (CheckMapPosition(position[0], position[1]) == 0 && (position[0] != i || position[1] != j)) {
                    if (HasBomb(position[0], position[1])) {
                        soma++;
                    }
                }
            }
        }
        return soma;
    }

    public static int CheckMapPosition(int x, int y) {
        return MAP[x][y];
    }

    public static int CheckMapPosition(int[] xy) {
        return MAP[xy[0]][xy[1]];
    }

    public int[][] getBombas() {
        return this.bombas;
    }

    public void setBombas(int[][] bombas) {
        this.bombas = bombas;
    }

    public int getContador() {
        return this.contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    // Inicializa a classe com a quantidade de bombas definidas
    public Map() {
        int aux = (int) (Math.random() * (MAX_BOMBAS - MIN_BOMBAS) + MIN_BOMBAS);
        bombas = new int[aux][2];
    }
}
