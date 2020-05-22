package com.facebook.c;

import com.facebook.common.internal.g;
import java.io.UnsupportedEncodingException;
import org.apache.http.protocol.HTTP;
/* loaded from: classes13.dex */
public class e {
    public static byte[] PT(String str) {
        g.checkNotNull(str);
        try {
            return str.getBytes(HTTP.ASCII);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("ASCII not found!", e);
        }
    }

    public static boolean e(byte[] bArr, byte[] bArr2) {
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

    public static int c(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3 = 0;
        g.checkNotNull(bArr);
        g.checkNotNull(bArr2);
        if (i2 > i) {
            return -1;
        }
        byte b = bArr2[0];
        int i4 = i - i2;
        while (i3 <= i4) {
            if (bArr[i3] != b) {
                do {
                    i3++;
                    if (i3 > i4) {
                        break;
                    }
                } while (bArr[i3] != b);
            }
            if (i3 <= i4) {
                int i5 = i3 + 1;
                int i6 = (i5 + i2) - 1;
                for (int i7 = 1; i5 < i6 && bArr[i5] == bArr2[i7]; i7++) {
                    i5++;
                }
                if (i5 == i6) {
                    return i3;
                }
            }
            i3++;
        }
        return -1;
    }
}
