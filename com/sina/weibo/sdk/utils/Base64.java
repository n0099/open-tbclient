package com.sina.weibo.sdk.utils;
/* loaded from: classes6.dex */
public final class Base64 {
    private static char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".toCharArray();
    private static byte[] codes = new byte[256];

    static {
        for (int i = 0; i < 256; i++) {
            codes[i] = -1;
        }
        for (int i2 = 65; i2 <= 90; i2++) {
            codes[i2] = (byte) (i2 - 65);
        }
        for (int i3 = 97; i3 <= 122; i3++) {
            codes[i3] = (byte) ((i3 + 26) - 97);
        }
        for (int i4 = 48; i4 <= 57; i4++) {
            codes[i4] = (byte) ((i4 + 52) - 48);
        }
        codes[43] = 62;
        codes[47] = 63;
    }

    public static byte[] decode(byte[] bArr) {
        int i;
        int length = ((bArr.length + 3) / 4) * 3;
        if (bArr.length > 0 && bArr[bArr.length - 1] == 61) {
            length--;
        }
        if (bArr.length > 1 && bArr[bArr.length - 2] == 61) {
            length--;
        }
        byte[] bArr2 = new byte[length];
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i2 < bArr.length) {
            byte b2 = codes[bArr[i2] & 255];
            if (b2 >= 0) {
                i5 += 6;
                i4 = (i4 << 6) | b2;
                if (i5 >= 8) {
                    i5 -= 8;
                    i = i3 + 1;
                    bArr2[i3] = (byte) ((i4 >> i5) & 255);
                    i2++;
                    i3 = i;
                }
            }
            i = i3;
            i2++;
            i3 = i;
        }
        if (i3 != bArr2.length) {
            throw new RuntimeException("miscalculated data length!");
        }
        return bArr2;
    }

    public static char[] encode(byte[] bArr) {
        boolean z;
        boolean z2;
        char[] cArr = new char[((bArr.length + 2) / 3) * 4];
        int i = 0;
        int i2 = 0;
        while (i2 < bArr.length) {
            int i3 = (bArr[i2] & 255) << 8;
            if (i2 + 1 < bArr.length) {
                i3 |= bArr[i2 + 1] & 255;
                z = true;
            } else {
                z = false;
            }
            int i4 = i3 << 8;
            if (i2 + 2 < bArr.length) {
                i4 |= bArr[i2 + 2] & 255;
                z2 = true;
            } else {
                z2 = false;
            }
            cArr[i + 3] = alphabet[z2 ? i4 & 63 : 64];
            int i5 = i4 >> 6;
            cArr[i + 2] = alphabet[z ? i5 & 63 : 64];
            int i6 = i5 >> 6;
            cArr[i + 1] = alphabet[i6 & 63];
            cArr[i + 0] = alphabet[(i6 >> 6) & 63];
            i2 += 3;
            i += 4;
        }
        return cArr;
    }

    public static byte[] encodebyte(byte[] bArr) {
        boolean z;
        boolean z2;
        byte[] bArr2 = new byte[((bArr.length + 2) / 3) * 4];
        int i = 0;
        int i2 = 0;
        while (i2 < bArr.length) {
            int i3 = (bArr[i2] & 255) << 8;
            if (i2 + 1 < bArr.length) {
                i3 |= bArr[i2 + 1] & 255;
                z = true;
            } else {
                z = false;
            }
            int i4 = i3 << 8;
            if (i2 + 2 < bArr.length) {
                i4 |= bArr[i2 + 2] & 255;
                z2 = true;
            } else {
                z2 = false;
            }
            bArr2[i + 3] = (byte) alphabet[z2 ? i4 & 63 : 64];
            int i5 = i4 >> 6;
            bArr2[i + 2] = (byte) alphabet[z ? i5 & 63 : 64];
            int i6 = i5 >> 6;
            bArr2[i + 1] = (byte) alphabet[i6 & 63];
            bArr2[i + 0] = (byte) alphabet[(i6 >> 6) & 63];
            i2 += 3;
            i += 4;
        }
        return bArr2;
    }
}
