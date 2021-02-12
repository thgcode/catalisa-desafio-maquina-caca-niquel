package br.com.zup;

import java.util.List;

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
    public List <Opcao> joga() {
        List <Opcao> opcoes = nivel.sortearOpcoes();
        atualizarPontuacao(opcoes);
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

    /**
     * Atualiza a pontuação do jogador baseado nas opções escolhidas pela máquina
     *
     * @param opcoes a lista de opções escolhida
     */
    public void atualizarPontuacao(List <Opcao> opcoes) {
        for (Opcao opcao: opcoes) {
            pontuacao += opcao.getQuantidadeDePontos();
        }
    }
}