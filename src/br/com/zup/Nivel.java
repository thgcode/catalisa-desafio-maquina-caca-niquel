package br.com.zup;

import java.util.*;

/**
 * Representa um nível de jogo com suas possibilidades.
 *
 */
public abstract class Nivel {
    private List <Opcao> possibilidades;
    private Random sorteador;

    /**
     * Constroi o nível com as possibilidades especificadas.
     *
     * @param possibilidades uma lista com as possibilidades que podem ser escolhidas pela máquina
     */
    public Nivel(List <Opcao> possibilidades) {
        sorteador = new Random();
        this.possibilidades = possibilidades;
    }

    /**
     * Sorteia uma lista com possibilidades de opção
     *
     * @return uma lista com as possibilidades escolhidas
     */
    public List <Opcao> sortearOpcoes() {
        List <Opcao> opcoesEscolhidas = new ArrayList <>();

        for (int i = 0; i < possibilidades.size(); i ++) {
            Opcao opcao = possibilidades.get(sorteador.nextInt(possibilidades.size()));
            opcoesEscolhidas.add(opcao);
        }

        return opcoesEscolhidas;
    }

    public List <Opcao> getPossibilidades() {
        return possibilidades;
    }
}
