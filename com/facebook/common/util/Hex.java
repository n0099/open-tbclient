package com.facebook.common.util;
/* loaded from: classes6.dex */
public class Hex {
    public static final byte[] DIGITS;
    public static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public static final char[] FIRST_CHAR = new char[256];
    public static final char[] SECOND_CHAR = new char[256];

    static {
        for (int i2 = 0; i2 < 256; i2++) {
            char[] cArr = FIRST_CHAR;
            char[] cArr2 = HEX_DIGITS;
            cArr[i2] = cArr2[(i2 >> 4) & 15];
            SECOND_CHAR[i2] = cArr2[i2 & 15];
        }
        DIGITS = new byte[103];
        for (int i3 = 0; i3 <= 70; i3++) {
            DIGITS[i3] = -1;
        }
        for (byte b2 = 0; b2 < 10; b2 = (byte) (b2 + 1)) {
            DIGITS[b2 + 48] = b2;
        }
        for (byte b3 = 0; b3 < 6; b3 = (byte) (b3 + 1)) {
            byte[] bArr = DIGITS;
            byte b4 = (byte) (b3 + 10);
            bArr[b3 + 65] = b4;
            bArr[b3 + 97] = b4;
        }
    }

    public static String byte2Hex(int i2) {
        if (i2 <= 255 && i2 >= 0) {
            return String.valueOf(FIRST_CHAR[i2]) + String.valueOf(SECOND_CHAR[i2]);
        }
        throw new IllegalArgumentException("The int converting to hex should be in range 0~255");
    }

    public static byte[] decodeHex(String str) {
        byte b2;
        byte b3;
        int length = str.length();
        if ((length & 1) == 0) {
            byte[] bArr = new byte[length >> 1];
            boolean z = false;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                int i4 = i2 + 1;
                char charAt = str.charAt(i2);
                if (charAt <= 'f' && (b2 = DIGITS[charAt]) != -1) {
                    int i5 = i4 + 1;
                    char charAt2 = str.charAt(i4);
                    if (charAt2 <= 'f' && (b3 = DIGITS[charAt2]) != -1) {
                        bArr[i3] = (byte) ((b2 << 4) | b3);
                        i3++;
                        i2 = i5;
                    }
                }
                z = true;
            }
            if (z) {
                throw new IllegalArgumentException("Invalid hexadecimal digit: " + str);
            }
            return bArr;
        }
        throw new IllegalArgumentException("Odd number of characters.");
    }

    public static String encodeHex(byte[] bArr, boolean z) {
        int i2;
        char[] cArr = new char[bArr.length * 2];
        int i3 = 0;
        for (int i4 = 0; i4 < bArr.length && ((i2 = bArr[i4] & 255) != 0 || !z); i4++) {
            int i5 = i3 + 1;
            cArr[i3] = FIRST_CHAR[i2];
            i3 = i5 + 1;
            cArr[i5] = SECOND_CHAR[i2];
        }
        return new String(cArr, 0, i3);
    }

    public static byte[] hexStringToByteArray(String str) {
        return decodeHex(str.replaceAll(" ", ""));
    }
}
