package kascend.core.utils;
/* loaded from: classes5.dex */
public class b {
    private static final byte[] nOX = new byte[128];
    private static final char[] nOY = new char[64];

    static {
        int i = 0;
        for (int i2 = 0; i2 < 128; i2++) {
            nOX[i2] = -1;
        }
        for (int i3 = 90; i3 >= 65; i3--) {
            nOX[i3] = (byte) (i3 - 65);
        }
        for (int i4 = 122; i4 >= 97; i4--) {
            nOX[i4] = (byte) ((i4 - 97) + 26);
        }
        for (int i5 = 57; i5 >= 48; i5--) {
            nOX[i5] = (byte) ((i5 - 48) + 52);
        }
        nOX[43] = 62;
        nOX[47] = 63;
        for (int i6 = 0; i6 <= 25; i6++) {
            nOY[i6] = (char) (i6 + 65);
        }
        int i7 = 26;
        int i8 = 0;
        while (i7 <= 51) {
            nOY[i7] = (char) (i8 + 97);
            i7++;
            i8++;
        }
        int i9 = 52;
        while (i9 <= 61) {
            nOY[i9] = (char) (i + 48);
            i9++;
            i++;
        }
        nOY[62] = '+';
        nOY[63] = '/';
    }

    public static byte[] decode(String str) throws Exception {
        return Sp(str);
    }

    public static byte[] Sp(String str) {
        if (str == null) {
            return null;
        }
        char[] charArray = str.toCharArray();
        int b = b(charArray);
        if (b % 4 == 0) {
            int i = b / 4;
            if (i == 0) {
                return new byte[0];
            }
            byte[] bArr = new byte[i * 3];
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (i4 < i - 1) {
                int i5 = i2 + 1;
                char c = charArray[i2];
                if (!l(c)) {
                    return null;
                }
                int i6 = i5 + 1;
                char c2 = charArray[i5];
                if (!l(c2)) {
                    return null;
                }
                int i7 = i6 + 1;
                char c3 = charArray[i6];
                if (!l(c3)) {
                    return null;
                }
                i2 = i7 + 1;
                char c4 = charArray[i7];
                if (!l(c4)) {
                    return null;
                }
                byte b2 = nOX[c];
                byte b3 = nOX[c2];
                byte b4 = nOX[c3];
                byte b5 = nOX[c4];
                int i8 = i3 + 1;
                bArr[i3] = (byte) ((b2 << 2) | (b3 >> 4));
                int i9 = i8 + 1;
                bArr[i8] = (byte) (((b3 & 15) << 4) | ((b4 >> 2) & 15));
                i3 = i9 + 1;
                bArr[i9] = (byte) ((b4 << 6) | b5);
                i4++;
            }
            int i10 = i2 + 1;
            char c5 = charArray[i2];
            if (l(c5)) {
                int i11 = i10 + 1;
                char c6 = charArray[i10];
                if (l(c6)) {
                    byte b6 = nOX[c5];
                    byte b7 = nOX[c6];
                    int i12 = i11 + 1;
                    char c7 = charArray[i11];
                    int i13 = i12 + 1;
                    char c8 = charArray[i12];
                    if (!l(c7) || !l(c8)) {
                        if (k(c7) && k(c8)) {
                            if ((b7 & 15) == 0) {
                                byte[] bArr2 = new byte[(i4 * 3) + 1];
                                System.arraycopy(bArr, 0, bArr2, 0, i4 * 3);
                                bArr2[i3] = (byte) ((b6 << 2) | (b7 >> 4));
                                return bArr2;
                            }
                            return null;
                        } else if (k(c7) || !k(c8)) {
                            return null;
                        } else {
                            byte b8 = nOX[c7];
                            if ((b8 & 3) == 0) {
                                byte[] bArr3 = new byte[(i4 * 3) + 2];
                                System.arraycopy(bArr, 0, bArr3, 0, i4 * 3);
                                bArr3[i3] = (byte) ((b6 << 2) | (b7 >> 4));
                                bArr3[i3 + 1] = (byte) (((b7 & 15) << 4) | ((b8 >> 2) & 15));
                                return bArr3;
                            }
                            return null;
                        }
                    }
                    byte b9 = nOX[c7];
                    byte b10 = nOX[c8];
                    int i14 = i3 + 1;
                    bArr[i3] = (byte) ((b6 << 2) | (b7 >> 4));
                    int i15 = i14 + 1;
                    bArr[i14] = (byte) (((b7 & 15) << 4) | ((b9 >> 2) & 15));
                    int i16 = i15 + 1;
                    bArr[i15] = (byte) ((b9 << 6) | b10);
                    return bArr;
                }
                return null;
            }
            return null;
        }
        return null;
    }

    private static int b(char[] cArr) {
        int i;
        int i2 = 0;
        if (cArr != null) {
            int length = cArr.length;
            int i3 = 0;
            while (i3 < length) {
                if (j(cArr[i3])) {
                    i = i2;
                } else {
                    i = i2 + 1;
                    cArr[i2] = cArr[i3];
                }
                i3++;
                i2 = i;
            }
        }
        return i2;
    }

    private static boolean j(char c) {
        return c == ' ' || c == '\r' || c == '\n' || c == '\t';
    }

    private static boolean k(char c) {
        return c == '=';
    }

    private static boolean l(char c) {
        return c < 128 && nOX[c] != -1;
    }
}
