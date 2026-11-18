package HashSHA256;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * Geração de hash SHA-256 com a classe MessageDigest do Java.
 *
 * Como funciona (resumo):
 *  - A mensagem é convertida em bytes e recebe padding até ficar múltipla de 512 bits.
 *  - É processada em blocos de 512 bits; cada bloco passa por 64 rodadas que combinam
 *    operações de rotação, deslocamento, XOR, AND e soma módulo 2^32.
 *  - O estado interno (8 palavras de 32 bits) é atualizado a cada bloco.
 *  - O resultado final tem sempre 256 bits (64 caracteres hexadecimais),
 *    não importa o tamanho da entrada.
 *  - É uma função de mão única (não há como "descriptografar") e tem efeito avalanche:
 *    mudar 1 caractere altera cerca de metade dos bits do hash.
 */
public class HashSHA256 {

    /** Calcula o SHA-256 de um texto e devolve em hexadecimal (64 caracteres). */
    public static String gerarHash(String texto) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(texto.getBytes(StandardCharsets.UTF_8));

        StringBuilder hex = new StringBuilder();
        for (byte b : hash) {
            hex.append(String.format("%02x", b)); // cada byte vira 2 dígitos hexadecimais
        }
        return hex.toString();
    }

    /** Conta em quantas posições (de 64) dois hashes hexadecimais diferem. */
    public static int contarCaracteresDiferentes(String h1, String h2) {
        int diferentes = 0;
        for (int i = 0; i < h1.length(); i++) {
            if (h1.charAt(i) != h2.charAt(i)) {
                diferentes++;
            }
        }
        return diferentes;
    }

    /** Conta em quantos bits (de 256) dois hashes diferem: demonstra o efeito avalanche. */
    public static int contarBitsDiferentes(String h1, String h2) {
        int bits = 0;
        for (int i = 0; i < h1.length(); i++) {
            int a = Character.digit(h1.charAt(i), 16);
            int b = Character.digit(h2.charAt(i), 16);
            bits += Integer.bitCount(a ^ b);
        }
        return bits;
    }
}