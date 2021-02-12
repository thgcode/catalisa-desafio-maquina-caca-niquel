package br.com.zup;

import java.util.List;
import java.util.Scanner;

/**
 * Classe que faz a interação com o usuário
 *
 */
public class Sistema {
    private static Scanner scanner = new Scanner(System.in);
    private static Nivel []niveis = new Nivel []{new PrimeiroNivel(), new SegundoNivel(), new TerceiroNivel()};

    /**
     * Pede para o usuário escolher um nível
     *
     * @return o objeto do nível escolhido
     * @throws Exception quando o jogador coloca um nível inválido
     */
    private static Nivel escolherNivel() throws Exception {
        System.out.println("Caça níquel\nQual nível você quer jogar (de 1 a " + niveis.length + "?");
        int nivel = Integer.parseInt(scanner.nextLine());

        try {
            return niveis[nivel - 1];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new Exception("Nível não está dentro dos permitidos.");
        }
    }

    /**
     * Configura quantos números a máquina gera para o nível escolhido
     *
     * @param nivel o nível de dificuldade escolhido
     */
    private static void configurarDificuldade(Nivel nivel) {
        System.out.println("Quantos valores devem ser gerados para este nível? (O padrão do nível é " + nivel.getQuantidadeDeValores());
        int novaQuantidade = Integer.parseInt(scanner.nextLine());

        if (novaQuantidade > 3) {
            nivel.setQuantidadeDeValores(novaQuantidade);
        }
    }

    /**
     * Joga o nível escolhido
     *
     * @param nivel o nível escolhido
     */
    private static void jogar(Nivel nivel) {
        Jogo jogo = new Jogo(nivel);

        boolean continuar;

        do {
            System.out.println("Sorteando os seus pontos...");

            List <Opcao> opcoes = jogo.jogar();

            System.out.println("Você conseguiu:");

            for (Opcao opcao : opcoes) {
                System.out.println(opcao.name() + ", que te deu " + opcao.getQuantidadeDePontos() + " pontos.");
            }

            if (Jogo.opcoesSaoIguais(opcoes)) {
                System.out.println("Que sorte! Você conseguiu o bônus de sair todos os números iguais!");
            }

            System.out.println("Você tem agora " + jogo.getPontuacao() + " pontos no total.\nQuer jogar de novo? Digite sim ou não:");
            continuar = scanner.nextLine().equalsIgnoreCase("sim");
        } while (continuar);
    }

    /**
     * Executa a interação com o usuário
     */
    public static void executarSistema() {
        try {
            Nivel nivel = escolherNivel();
            configurarDificuldade(nivel);
            jogar(nivel);
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
    }
}
