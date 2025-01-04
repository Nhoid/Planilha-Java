package org.project.models;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Planilha {

    private boolean ordenada = false;

    private ArrayList<Celula> celulas;

    public Planilha ordenar() {

        celulas.sort(Celula::compareTo);

        this.ordenada = true;

        return this;
    }

    public Planilha complete() {

        // verifica se a planilha esta ordenada, necessario que esteja
        if (!this.ordenada)
            ordenar();

        // pega a as coordenadas das ultima celula
        int maiorX = celulas.getLast().getX();
        int maiorY = celulas.getLast().getY();

        int index = 0;

        // vai iterando sobre toda a matriz
        for (int y = 0; y < maiorY; y++) {
            for (int x = 0; x < maiorX; x++) {

                Celula celula = celulas.get(index);

                /*
                *  Aqui ele faz uma verificacao se a celula atual esta na posicao que deveria
                *  para ela estar na posicao certa, o x e y tem que ser o mesmo
                *  se o x e y for diferente, significa que deveria existir uma ou mais celula antes dela
                *  ele cria uma celula vazia
                */
                if ( !(celula.getX() == x && celula.getY() == y) ) {
                    celulas.add(index, new Celula(x, y));
                }

                index++;
            }
        }

        return this;
    }


    public Planilha compactar() {

        // remove as celulas que nao tiver nenhum dado guardado nelas
        celulas = celulas.stream().filter(celula -> !celula.getData().isEmpty()).collect(Collectors.toCollection(ArrayList::new));

        return this;
    }

    public void adicionar(Celula celula) {
        celulas.add(celula);
        this.ordenada = false;
    }

    public Planilha() {
        this.celulas = new ArrayList<>();
    }

    public Planilha(ArrayList<Celula> celulas) {
        this.celulas = celulas;
    }

    public void setCelulas(ArrayList<Celula> celulas) {
        this.celulas = celulas;
    }

}
