package com.yy.hiidostatis.inner.util.cipher;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
/* loaded from: classes8.dex */
public final class Coder {
    public static final String CHARSET = "UTF-8";
    public static final String KEY_DES = "DES";
    public static final String KEY_MD5 = "MD5";
    public static final String KEY_SHA = "SHA";

    public static byte[] StringToBytes(String str) throws UnsupportedEncodingException {
        return str.getBytes("UTF-8");
    }

    public static String bytesToHexString(byte[] bArr) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        if (bArr != null) {
            for (byte b : bArr) {
                sb.append(Integer.toString((b & 255) + 256, 16).substring(1));
            }
        }
        return sb.toString();
    }

    public static String bytesToString(byte[] bArr) throws UnsupportedEncodingException {
        return new String(bArr, "UTF-8");
    }

    public static String decryptBASE64(String str) throws Exception {
        return bytesToString(Base64Util.decode(str));
    }

    public static String encryptBASE64(String str) throws Exception {
        return Base64Util.encode(StringToBytes(str));
    }

    public static String encryptMD5(String str) throws Exception {
        return bytesToHexString(MessageDigest.getInstance("MD5").digest(StringToBytes(str)));
    }

    public static String encryptSHA(String str) throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA");
        messageDigest.update(StringToBytes(str));
        return bytesToHexString(messageDigest.digest());
    }

    public static byte[] hexStringToBytes(String str) {
        char[] charArray = str.toCharArray();
        int length = charArray.length / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            int digit = Character.digit(charArray[i2 + 1], 16) | (Character.digit(charArray[i2], 16) << 4);
            if (digit > 127) {
                digit -= 256;
            }
            bArr[i] = (byte) digit;
        }
        return bArr;
    }

    public static String sha256Encrypt(String str) {
        byte[] bytes = str.getBytes();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(bytes);
            return bytesToHexString(messageDigest.digest());
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static String decryptDES(String str, String str2) throws Exception {
        if (str == null) {
            return null;
        }
        return bytesToString(decryptDES(Base64Util.decode(str), StringToBytes(str2)));
    }

    public static String encryptDES(String str, String str2) throws Exception {
        return Base64Util.encode(encryptDES(StringToBytes(str), StringToBytes(str2)));
    }

    public static byte[] decryptDES(byte[] bArr, byte[] bArr2) throws Exception {
        SecureRandom secureRandom = new SecureRandom();
        SecretKey generateSecret = SecretKeyFactory.getInstance(KEY_DES).generateSecret(new DESKeySpec(bArr2));
        Cipher cipher = Cipher.getInstance(KEY_DES);
        cipher.init(2, generateSecret, secureRandom);
        return cipher.doFinal(bArr);
    }

    public static byte[] encryptDES(byte[] bArr, byte[] bArr2) throws Exception {
        SecureRandom secureRandom = new SecureRandom();
        SecretKey generateSecret = SecretKeyFactory.getInstance(KEY_DES).generateSecret(new DESKeySpec(bArr2));
        Cipher cipher = Cipher.getInstance(KEY_DES);
        cipher.init(1, generateSecret, secureRandom);
        return cipher.doFinal(bArr);
    }
}
