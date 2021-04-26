package com.coremedia.iso;

import java.io.UnsupportedEncodingException;
/* loaded from: classes6.dex */
public final class Utf8 {
    public static byte[] convert(String str) {
        if (str != null) {
            try {
                return str.getBytes("UTF-8");
            } catch (UnsupportedEncodingException e2) {
                throw new Error(e2);
            }
        }
        return null;
    }

    public static int utf8StringLengthInBytes(String str) {
        if (str != null) {
            try {
                return str.getBytes("UTF-8").length;
            } catch (UnsupportedEncodingException unused) {
                throw new RuntimeException();
            }
        }
        return 0;
    }

    public static String convert(byte[] bArr) {
        if (bArr != null) {
            try {
                return new String(bArr, "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                throw new Error(e2);
            }
        }
        return null;
    }
}
