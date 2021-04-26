package com.facebook.imageformat;

import com.facebook.common.internal.Preconditions;
import java.io.UnsupportedEncodingException;
import org.apache.http.protocol.HTTP;
/* loaded from: classes6.dex */
public class ImageFormatCheckerUtils {
    public static byte[] asciiBytes(String str) {
        Preconditions.checkNotNull(str);
        try {
            return str.getBytes(HTTP.ASCII);
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("ASCII not found!", e2);
        }
    }

    public static int indexOfPattern(byte[] bArr, int i2, byte[] bArr2, int i3) {
        Preconditions.checkNotNull(bArr);
        Preconditions.checkNotNull(bArr2);
        if (i3 > i2) {
            return -1;
        }
        int i4 = 0;
        byte b2 = bArr2[0];
        int i5 = i2 - i3;
        while (i4 <= i5) {
            if (bArr[i4] != b2) {
                do {
                    i4++;
                    if (i4 > i5) {
                        break;
                    }
                } while (bArr[i4] != b2);
            }
            if (i4 <= i5) {
                int i6 = i4 + 1;
                int i7 = (i6 + i3) - 1;
                for (int i8 = 1; i6 < i7 && bArr[i6] == bArr2[i8]; i8++) {
                    i6++;
                }
                if (i6 == i7) {
                    return i4;
                }
            }
            i4++;
        }
        return -1;
    }

    public static boolean startsWithPattern(byte[] bArr, byte[] bArr2) {
        Preconditions.checkNotNull(bArr);
        Preconditions.checkNotNull(bArr2);
        if (bArr2.length > bArr.length) {
            return false;
        }
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }
}
