package br.com.zup;

import java.util.Scanner;

public class Sistema {
    private static Scanner scanner = new Scanner(System.in);
    private static Nivel []niveis = new Nivel []{new PrimeiroNivel()};

    private static Nivel escolheNivel() throws Exception {
        System.out.println("Caça níquel\nQual nível você quer jogar (de 1 a " + niveis.length + "?");
        int nivel = Integer.parseInt(scanner.nextLine());

        try {
            return niveis[nivel - 1];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new Exception("Nível não está dentro dos permitidos.");
        }
    }

    private static void jogar(Nivel nivel) {
        Jogo jogo = new Jogo(nivel);

        boolean continuar;

        do {
            System.out.println("Sorteando os seus pontos...");

            Opcao[] opcoes = jogo.joga().toArray(new Opcao[0]);

            System.out.println("Você conseguiu:");

            for (Opcao opcao : opcoes) {
                System.out.println(opcao.name() + ", que te deu " + opcao.getQuantidadeDePontos() + " pontos.");
            }

            System.out.println("Você tem agora " + jogo.getPontuacao() + " pontos no total.\nQuer jogar de novo? Digite sim ou não:");
            continuar = scanner.nextLine().equalsIgnoreCase("sim");
        } while (continuar);
    }

    public static void executarSistema() {
        try {
            Nivel nivel = escolheNivel();
            jogar(nivel);
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
    }
}