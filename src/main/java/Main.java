import CriptografiaAES.CriptografiaAES;
import HashSHA256.HashSHA256;

import java.util.Scanner;

/**
 * Trabalho Prático - Estrutura de Dados II
 * Tema: Criptografia, Hash e Blockchain
 *
 * Aplicação em modo texto com menu interativo:
 *  1 - Criptografar e descriptografar (AES-256)
 *  2 - Geração e comparação de hash (SHA-256)
 *  3 - Descriptografar texto cifrado colado (Base64)
 *  0 - Sair
 */
public class Main {

    private static final Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenu();
            opcao = lerOpcao();
            switch (opcao) {
                case 1:
                    atividade1();
                    break;
                case 2:
                    atividade2();
                    break;
                case 3:
                    descriptografarColado();
                    break;
                case 0:
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void exibirMenu() {
        System.out.println();
        System.out.println("=========================================================================================");
        System.out.println("                      CRIPTOGRAFIA E HASH - ESTRUTURA DE DADOS II");
        System.out.println("=========================================================================================");
        System.out.println("1 - Criptografar e descriptografar (AES-256)");
        System.out.println("2 - Gerar e comparar hash (SHA-256)");
        System.out.println("3 - Descriptografar texto cifrado colado (Base64)");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static int lerOpcao() {
        try {
            return Integer.parseInt(entrada.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    // ------------------------------------------------------------------
    // Atividade 1: criptografia e descriptografia
    // ------------------------------------------------------------------
    private static void atividade1() {
        System.out.println("\n--- ATIVIDADE 1: CRIPTOGRAFIA AES-256 ---");
        System.out.print("Digite a mensagem: ");
        String mensagem = entrada.nextLine();
        System.out.print("Digite a chave (senha): ");
        String chave = entrada.nextLine();

        if (mensagem.isEmpty() || chave.isEmpty()) {
            System.out.println("A mensagem e a chave não podem ser vazias.");
            return;
        }

        try {
            // Passo a passo para facilitar a explicação na apresentação
            String hashChave = HashSHA256.gerarHash(chave);
            System.out.println("\n[1] Chave de 256 bits derivada da senha (SHA-256):");
            System.out.println("    " + hashChave);

            String cifrado = CriptografiaAES.criptografar(mensagem, chave);
            System.out.println("\n[2] Texto original    : " + mensagem);
            System.out.println("[3] Texto criptografado (Base64 de IV + cifra):");
            System.out.println("    " + cifrado);

            String decifrado = CriptografiaAES.descriptografar(cifrado, chave);
            System.out.println("\n[4] Texto descriptografado: " + decifrado);

            if (decifrado.equals(mensagem)) {
                System.out.println("[5] OK: o texto original foi recuperado com sucesso!");
            } else {
                System.out.println("[5] ERRO: o texto recuperado é diferente do original.");
            }

            // Demonstração opcional: descriptografar com chave errada
            System.out.print("\nDeseja testar a descriptografia com uma chave ERRADA? (s/n): ");
            if (entrada.nextLine().trim().equalsIgnoreCase("s")) {
                System.out.print("Digite a chave errada: ");
                String chaveErrada = entrada.nextLine();
                try {
                    String resultado = CriptografiaAES.descriptografar(cifrado, chaveErrada);
                    System.out.println("Resultado (lixo): " + resultado);
                } catch (Exception e) {
                    System.out.println("Falha esperada: com a chave errada não é possível descriptografar.");
                }
            }
        } catch (Exception e) {
            System.out.println("Erro na criptografia: " + e.getMessage());
        }
    }

    // ------------------------------------------------------------------
    // Atividade 2: geração e comparação de hash
    // ------------------------------------------------------------------
    private static void atividade2() {
        System.out.println("\n--- ATIVIDADE 2: HASH SHA-256 ---");
        try {
            System.out.print("Digite a primeira mensagem: ");
            String msg1 = entrada.nextLine();
            String hash1 = HashSHA256.gerarHash(msg1);
            System.out.println("Hash 1: " + hash1);

            System.out.print("\nDigite a segunda mensagem: ");
            String msg2 = entrada.nextLine();
            String hash2 = HashSHA256.gerarHash(msg2);
            System.out.println("Hash 2: " + hash2);

            System.out.println();
            if (hash1.equals(hash2)) {
                System.out.println("Resultado: os hashes são IGUAIS (as mensagens são idênticas).");
            } else {
                System.out.println("Resultado: os hashes são DIFERENTES (as mensagens foram alteradas).");
                int hex = HashSHA256.contarCaracteresDiferentes(hash1, hash2);
                int bits = HashSHA256.contarBitsDiferentes(hash1, hash2);
                System.out.println("Caracteres hexadecimais diferentes: " + hex + " de 64");
                System.out.println("Bits diferentes: " + bits + " de 256 (efeito avalanche)");
            }
        } catch (Exception e) {
            System.out.println("Erro ao gerar hash: " + e.getMessage());
        }
    }

    // ------------------------------------------------------------------
    // Funcionalidade Extra: Descriptografar texto colado
    // ------------------------------------------------------------------
    private static void descriptografarColado() {
        System.out.println("\n--- DESCRIPTOGRAFAR TEXTO COLADO ---");
        System.out.print("Cole o texto cifrado ");
        String textoCifradoColado = entrada.nextLine().trim();

        System.out.print("Digite a senha correta: ");
        String senhaDigitada = entrada.nextLine();

        try {
            String recuperado = CriptografiaAES.descriptografar(textoCifradoColado, senhaDigitada);
            System.out.println("\n[OK] Texto descriptografado com sucesso!");
            System.out.println("Mensagem original: " + recuperado);
        } catch (Exception e) {
            System.out.println("\n[ERRO] Falha na descriptografia! Verifique se a senha está correta ou se o texto cifrado é válido.");
        }
    }
}