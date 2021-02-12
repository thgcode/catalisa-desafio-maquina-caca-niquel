package br.com.zup;

/**
 * Armazena cada opção de possibilidade de pontuação do caça níquel
 *
 */
public enum Opcao {
    BANANA(10),
    MORANGO(20),
    ESTRELA(40);
    public int quantidadeDePontos;

    /**
     * Constrói uma opção com a quantidade de pontos especificada.
     *
     * @param quantidadeDePontos a quantidade de pontos que essa opção vai dar ao jogador
     */
    Opcao(int quantidadeDePontos) {
        this.quantidadeDePontos = quantidadeDePontos;
    }

    /**
     * Pega o valor da pontuação dessa opção
     *
     * @return um int com a pontuação que essa opção dá ao jogador
     */
    public int getQuantidadeDePontos() {
        return quantidadeDePontos;
    }
}