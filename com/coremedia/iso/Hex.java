package com.coremedia.iso;

import java.io.ByteArrayOutputStream;
/* loaded from: classes6.dex */
public class Hex {
    public static final char[] DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static byte[] decodeHex(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i2 = 0;
        while (i2 < str.length()) {
            int i3 = i2 + 2;
            byteArrayOutputStream.write(Integer.parseInt(str.substring(i2, i3), 16));
            i2 = i3;
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static String encodeHex(byte[] bArr) {
        return encodeHex(bArr, 0);
    }

    public static String encodeHex(byte[] bArr, int i2) {
        int length = bArr.length;
        char[] cArr = new char[(length << 1) + (i2 > 0 ? length / i2 : 0)];
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            if (i2 > 0 && i4 % i2 == 0 && i3 > 0) {
                cArr[i3] = '-';
                i3++;
            }
            int i5 = i3 + 1;
            char[] cArr2 = DIGITS;
            cArr[i3] = cArr2[(bArr[i4] & 240) >>> 4];
            i3 = i5 + 1;
            cArr[i5] = cArr2[bArr[i4] & 15];
        }
        return new String(cArr);
    }
}
