package org.phoenix;

import javax.crypto.Mac;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Encryption {


    public static byte[] convertToSHA256(String data) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        return digest.digest(
                data.getBytes(StandardCharsets.UTF_8));
    }

    public static String encodeToBase64(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }

    public static String decodeFromBase64(String data) {
        byte[] decodedBytes = Base64.getDecoder().decode(data);
        return new String(decodedBytes);
    }

    public static byte[] convertToHMACSHA512(String data, String key) throws NoSuchAlgorithmException {
        Mac sha512_HMAC = Mac.getInstance("HmacSHA512");
                return sha512_HMAC.doFinal(data.getBytes(StandardCharsets.UTF_8));

    }


    public static String getNonce() {
        return String.valueOf(System.currentTimeMillis());
    }


}
