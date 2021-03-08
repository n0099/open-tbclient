package com.sdk.base.framework.f.j;

import com.baidu.android.imsdk.internal.Constants;
import com.sdk.base.framework.c.f;
/* loaded from: classes4.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f7652a;
    private static final byte[] b;

    static {
        c.class.getName();
        Boolean.valueOf(f.b);
        f7652a = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
        b = new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 63, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, 0, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Constants.GZIP_CAST_TYPE, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};
    }

    private c() {
    }

    public static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer(((bArr.length - 1) / 3) << 6);
        int i = 0;
        for (int i2 = 0; i2 < bArr.length; i2++) {
            i |= (bArr[i2] << (16 - ((i2 % 3) << 3))) & (255 << (16 - ((i2 % 3) << 3)));
            if (i2 % 3 == 2 || i2 == bArr.length - 1) {
                stringBuffer.append(f7652a[(16515072 & i) >>> 18]);
                stringBuffer.append(f7652a[(258048 & i) >>> 12]);
                stringBuffer.append(f7652a[(i & 4032) >>> 6]);
                stringBuffer.append(f7652a[i & 63]);
                i = 0;
            }
        }
        if (bArr.length % 3 > 0) {
            stringBuffer.setCharAt(stringBuffer.length() - 1, '=');
        }
        if (bArr.length % 3 == 1) {
            stringBuffer.setCharAt(stringBuffer.length() - 2, '=');
        }
        return stringBuffer.toString();
    }

    public static byte[] a(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length % 4 != 0) {
            throw new IllegalArgumentException("Base64 string length must be 4*n");
        }
        if (str.length() == 0) {
            return new byte[0];
        }
        int i = str.charAt(length + (-1)) == '=' ? 1 : 0;
        if (str.charAt(length - 2) == '=') {
            i++;
        }
        int i2 = ((length / 4) * 3) - i;
        byte[] bArr = new byte[i2];
        for (int i3 = 0; i3 < length; i3 += 4) {
            int i4 = (i3 / 4) * 3;
            int i5 = (b[str.charAt(i3)] << 18) | (b[str.charAt(i3 + 1)] << 12) | (b[str.charAt(i3 + 2)] << 6) | b[str.charAt(i3 + 3)];
            bArr[i4] = (byte) ((i5 >> 16) & 255);
            if (i3 < length - 4) {
                bArr[i4 + 1] = (byte) ((i5 >> 8) & 255);
                bArr[i4 + 2] = (byte) i5;
            } else {
                if (i4 + 1 < i2) {
                    bArr[i4 + 1] = (byte) ((i5 >> 8) & 255);
                }
                if (i4 + 2 < i2) {
                    bArr[i4 + 2] = (byte) i5;
                }
            }
        }
        return bArr;
    }
}
