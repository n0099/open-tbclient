package org.brotli.dec;

import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes5.dex */
final class k {
    static final k[] nKT = {new k("", 0, ""), new k("", 0, HanziToPinyin.Token.SEPARATOR), new k(HanziToPinyin.Token.SEPARATOR, 0, HanziToPinyin.Token.SEPARATOR), new k("", 12, ""), new k("", 10, HanziToPinyin.Token.SEPARATOR), new k("", 0, " the "), new k(HanziToPinyin.Token.SEPARATOR, 0, ""), new k("s ", 0, HanziToPinyin.Token.SEPARATOR), new k("", 0, " of "), new k("", 10, ""), new k("", 0, " and "), new k("", 13, ""), new k("", 1, ""), new k(", ", 0, HanziToPinyin.Token.SEPARATOR), new k("", 0, ", "), new k(HanziToPinyin.Token.SEPARATOR, 10, HanziToPinyin.Token.SEPARATOR), new k("", 0, " in "), new k("", 0, " to "), new k("e ", 0, HanziToPinyin.Token.SEPARATOR), new k("", 0, "\""), new k("", 0, "."), new k("", 0, "\">"), new k("", 0, "\n"), new k("", 3, ""), new k("", 0, "]"), new k("", 0, " for "), new k("", 14, ""), new k("", 2, ""), new k("", 0, " a "), new k("", 0, " that "), new k(HanziToPinyin.Token.SEPARATOR, 10, ""), new k("", 0, ". "), new k(".", 0, ""), new k(HanziToPinyin.Token.SEPARATOR, 0, ", "), new k("", 15, ""), new k("", 0, " with "), new k("", 0, "'"), new k("", 0, " from "), new k("", 0, " by "), new k("", 16, ""), new k("", 17, ""), new k(" the ", 0, ""), new k("", 4, ""), new k("", 0, ". The "), new k("", 11, ""), new k("", 0, " on "), new k("", 0, " as "), new k("", 0, " is "), new k("", 7, ""), new k("", 1, "ing "), new k("", 0, "\n\t"), new k("", 0, ":"), new k(HanziToPinyin.Token.SEPARATOR, 0, ". "), new k("", 0, "ed "), new k("", 20, ""), new k("", 18, ""), new k("", 6, ""), new k("", 0, "("), new k("", 10, ", "), new k("", 8, ""), new k("", 0, " at "), new k("", 0, "ly "), new k(" the ", 0, " of "), new k("", 5, ""), new k("", 9, ""), new k(HanziToPinyin.Token.SEPARATOR, 10, ", "), new k("", 10, "\""), new k(".", 0, "("), new k("", 11, HanziToPinyin.Token.SEPARATOR), new k("", 10, "\">"), new k("", 0, "=\""), new k(HanziToPinyin.Token.SEPARATOR, 0, "."), new k(".com/", 0, ""), new k(" the ", 0, " of the "), new k("", 10, "'"), new k("", 0, ". This "), new k("", 0, Constants.ACCEPT_TIME_SEPARATOR_SP), new k(".", 0, HanziToPinyin.Token.SEPARATOR), new k("", 10, "("), new k("", 10, "."), new k("", 0, " not "), new k(HanziToPinyin.Token.SEPARATOR, 0, "=\""), new k("", 0, "er "), new k(HanziToPinyin.Token.SEPARATOR, 11, HanziToPinyin.Token.SEPARATOR), new k("", 0, "al "), new k(HanziToPinyin.Token.SEPARATOR, 11, ""), new k("", 0, "='"), new k("", 11, "\""), new k("", 10, ". "), new k(HanziToPinyin.Token.SEPARATOR, 0, "("), new k("", 0, "ful "), new k(HanziToPinyin.Token.SEPARATOR, 10, ". "), new k("", 0, "ive "), new k("", 0, "less "), new k("", 11, "'"), new k("", 0, "est "), new k(HanziToPinyin.Token.SEPARATOR, 10, "."), new k("", 11, "\">"), new k(HanziToPinyin.Token.SEPARATOR, 0, "='"), new k("", 10, Constants.ACCEPT_TIME_SEPARATOR_SP), new k("", 0, "ize "), new k("", 11, "."), new k("Â ", 0, ""), new k(HanziToPinyin.Token.SEPARATOR, 0, Constants.ACCEPT_TIME_SEPARATOR_SP), new k("", 10, "=\""), new k("", 11, "=\""), new k("", 0, "ous "), new k("", 11, ", "), new k("", 10, "='"), new k(HanziToPinyin.Token.SEPARATOR, 10, Constants.ACCEPT_TIME_SEPARATOR_SP), new k(HanziToPinyin.Token.SEPARATOR, 11, "=\""), new k(HanziToPinyin.Token.SEPARATOR, 11, ", "), new k("", 11, Constants.ACCEPT_TIME_SEPARATOR_SP), new k("", 11, "("), new k("", 11, ". "), new k(HanziToPinyin.Token.SEPARATOR, 11, "."), new k("", 11, "='"), new k(HanziToPinyin.Token.SEPARATOR, 11, ". "), new k(HanziToPinyin.Token.SEPARATOR, 10, "=\""), new k(HanziToPinyin.Token.SEPARATOR, 11, "='"), new k(HanziToPinyin.Token.SEPARATOR, 10, "='")};
    private final byte[] nKS;
    private final byte[] suffix;
    private final int type;

    k(String str, int i, String str2) {
        this.nKS = Sf(str);
        this.type = i;
        this.suffix = Sf(str2);
    }

    static byte[] Sf(String str) {
        byte[] bArr = new byte[str.length()];
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) str.charAt(i);
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(byte[] bArr, int i, byte[] bArr2, int i2, int i3, k kVar) {
        byte[] bArr3 = kVar.nKS;
        int length = bArr3.length;
        int i4 = 0;
        int i5 = i;
        while (i4 < length) {
            bArr[i5] = bArr3[i4];
            i4++;
            i5++;
        }
        int i6 = kVar.type;
        int NS = m.NS(i6);
        if (NS > i3) {
            NS = i3;
        }
        int i7 = i2 + NS;
        int NT = (i3 - NS) - m.NT(i6);
        int i8 = i5;
        int i9 = i7;
        int i10 = NT;
        while (i10 > 0) {
            bArr[i8] = bArr2[i9];
            i10--;
            i9++;
            i8++;
        }
        if (i6 == 11 || i6 == 10) {
            int i11 = i8 - NT;
            if (i6 == 10) {
                NT = 1;
            }
            while (NT > 0) {
                int i12 = bArr[i11] & 255;
                if (i12 < 192) {
                    if (i12 >= 97 && i12 <= 122) {
                        bArr[i11] = (byte) (bArr[i11] ^ 32);
                    }
                    i11++;
                    NT--;
                } else if (i12 < 224) {
                    int i13 = i11 + 1;
                    bArr[i13] = (byte) (bArr[i13] ^ 32);
                    i11 += 2;
                    NT -= 2;
                } else {
                    int i14 = i11 + 2;
                    bArr[i14] = (byte) (bArr[i14] ^ 5);
                    i11 += 3;
                    NT -= 3;
                }
            }
        }
        byte[] bArr4 = kVar.suffix;
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
