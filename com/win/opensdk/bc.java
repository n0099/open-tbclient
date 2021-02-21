package com.win.opensdk;

import android.text.TextUtils;
/* loaded from: classes3.dex */
public final class bc {
    public static byte[] abX(String str) {
        int length = str.length();
        byte[] bArr = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }

    public static String abU(String str) {
        return TextUtils.isEmpty(str) ? str : new aq(ap.java() + "4c6k", ap.eJe() + "o7my").hE(str, "CBC");
    }

    public static String abV(String str) {
        if (!TextUtils.isEmpty(str)) {
            String hE = an.hE(ap.a() + "mloo0ks9", str);
            if (!TextUtils.isEmpty(hE)) {
                hE = "KL_".concat(String.valueOf(hE));
            }
            return hE;
        }
        return str;
    }

    public static boolean c(String[] strArr, String str) {
        for (String str2 : strArr) {
            if (TextUtils.equals(str2, str)) {
                return true;
            }
        }
        return false;
    }
}
