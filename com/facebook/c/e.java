package com.facebook.c;

import com.facebook.common.internal.g;
import java.io.UnsupportedEncodingException;
import org.apache.http.protocol.HTTP;
/* loaded from: classes2.dex */
public class e {
    public static byte[] yz(String str) {
        g.checkNotNull(str);
        try {
            return str.getBytes(HTTP.ASCII);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("ASCII not found!", e);
        }
    }

    public static boolean c(byte[] bArr, byte[] bArr2) {
        g.checkNotNull(bArr);
        g.checkNotNull(bArr2);
        if (bArr2.length > bArr.length) {
            return false;
        }
        for (int i = 0; i < bArr2.length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }
}
