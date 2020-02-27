package com.coremedia.iso;

import java.io.ByteArrayOutputStream;
/* loaded from: classes7.dex */
public class Hex {
    private static final char[] DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String encodeHex(byte[] bArr) {
        return encodeHex(bArr, 0);
    }

    public static String encodeHex(byte[] bArr, int i) {
        int i2;
        int i3 = 0;
        int length = bArr.length;
        char[] cArr = new char[(i > 0 ? length / i : 0) + (length << 1)];
        for (int i4 = 0; i4 < length; i4++) {
            if (i <= 0 || i4 % i != 0 || i3 <= 0) {
                i2 = i3;
            } else {
                i2 = i3 + 1;
                cArr[i3] = '-';
            }
            int i5 = i2 + 1;
            cArr[i2] = DIGITS[(bArr[i4] & 240) >>> 4];
            i3 = i5 + 1;
            cArr[i5] = DIGITS[bArr[i4] & 15];
        }
        return new String(cArr);
    }

    public static byte[] decodeHex(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i = 0; i < str.length(); i += 2) {
            byteArrayOutputStream.write(Integer.parseInt(str.substring(i, i + 2), 16));
        }
        return byteArrayOutputStream.toByteArray();
    }
}
