package com.coremedia.iso;

import java.io.UnsupportedEncodingException;
/* loaded from: classes5.dex */
public final class Ascii {
    public static byte[] convert(String str) {
        if (str != null) {
            try {
                return str.getBytes("us-ascii");
            } catch (UnsupportedEncodingException e2) {
                throw new Error(e2);
            }
        }
        return null;
    }

    public static String convert(byte[] bArr) {
        if (bArr != null) {
            try {
                return new String(bArr, "us-ascii");
            } catch (UnsupportedEncodingException e2) {
                throw new Error(e2);
            }
        }
        return null;
    }
}
