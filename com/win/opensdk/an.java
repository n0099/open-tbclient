package com.win.opensdk;

import android.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes3.dex */
public final class an {
    public static String hC(String str, String str2) {
        if (abE(str) || abE(str2)) {
            return "";
        }
        byte[] bytes = str.getBytes("utf-8");
        byte[] bArr = new byte[16];
        for (int i = 0; i < bytes.length && i < 16; i++) {
            bArr[i] = bytes[i];
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, com.baidu.sapi2.utils.e.q);
        Cipher cipher = Cipher.getInstance(com.baidu.sapi2.utils.e.q);
        cipher.init(1, secretKeySpec);
        return Base64.encodeToString(cipher.doFinal(str2.getBytes("utf-8")), 2);
    }

    private static boolean abE(String str) {
        return str == null || str.length() == 0;
    }
}
