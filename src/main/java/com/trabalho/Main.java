package com.trabalho;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        do {
            System.out.println("\n==========================================");
            System.out.println("   TRABALHO DE ESTRUTURA DE DADOS II");
            System.out.println("==========================================");
            System.out.println("1. Atividade 1 - Criptografia e Descriptografia (AES)");
            System.out.println("2. Atividade 2 - Geração e Comparação de Hash (SHA-256)");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer

                switch (opcao) {
                    case 1:
                        executarAtividade1(scanner);
                        break;
                    case 2:
                        executarAtividade2(scanner);
                        break;
                    case 0:
                        System.out.println("\nEncerrando o programa. Até logo!");
                        break;
                    default:
                        System.out.println("\nOpção inválida! Escolha entre 0 e 2.");
                }
            } else {
                System.out.println("\nPor favor, digite um número válido.");
                scanner.next(); // Descarta entrada inválida
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void executarAtividade1(Scanner scanner) {
        System.out.println("\n--- ATIVIDADE 1: CRIPTOGRAFIA AES ---");
        try {
            System.out.print("Digite a mensagem de texto original: ");
            String mensagemOriginal = scanner.nextLine();

            System.out.print("Informe a chave de criptografia (ex: senha123): ");
            String chave = scanner.nextLine();

            // Criptografar
            String mensagemCriptografada;
            System.out.println("\n[SUCESSO] Mensagem cryptographic com sucesso!");
            System.out.println(" Texto Original: " + mensagemOriginal);
            System.out.println(" Texto Criptografado: " + mensagemCriptografada);

            // Descriptografar
            String mensagemDescriptografada = CriptografiaUtil.descriptografar(mensagemCriptografada, chave);
            System.out.println("\n[SUCESSO] Mensagem descriptografada com sucesso!");
            System.out.println(" Texto Recuperado: " + mensagemDescriptografada);

        } catch (Exception e) {
            System.out.println("\nErro durante a criptografia/descriptografia: " + e.getMessage());
        }
    }

    private static void executarAtividade2(Scanner scanner) {
        System.out.println("\n--- ATIVIDADE 2: GERAÇÃO DE HASH SHA-256 ---");

        System.out.print("Digite a primeira mensagem de texto: ");
        String msg1 = scanner.nextLine();
        String hash1 = HashUtil.gerarHashSHA256(msg1);

        System.out.println("Hash gerado (SHA-256): " + hash1);

        System.out.print("\nDigite uma segunda mensagem de texto (ou altere um caractere para testar): ");
        String msg2 = scanner.nextLine();
        String hash2 = HashUtil.gerarHashSHA256(msg2);

        System.out.println("Hash gerado (SHA-256): " + hash2);

        System.out.println("\n--- COMPARAÇÃO DOS HASHES ---");
        if (hash1.equals(hash2)) {
            System.out.println("Os hashes são IGUAIS.");
        } else {
            System.out.println("Os hashes são DIFERENTES! (Demonstrando o efeito avalanche do SHA-256)");
        }
    }
}