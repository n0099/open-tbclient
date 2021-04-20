package com.cmic.sso.sdk.d;

import android.util.Base64;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes5.dex */
public class a {
    public static String a(byte[] bArr, String str) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, secretKeySpec, new IvParameterSpec(new byte[cipher.getBlockSize()]));
            return Base64.encodeToString(cipher.doFinal(str.getBytes("utf-8")), 0);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String b(byte[] bArr, String str) {
        try {
            byte[] decode = Base64.decode(str, 0);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, new IvParameterSpec(new byte[cipher.getBlockSize()]));
            return new String(cipher.doFinal(decode), "utf-8");
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static byte[] a() {
        byte[] bArr = new byte[16];
        new SecureRandom().nextBytes(bArr);
        return bArr;
    }
}
