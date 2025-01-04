package org.project.models;

// Classe responsavel por guardar os dados e suas coordenadas
public class Celula implements Comparable<Celula> {

    // regex para identificar se os dados estao no formato aceitvael
    // ex: 1;2;"nome"
    // o dado "nome" esta sendo guardado na coluna 1, linha 2
    private final String REGEX = "[0-9]+;[0-9]+;\"[^\"]+\"";

    private int x;
    private int y;

    private String data;

    public Celula(int x, int y, String data) {
        this.x = x;
        this.y = y;
        this.data = data;
    }

    public Celula(String celula) throws Exception {
        if ( celula.matches(REGEX ) ) { // verifica formato dos dados passados

            String[] dados = celula.split(";");

            this.x = Integer.parseInt(dados[0]);
            this.y = Integer.parseInt(dados[1]);
            this.data = dados[2];

        } else {
            throw new Exception("Dados invalidos");
        }
    }

    public Celula(int x, int y) { // cria uma celula vazia
        this.x = x;
        this.y = y;
        this.data = "";
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return x + ";" + y + ";" + "\"" + data + "\"";
    }

    @Override
    public int compareTo(Celula o) {
        if (this.y > o.y) {
            return 1;
        }else if (this.y < o.y) {
            return -1;
        }

        if (this.x > o.x) {
            return 1;
        }else if (this.x < o.x) {
            return -1;
        }

        return 0;
    }
}
