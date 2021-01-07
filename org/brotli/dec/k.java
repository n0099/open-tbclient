package org.brotli.dec;
/* loaded from: classes5.dex */
final class k {
    static final k[] qqT = {new k("", 0, ""), new k("", 0, " "), new k(" ", 0, " "), new k("", 12, ""), new k("", 10, " "), new k("", 0, " the "), new k(" ", 0, ""), new k("s ", 0, " "), new k("", 0, " of "), new k("", 10, ""), new k("", 0, " and "), new k("", 13, ""), new k("", 1, ""), new k(", ", 0, " "), new k("", 0, ", "), new k(" ", 10, " "), new k("", 0, " in "), new k("", 0, " to "), new k("e ", 0, " "), new k("", 0, "\""), new k("", 0, "."), new k("", 0, "\">"), new k("", 0, "\n"), new k("", 3, ""), new k("", 0, "]"), new k("", 0, " for "), new k("", 14, ""), new k("", 2, ""), new k("", 0, " a "), new k("", 0, " that "), new k(" ", 10, ""), new k("", 0, ". "), new k(".", 0, ""), new k(" ", 0, ", "), new k("", 15, ""), new k("", 0, " with "), new k("", 0, "'"), new k("", 0, " from "), new k("", 0, " by "), new k("", 16, ""), new k("", 17, ""), new k(" the ", 0, ""), new k("", 4, ""), new k("", 0, ". The "), new k("", 11, ""), new k("", 0, " on "), new k("", 0, " as "), new k("", 0, " is "), new k("", 7, ""), new k("", 1, "ing "), new k("", 0, "\n\t"), new k("", 0, ":"), new k(" ", 0, ". "), new k("", 0, "ed "), new k("", 20, ""), new k("", 18, ""), new k("", 6, ""), new k("", 0, "("), new k("", 10, ", "), new k("", 8, ""), new k("", 0, " at "), new k("", 0, "ly "), new k(" the ", 0, " of "), new k("", 5, ""), new k("", 9, ""), new k(" ", 10, ", "), new k("", 10, "\""), new k(".", 0, "("), new k("", 11, " "), new k("", 10, "\">"), new k("", 0, "=\""), new k(" ", 0, "."), new k(".com/", 0, ""), new k(" the ", 0, " of the "), new k("", 10, "'"), new k("", 0, ". This "), new k("", 0, ","), new k(".", 0, " "), new k("", 10, "("), new k("", 10, "."), new k("", 0, " not "), new k(" ", 0, "=\""), new k("", 0, "er "), new k(" ", 11, " "), new k("", 0, "al "), new k(" ", 11, ""), new k("", 0, "='"), new k("", 11, "\""), new k("", 10, ". "), new k(" ", 0, "("), new k("", 0, "ful "), new k(" ", 10, ". "), new k("", 0, "ive "), new k("", 0, "less "), new k("", 11, "'"), new k("", 0, "est "), new k(" ", 10, "."), new k("", 11, "\">"), new k(" ", 0, "='"), new k("", 10, ","), new k("", 0, "ize "), new k("", 11, "."), new k("Â ", 0, ""), new k(" ", 0, ","), new k("", 10, "=\""), new k("", 11, "=\""), new k("", 0, "ous "), new k("", 11, ", "), new k("", 10, "='"), new k(" ", 10, ","), new k(" ", 11, "=\""), new k(" ", 11, ", "), new k("", 11, ","), new k("", 11, "("), new k("", 11, ". "), new k(" ", 11, "."), new k("", 11, "='"), new k(" ", 11, ". "), new k(" ", 10, "=\""), new k(" ", 11, "='"), new k(" ", 10, "='")};
    private final byte[] qqS;
    private final byte[] suffix;
    private final int type;

    k(String str, int i, String str2) {
        this.qqS = acs(str);
        this.type = i;
        this.suffix = acs(str2);
    }

    static byte[] acs(String str) {
        byte[] bArr = new byte[str.length()];
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) str.charAt(i);
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(byte[] bArr, int i, byte[] bArr2, int i2, int i3, k kVar) {
        byte[] bArr3 = kVar.qqS;
        int length = bArr3.length;
        int i4 = 0;
        int i5 = i;
        while (i4 < length) {
            bArr[i5] = bArr3[i4];
            i4++;
            i5++;
        }
        int i6 = kVar.type;
        int TO = m.TO(i6);
        if (TO > i3) {
            TO = i3;
        }
        int i7 = i2 + TO;
        int TP = (i3 - TO) - m.TP(i6);
        int i8 = TP;
        int i9 = i7;
        while (i8 > 0) {
            bArr[i5] = bArr2[i9];
            i8--;
            i5++;
            i9++;
        }
        if (i6 == 11 || i6 == 10) {
            int i10 = i5 - TP;
            if (i6 == 10) {
                TP = 1;
            }
            while (TP > 0) {
                int i11 = bArr[i10] & 255;
                if (i11 < 192) {
                    if (i11 >= 97 && i11 <= 122) {
                        bArr[i10] = (byte) (bArr[i10] ^ 32);
                    }
                    i10++;
                    TP--;
                } else if (i11 < 224) {
                    int i12 = i10 + 1;
                    bArr[i12] = (byte) (bArr[i12] ^ 32);
                    i10 += 2;
                    TP -= 2;
                } else {
                    int i13 = i10 + 2;
                    bArr[i13] = (byte) (bArr[i13] ^ 5);
                    i10 += 3;
                    TP -= 3;
                }
            }
        }
        byte[] bArr4 = kVar.suffix;
        int length2 = bArr4.length;
        int i14 = 0;
        while (i14 < length2) {
            bArr[i5] = bArr4[i14];
            i14++;
            i5++;
        }
        return i5 - i;
    }
}
