package com.coloros.mcssdk.c;

import android.util.Base64;
import java.nio.charset.Charset;
import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
/* loaded from: classes8.dex */
public abstract class c {
    public static String a(String str, String str2) {
        SecureRandom secureRandom = new SecureRandom();
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(1, a(str2), secureRandom);
        return new String(Base64.encode(cipher.doFinal(str.getBytes("UTF-8")), 0), Charset.defaultCharset()).trim();
    }

    private static Key a(String str) {
        return SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(Base64.decode(str, 0)));
    }

    public static String b(String str, String str2) {
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(2, a(str2));
        return new String(cipher.doFinal(Base64.decode(str, 0)), Charset.defaultCharset()).trim();
    }
}
