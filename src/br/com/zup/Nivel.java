package br.com.zup;

import java.util.*;

/**
 * Representa um nível de jogo com suas possibilidades.
 *
 */
public abstract class Nivel {
    private List <Opcao> possibilidades;
    private Random sorteador;
    private int quantidadeDeValores;

    /**
     * Constrói o nível com as possibilidades especificadas.
     *
     * @param possibilidades uma lista com as possibilidades que podem ser escolhidas pela máquina
     * @param quantidadeDeValores um int contendo a quantidade de valores que serão gerados a cada rodada do jogo
     */
    public Nivel(List <Opcao> possibilidades, int quantidadeDeValores) {
        sorteador = new Random();
        this.possibilidades = possibilidades;
        this.quantidadeDeValores = quantidadeDeValores;
    }

    /**
     * Sorteia uma lista com possibilidades de opção
     *
     * @return uma lista com as possibilidades escolhidas
     */
    public List <Opcao> sortearOpcoes() {
        List <Opcao> opcoesEscolhidas = new ArrayList <>();

        for (int i = 0; i < quantidadeDeValores; i ++) {
            Opcao opcao = possibilidades.get(sorteador.nextInt(possibilidades.size()));
            opcoesEscolhidas.add(opcao);
        }

        return opcoesEscolhidas;
    }

    /**
     * Pega a lista de possibilidades
     *
     * @return uma lista com todas as possibilidades de opções
     */
    public List <Opcao> getPossibilidades() {
        return possibilidades;
    }

    /**
     * Pega a quantidade de valores que serão gerados
     *
     * @return um int com a quantidade de valores
     */
    public int getQuantidadeDeValores() {
        return quantidadeDeValores;
    }

    /**
     * Configura a quantidade de valores do nível
     *
     * @param novaQuantidade um int com a nova quantidade de valores
     */
    public void setQuantidadeDeValores(int novaQuantidade) {
        quantidadeDeValores = novaQuantidade;
    }
}
