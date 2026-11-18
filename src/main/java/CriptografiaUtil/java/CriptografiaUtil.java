package com.trabalho;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class CriptografiaUtil {

    private static final String ALGORITMO = "AES";

    public static String criptografar(String textoPuro, String chaveStr) throws Exception {
        SecretKeySpec chave = ajustarChave(chaveStr);
        Cipher cipher = Cipher.getInstance(ALGORITMO);
        cipher.init(Cipher.ENCRYPT_MODE, chave);
        byte[] bytesCriptografados = cipher.doFinal(textoPuro.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(bytesCriptografados);
    }

    public static String descriptografar(String textoCriptografado, String chaveStr) throws Exception {
        SecretKeySpec chave = ajustarChave(chaveStr);
        Cipher cipher = Cipher.getInstance(ALGORITMO);
        cipher.init(Cipher.DECRYPT_MODE, chave);
        byte[] bytesDecodificados = Base64.getDecoder().decode(textoCriptografado);
        byte[] bytesOriginais = cipher.doFinal(bytesDecodificados);
        return new String(bytesOriginais, "UTF-8");
    }

    private static SecretKeySpec ajustarChave(String chaveStr) {
        byte[] keyBytes = new byte[16];
        byte[] inputBytes = chaveStr.getBytes();
        System.arraycopy(inputBytes, 0, keyBytes, 0, Math.min(inputBytes.length, keyBytes.length));
        return new SecretKeySpec(keyBytes, ALGORITMO);
    }
}