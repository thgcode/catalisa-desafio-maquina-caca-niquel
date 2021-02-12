package br.com.zup;

/**
 * Classe que armazena o estado do jogo atual, o nível de dificuldade e quantos pontos o jogador tem.
 *
 */
public class Jogo {
    private int pontuacao;
    private Nivel nivel;

    /**
     * Constrói o jogo com o nível de dificuldade especificado.
     *
     * @param nivel o nível de dificuldade que este jogo terá.
     */
    public Jogo(Nivel nivel) {
        pontuacao = 0;
        this.nivel = nivel;
    }

    /**
     * Executa uma simulação do jogo de caça níquel
     *
     * @return um array com as opções escolhidas pela máquina, para a classe do sistema poder avisar para o jogador
     */
    public Opcao[] joga() {
        opcoes = nivel.sorteia();
        calculaPontuacao(opcoes);
        return opcoes;
    }

    /**
     * Pega a pontuação que o jogador tem atualmente
     *
     * @return um int contendo a pontuação atual
     */
    public int getPontuacao() {
        return pontuacao;
    }

}