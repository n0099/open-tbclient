package com.coloros.mcssdk.c;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Locale;
import org.apache.http.protocol.HTTP;
/* loaded from: classes3.dex */
public final class b {
    public static final String a = "com.nearme.mcs";

    private static String a() {
        byte[] c = c(a);
        int length = c.length % 2 == 0 ? c.length : c.length - 1;
        for (int i = 0; i < length; i += 2) {
            byte b = c[i];
            c[i] = c[i + 1];
            c[i + 1] = b;
        }
        return c != null ? new String(c, Charset.forName(HTTP.UTF_8)) : "";
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return c.b(str, a());
        } catch (Exception e) {
            d.b("desDecrypt-" + e.getMessage());
            return "";
        }
    }

    private static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                hexString = "0" + hexString;
            }
            sb.append(hexString.toUpperCase(Locale.getDefault()));
        }
        return sb.toString();
    }

    private static byte[] b(String str) {
        if (str.length() <= 0) {
            return null;
        }
        byte[] bArr = new byte[str.length() / 2];
        for (int i = 0; i < str.length() / 2; i++) {
            bArr[i] = (byte) ((Integer.parseInt(str.substring(i * 2, (i * 2) + 1), 16) * 16) + Integer.parseInt(str.substring((i * 2) + 1, (i * 2) + 2), 16));
        }
        return bArr;
    }

    private static byte[] b(byte[] bArr) {
        int length = bArr.length % 2 == 0 ? bArr.length : bArr.length - 1;
        for (int i = 0; i < length; i += 2) {
            byte b = bArr[i];
            bArr[i] = bArr[i + 1];
            bArr[i + 1] = b;
        }
        return bArr;
    }

    private static byte[] c(String str) {
        try {
            return str.getBytes(HTTP.UTF_8);
        } catch (UnsupportedEncodingException e) {
            return new byte[0];
        }
    }

    private static String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return c.a(str, a());
        } catch (Exception e) {
            d.b("desEncrypt-" + e.getMessage());
            return "";
        }
    }
}
