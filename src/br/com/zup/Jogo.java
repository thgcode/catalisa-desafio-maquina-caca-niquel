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
    public List<Opcao> joga() {
        List<Opcao> opcoes = nivel.sortearOpcoes();
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
     * Verifica se a lista de opções passada contém todos os valores iguais
     *
     * @param opcoes uma lista contendo as opções
     * @return um booleano, se true as opções são iguais
     */
    public static boolean opcoesSaoIguais(List<Opcao> opcoes) {
        if (opcoes.size() == 1) {
            return false;
        }

        Opcao primeira = opcoes.get(0);

        for (int i = 1; i < opcoes.size(); i++) {
            if (!opcoes.get(i).equals(primeira)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Atualiza a pontuação do jogador baseado nas opções escolhidas pela máquina
     *
     * @param opcoes a lista de opções escolhida
     */
    public void atualizarPontuacao(List<Opcao> opcoes) {
        if (opcoesSaoIguais(opcoes)) {
            pontuacao *= 100;
        } else {
            for (Opcao opcao : opcoes) {
                pontuacao += opcao.getQuantidadeDePontos();
            }
        }
    }

}