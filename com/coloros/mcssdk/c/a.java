package com.coloros.mcssdk.c;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
/* loaded from: classes2.dex */
public final class a {
    private static String a() {
        byte[] c = c("com.nearme.mcs");
        int length = c.length % 2 == 0 ? c.length : c.length - 1;
        for (int i = 0; i < length; i += 2) {
            byte b = c[i];
            c[i] = c[i + 1];
            c[i + 1] = b;
        }
        return c != null ? new String(c, Charset.forName("UTF-8")) : "";
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return b.b(str, a());
        } catch (Exception e) {
            c.b("desDecrypt-" + e.getMessage());
            return "";
        }
    }

    private static byte[] c(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            return new byte[0];
        }
    }
}
