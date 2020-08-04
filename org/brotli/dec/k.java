package org.brotli.dec;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes4.dex */
final class k {
    static final k[] oig = {new k("", 0, ""), new k("", 0, " "), new k(" ", 0, " "), new k("", 12, ""), new k("", 10, " "), new k("", 0, " the "), new k(" ", 0, ""), new k("s ", 0, " "), new k("", 0, " of "), new k("", 10, ""), new k("", 0, " and "), new k("", 13, ""), new k("", 1, ""), new k(", ", 0, " "), new k("", 0, ", "), new k(" ", 10, " "), new k("", 0, " in "), new k("", 0, " to "), new k("e ", 0, " "), new k("", 0, "\""), new k("", 0, "."), new k("", 0, "\">"), new k("", 0, "\n"), new k("", 3, ""), new k("", 0, "]"), new k("", 0, " for "), new k("", 14, ""), new k("", 2, ""), new k("", 0, " a "), new k("", 0, " that "), new k(" ", 10, ""), new k("", 0, ". "), new k(".", 0, ""), new k(" ", 0, ", "), new k("", 15, ""), new k("", 0, " with "), new k("", 0, "'"), new k("", 0, " from "), new k("", 0, " by "), new k("", 16, ""), new k("", 17, ""), new k(" the ", 0, ""), new k("", 4, ""), new k("", 0, ". The "), new k("", 11, ""), new k("", 0, " on "), new k("", 0, " as "), new k("", 0, " is "), new k("", 7, ""), new k("", 1, "ing "), new k("", 0, "\n\t"), new k("", 0, ":"), new k(" ", 0, ". "), new k("", 0, "ed "), new k("", 20, ""), new k("", 18, ""), new k("", 6, ""), new k("", 0, "("), new k("", 10, ", "), new k("", 8, ""), new k("", 0, " at "), new k("", 0, "ly "), new k(" the ", 0, " of "), new k("", 5, ""), new k("", 9, ""), new k(" ", 10, ", "), new k("", 10, "\""), new k(".", 0, "("), new k("", 11, " "), new k("", 10, "\">"), new k("", 0, "=\""), new k(" ", 0, "."), new k(".com/", 0, ""), new k(" the ", 0, " of the "), new k("", 10, "'"), new k("", 0, ". This "), new k("", 0, Constants.ACCEPT_TIME_SEPARATOR_SP), new k(".", 0, " "), new k("", 10, "("), new k("", 10, "."), new k("", 0, " not "), new k(" ", 0, "=\""), new k("", 0, "er "), new k(" ", 11, " "), new k("", 0, "al "), new k(" ", 11, ""), new k("", 0, "='"), new k("", 11, "\""), new k("", 10, ". "), new k(" ", 0, "("), new k("", 0, "ful "), new k(" ", 10, ". "), new k("", 0, "ive "), new k("", 0, "less "), new k("", 11, "'"), new k("", 0, "est "), new k(" ", 10, "."), new k("", 11, "\">"), new k(" ", 0, "='"), new k("", 10, Constants.ACCEPT_TIME_SEPARATOR_SP), new k("", 0, "ize "), new k("", 11, "."), new k("Â ", 0, ""), new k(" ", 0, Constants.ACCEPT_TIME_SEPARATOR_SP), new k("", 10, "=\""), new k("", 11, "=\""), new k("", 0, "ous "), new k("", 11, ", "), new k("", 10, "='"), new k(" ", 10, Constants.ACCEPT_TIME_SEPARATOR_SP), new k(" ", 11, "=\""), new k(" ", 11, ", "), new k("", 11, Constants.ACCEPT_TIME_SEPARATOR_SP), new k("", 11, "("), new k("", 11, ". "), new k(" ", 11, "."), new k("", 11, "='"), new k(" ", 11, ". "), new k(" ", 10, "=\""), new k(" ", 11, "='"), new k(" ", 10, "='")};
    private final byte[] oie;
    private final byte[] oif;
    private final int type;

    k(String str, int i, String str2) {
        this.oie = To(str);
        this.type = i;
        this.oif = To(str2);
    }

    static byte[] To(String str) {
        byte[] bArr = new byte[str.length()];
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) str.charAt(i);
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(byte[] bArr, int i, byte[] bArr2, int i2, int i3, k kVar) {
        byte[] bArr3 = kVar.oie;
        int length = bArr3.length;
        int i4 = 0;
        int i5 = i;
        while (i4 < length) {
            bArr[i5] = bArr3[i4];
            i4++;
            i5++;
        }
        int i6 = kVar.type;
        int LJ = m.LJ(i6);
        if (LJ > i3) {
            LJ = i3;
        }
        int i7 = i2 + LJ;
        int LK = (i3 - LJ) - m.LK(i6);
        int i8 = i5;
        int i9 = i7;
        int i10 = LK;
        while (i10 > 0) {
            bArr[i8] = bArr2[i9];
            i10--;
            i9++;
            i8++;
        }
        if (i6 == 11 || i6 == 10) {
            int i11 = i8 - LK;
            if (i6 == 10) {
                LK = 1;
            }
            while (LK > 0) {
                int i12 = bArr[i11] & 255;
                if (i12 < 192) {
                    if (i12 >= 97 && i12 <= 122) {
                        bArr[i11] = (byte) (bArr[i11] ^ 32);
                    }
                    i11++;
                    LK--;
                } else if (i12 < 224) {
                    int i13 = i11 + 1;
                    bArr[i13] = (byte) (bArr[i13] ^ 32);
                    i11 += 2;
                    LK -= 2;
                } else {
                    int i14 = i11 + 2;
                    bArr[i14] = (byte) (bArr[i14] ^ 5);
                    i11 += 3;
                    LK -= 3;
                }
            }
        }
        byte[] bArr4 = kVar.oif;
        int length2 = bArr4.length;
        int i15 = i8;
        int i16 = 0;
        while (i16 < length2) {
            bArr[i15] = bArr4[i16];
            i16++;
            i15++;
        }
        return i15 - i;
    }
}
