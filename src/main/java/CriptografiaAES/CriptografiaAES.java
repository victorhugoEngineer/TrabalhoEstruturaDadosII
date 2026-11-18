package CriptografiaAES;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;

/**
 * Criptografia SIMÉTRICA usando AES-256 no modo CBC com padding PKCS5.
 *
 * Como funciona (resumo):
 *  - AES é uma cifra de bloco: divide a mensagem em blocos de 16 bytes (128 bits).
 *  - Cada bloco passa por 14 rodadas (para chave de 256 bits) de:
 *      SubBytes (substituição por S-Box), ShiftRows (deslocamento de linhas),
 *      MixColumns (mistura das colunas) e AddRoundKey (XOR com a chave da rodada).
 *  - No modo CBC, antes de cifrar cada bloco ele sofre XOR com o bloco cifrado
 *    anterior (o primeiro usa o IV, um vetor aleatório). Assim, textos iguais
 *    geram cifras diferentes e blocos iguais não ficam iguais no resultado.
 *  - Padding PKCS5: completa o último bloco até 16 bytes.
 *  - A descriptografia executa o processo inverso com a MESMA chave.
 */
public class CriptografiaAES {

    private static final String ALGORITMO = "AES/CBC/PKCS5Padding";
    private static final int TAMANHO_IV = 16; // 16 bytes = 128 bits (tamanho do bloco AES)

    /**
     * Transforma a senha digitada (de tamanho qualquer) em uma chave de 256 bits.
     * Usamos SHA-256 da senha: sempre gera exatamente 32 bytes.
     */
    public static SecretKeySpec gerarChave(String senha) throws Exception {
        MessageDigest sha = MessageDigest.getInstance("SHA-256");
        byte[] bytesChave = sha.digest(senha.getBytes(StandardCharsets.UTF_8));
        return new SecretKeySpec(bytesChave, "AES");
    }

    /**
     * Criptografa o texto. O resultado é Base64( IV + textoCifrado ).
     * O IV é aleatório e vai junto no início da mensagem (ele não é secreto).
     */
    public static String criptografar(String textoOriginal, String senha) throws Exception {
        byte[] iv = new byte[TAMANHO_IV];
        new SecureRandom().nextBytes(iv); // IV aleatório a cada criptografia

        Cipher cipher = Cipher.getInstance(ALGORITMO);
        cipher.init(Cipher.ENCRYPT_MODE, gerarChave(senha), new IvParameterSpec(iv));
        byte[] cifrado = cipher.doFinal(textoOriginal.getBytes(StandardCharsets.UTF_8));

        // Junta IV + cifrado em um único vetor
        byte[] resultado = new byte[iv.length + cifrado.length];
        System.arraycopy(iv, 0, resultado, 0, iv.length);
        System.arraycopy(cifrado, 0, resultado, iv.length, cifrado.length);

        // Base64 apenas para o resultado ficar legível no terminal
        return Base64.getEncoder().encodeToString(resultado);
    }

    /**
     * Descriptografa um texto gerado por criptografar().
     * Lança exceção se a chave estiver errada ou o texto tiver sido alterado.
     */
    public static String descriptografar(String textoCifradoBase64, String senha) throws Exception {
        byte[] dados = Base64.getDecoder().decode(textoCifradoBase64);

        // Separa o IV (primeiros 16 bytes) do conteúdo cifrado
        byte[] iv = Arrays.copyOfRange(dados, 0, TAMANHO_IV);
        byte[] cifrado = Arrays.copyOfRange(dados, TAMANHO_IV, dados.length);

        Cipher cipher = Cipher.getInstance(ALGORITMO);
        cipher.init(Cipher.DECRYPT_MODE, gerarChave(senha), new IvParameterSpec(iv));
        byte[] original = cipher.doFinal(cifrado);

        return new String(original, StandardCharsets.UTF_8);
    }

    /** Mostra bytes em hexadecimal (útil para explicar o processo na apresentação). */
    public static String paraHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}