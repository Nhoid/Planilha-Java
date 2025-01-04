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

        if (!this.ordenada)
            ordenar();

        int maiorX = celulas.getLast().getX();
        int maiorY = celulas.getLast().getY();

        int index = 0;

        for (int y = 0; y < maiorY; y++) {
            for (int x = 0; x < maiorX; x++) {

                Celula celula = celulas.get(index);

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
