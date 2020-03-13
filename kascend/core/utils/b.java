package kascend.core.utils;
/* loaded from: classes5.dex */
public class b {
    private static final byte[] nBJ = new byte[128];
    private static final char[] nBK = new char[64];

    static {
        int i = 0;
        for (int i2 = 0; i2 < 128; i2++) {
            nBJ[i2] = -1;
        }
        for (int i3 = 90; i3 >= 65; i3--) {
            nBJ[i3] = (byte) (i3 - 65);
        }
        for (int i4 = 122; i4 >= 97; i4--) {
            nBJ[i4] = (byte) ((i4 - 97) + 26);
        }
        for (int i5 = 57; i5 >= 48; i5--) {
            nBJ[i5] = (byte) ((i5 - 48) + 52);
        }
        nBJ[43] = 62;
        nBJ[47] = 63;
        for (int i6 = 0; i6 <= 25; i6++) {
            nBK[i6] = (char) (i6 + 65);
        }
        int i7 = 26;
        int i8 = 0;
        while (i7 <= 51) {
            nBK[i7] = (char) (i8 + 97);
            i7++;
            i8++;
        }
        int i9 = 52;
        while (i9 <= 61) {
            nBK[i9] = (char) (i + 48);
            i9++;
            i++;
        }
        nBK[62] = '+';
        nBK[63] = '/';
    }

    public static byte[] decode(String str) throws Exception {
        return Se(str);
    }

    public static byte[] Se(String str) {
        if (str == null) {
            return null;
        }
        char[] charArray = str.toCharArray();
        int f = f(charArray);
        if (f % 4 == 0) {
            int i = f / 4;
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
                if (!r(c)) {
                    return null;
                }
                int i6 = i5 + 1;
                char c2 = charArray[i5];
                if (!r(c2)) {
                    return null;
                }
                int i7 = i6 + 1;
                char c3 = charArray[i6];
                if (!r(c3)) {
                    return null;
                }
                i2 = i7 + 1;
                char c4 = charArray[i7];
                if (!r(c4)) {
                    return null;
                }
                byte b = nBJ[c];
                byte b2 = nBJ[c2];
                byte b3 = nBJ[c3];
                byte b4 = nBJ[c4];
                int i8 = i3 + 1;
                bArr[i3] = (byte) ((b << 2) | (b2 >> 4));
                int i9 = i8 + 1;
                bArr[i8] = (byte) (((b2 & 15) << 4) | ((b3 >> 2) & 15));
                i3 = i9 + 1;
                bArr[i9] = (byte) ((b3 << 6) | b4);
                i4++;
            }
            int i10 = i2 + 1;
            char c5 = charArray[i2];
            if (r(c5)) {
                int i11 = i10 + 1;
                char c6 = charArray[i10];
                if (r(c6)) {
                    byte b5 = nBJ[c5];
                    byte b6 = nBJ[c6];
                    int i12 = i11 + 1;
                    char c7 = charArray[i11];
                    int i13 = i12 + 1;
                    char c8 = charArray[i12];
                    if (!r(c7) || !r(c8)) {
                        if (q(c7) && q(c8)) {
                            if ((b6 & 15) == 0) {
                                byte[] bArr2 = new byte[(i4 * 3) + 1];
                                System.arraycopy(bArr, 0, bArr2, 0, i4 * 3);
                                bArr2[i3] = (byte) ((b5 << 2) | (b6 >> 4));
                                return bArr2;
                            }
                            return null;
                        } else if (q(c7) || !q(c8)) {
                            return null;
                        } else {
                            byte b7 = nBJ[c7];
                            if ((b7 & 3) == 0) {
                                byte[] bArr3 = new byte[(i4 * 3) + 2];
                                System.arraycopy(bArr, 0, bArr3, 0, i4 * 3);
                                bArr3[i3] = (byte) ((b5 << 2) | (b6 >> 4));
                                bArr3[i3 + 1] = (byte) (((b6 & 15) << 4) | ((b7 >> 2) & 15));
                                return bArr3;
                            }
                            return null;
                        }
                    }
                    byte b8 = nBJ[c7];
                    byte b9 = nBJ[c8];
                    int i14 = i3 + 1;
                    bArr[i3] = (byte) ((b5 << 2) | (b6 >> 4));
                    int i15 = i14 + 1;
                    bArr[i14] = (byte) (((b6 & 15) << 4) | ((b8 >> 2) & 15));
                    int i16 = i15 + 1;
                    bArr[i15] = (byte) ((b8 << 6) | b9);
                    return bArr;
                }
                return null;
            }
            return null;
        }
        return null;
    }

    private static int f(char[] cArr) {
        int i;
        int i2 = 0;
        if (cArr != null) {
            int length = cArr.length;
            int i3 = 0;
            while (i3 < length) {
                if (p(cArr[i3])) {
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

    private static boolean p(char c) {
        return c == ' ' || c == '\r' || c == '\n' || c == '\t';
    }

    private static boolean q(char c) {
        return c == '=';
    }

    private static boolean r(char c) {
        return c < 128 && nBJ[c] != -1;
    }
}
