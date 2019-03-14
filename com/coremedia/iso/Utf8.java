package com.coremedia.iso;

import java.io.UnsupportedEncodingException;
import org.apache.http.protocol.HTTP;
/* loaded from: classes5.dex */
public final class Utf8 {
    public static byte[] convert(String str) {
        if (str != null) {
            try {
                return str.getBytes(HTTP.UTF_8);
            } catch (UnsupportedEncodingException e) {
                throw new Error(e);
            }
        }
        return null;
    }

    public static String convert(byte[] bArr) {
        if (bArr != null) {
            try {
                return new String(bArr, HTTP.UTF_8);
            } catch (UnsupportedEncodingException e) {
                throw new Error(e);
            }
        }
        return null;
    }

    public static int utf8StringLengthInBytes(String str) {
        if (str != null) {
            try {
                return str.getBytes(HTTP.UTF_8).length;
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException();
            }
        }
        return 0;
    }
}
