package com.coloros.mcssdk.c;

import android.text.TextUtils;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes8.dex */
public final class a {
    public static final String a = "AES/CBC/PKCS5Padding";
    public static final String b = "AES";
    public static final String c = "SHA1PRNG";
    public static final String d = "Crypto";
    public static final String e = "AndroidOpenSSL";
    public static final String f = "0123456789ABCDEF";
    public static final String g = "com.coloros.crypto.seed.defalut";
    public static byte[] h;

    static {
        try {
            h = c(g.getBytes(Charset.defaultCharset()), e);
        } catch (Exception e2) {
            e2.printStackTrace();
            d.b("getRawKey--Exception;" + e2.getMessage());
        }
    }

    private static String a(String str) {
        return b(str.getBytes(Charset.defaultCharset()));
    }

    private static String a(String str, String str2) {
        byte[] bArr = null;
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            bArr = a(a(str.getBytes(Charset.defaultCharset())), str2.getBytes(Charset.defaultCharset()));
        } catch (Exception e2) {
            e2.printStackTrace();
            try {
                bArr = a(c(str.getBytes(Charset.defaultCharset()), e), str2.getBytes(Charset.defaultCharset()));
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        return b(bArr);
    }

    private static String a(byte[] bArr, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return b(a(bArr, str.getBytes(Charset.defaultCharset())));
    }

    private static void a(StringBuffer stringBuffer, byte b2) {
        stringBuffer.append(f.charAt((b2 >> 4) & 15)).append(f.charAt(b2 & 15));
    }

    private static byte[] a(byte[] bArr) {
        SecureRandom secureRandom;
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        try {
            secureRandom = SecureRandom.getInstance(c, d);
        } catch (Exception e2) {
            secureRandom = SecureRandom.getInstance(c, e);
            d.a("getRawKey exception:" + e2.getMessage());
        }
        secureRandom.setSeed(bArr);
        keyGenerator.init(128, secureRandom);
        return keyGenerator.generateKey().getEncoded();
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, secretKeySpec, new IvParameterSpec(new byte[cipher.getBlockSize()]));
        return cipher.doFinal(bArr2);
    }

    private static String b(String str) {
        return new String(c(str), Charset.defaultCharset());
    }

    private static String b(String str, String str2) {
        byte[] bArr = null;
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            bArr = b(a(str.getBytes(Charset.defaultCharset())), c(str2));
        } catch (Exception e2) {
            try {
                bArr = b(c(str.getBytes(Charset.defaultCharset()), e), c(str2));
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        return new String(bArr, Charset.defaultCharset());
    }

    private static String b(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte b2 : bArr) {
            stringBuffer.append(f.charAt((b2 >> 4) & 15)).append(f.charAt(b2 & 15));
        }
        return stringBuffer.toString();
    }

    private static String b(byte[] bArr, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new String(b(bArr, c(str)), Charset.defaultCharset());
    }

    private static byte[] b(byte[] bArr, byte[] bArr2) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, secretKeySpec, new IvParameterSpec(new byte[cipher.getBlockSize()]));
        return cipher.doFinal(bArr2);
    }

    private static byte[] c(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = Integer.valueOf(str.substring(i * 2, (i * 2) + 2), 16).byteValue();
        }
        return bArr;
    }

    private static byte[] c(byte[] bArr, String str) {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        SecureRandom secureRandom = SecureRandom.getInstance(c, str);
        secureRandom.setSeed(bArr);
        keyGenerator.init(128, secureRandom);
        return keyGenerator.generateKey().getEncoded();
    }
}
