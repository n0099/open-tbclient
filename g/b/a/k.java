package g.b.a;

import com.baidu.android.common.others.lang.StringUtil;
/* loaded from: classes7.dex */
public final class k {

    /* renamed from: d  reason: collision with root package name */
    public static final k[] f68621d = {new k("", 0, ""), new k("", 0, " "), new k(" ", 0, " "), new k("", 12, ""), new k("", 10, " "), new k("", 0, " the "), new k(" ", 0, ""), new k("s ", 0, " "), new k("", 0, " of "), new k("", 10, ""), new k("", 0, " and "), new k("", 13, ""), new k("", 1, ""), new k(StringUtil.ARRAY_ELEMENT_SEPARATOR, 0, " "), new k("", 0, StringUtil.ARRAY_ELEMENT_SEPARATOR), new k(" ", 10, " "), new k("", 0, " in "), new k("", 0, " to "), new k("e ", 0, " "), new k("", 0, "\""), new k("", 0, "."), new k("", 0, "\">"), new k("", 0, "\n"), new k("", 3, ""), new k("", 0, "]"), new k("", 0, " for "), new k("", 14, ""), new k("", 2, ""), new k("", 0, " a "), new k("", 0, " that "), new k(" ", 10, ""), new k("", 0, ". "), new k(".", 0, ""), new k(" ", 0, StringUtil.ARRAY_ELEMENT_SEPARATOR), new k("", 15, ""), new k("", 0, " with "), new k("", 0, "'"), new k("", 0, " from "), new k("", 0, " by "), new k("", 16, ""), new k("", 17, ""), new k(" the ", 0, ""), new k("", 4, ""), new k("", 0, ". The "), new k("", 11, ""), new k("", 0, " on "), new k("", 0, " as "), new k("", 0, " is "), new k("", 7, ""), new k("", 1, "ing "), new k("", 0, "\n\t"), new k("", 0, ":"), new k(" ", 0, ". "), new k("", 0, "ed "), new k("", 20, ""), new k("", 18, ""), new k("", 6, ""), new k("", 0, "("), new k("", 10, StringUtil.ARRAY_ELEMENT_SEPARATOR), new k("", 8, ""), new k("", 0, " at "), new k("", 0, "ly "), new k(" the ", 0, " of "), new k("", 5, ""), new k("", 9, ""), new k(" ", 10, StringUtil.ARRAY_ELEMENT_SEPARATOR), new k("", 10, "\""), new k(".", 0, "("), new k("", 11, " "), new k("", 10, "\">"), new k("", 0, "=\""), new k(" ", 0, "."), new k(".com/", 0, ""), new k(" the ", 0, " of the "), new k("", 10, "'"), new k("", 0, ". This "), new k("", 0, ","), new k(".", 0, " "), new k("", 10, "("), new k("", 10, "."), new k("", 0, " not "), new k(" ", 0, "=\""), new k("", 0, "er "), new k(" ", 11, " "), new k("", 0, "al "), new k(" ", 11, ""), new k("", 0, "='"), new k("", 11, "\""), new k("", 10, ". "), new k(" ", 0, "("), new k("", 0, "ful "), new k(" ", 10, ". "), new k("", 0, "ive "), new k("", 0, "less "), new k("", 11, "'"), new k("", 0, "est "), new k(" ", 10, "."), new k("", 11, "\">"), new k(" ", 0, "='"), new k("", 10, ","), new k("", 0, "ize "), new k("", 11, "."), new k("Â ", 0, ""), new k(" ", 0, ","), new k("", 10, "=\""), new k("", 11, "=\""), new k("", 0, "ous "), new k("", 11, StringUtil.ARRAY_ELEMENT_SEPARATOR), new k("", 10, "='"), new k(" ", 10, ","), new k(" ", 11, "=\""), new k(" ", 11, StringUtil.ARRAY_ELEMENT_SEPARATOR), new k("", 11, ","), new k("", 11, "("), new k("", 11, ". "), new k(" ", 11, "."), new k("", 11, "='"), new k(" ", 11, ". "), new k(" ", 10, "=\""), new k(" ", 11, "='"), new k(" ", 10, "='")};

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f68622a;

    /* renamed from: b  reason: collision with root package name */
    public final int f68623b;

    /* renamed from: c  reason: collision with root package name */
    public final byte[] f68624c;

    public k(String str, int i, String str2) {
        this.f68622a = a(str);
        this.f68623b = i;
        this.f68624c = a(str2);
    }

    public static byte[] a(String str) {
        int length = str.length();
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = (byte) str.charAt(i);
        }
        return bArr;
    }

    public static int b(byte[] bArr, int i, byte[] bArr2, int i2, int i3, k kVar) {
        int i4 = i;
        for (byte b2 : kVar.f68622a) {
            bArr[i4] = b2;
            i4++;
        }
        int i5 = kVar.f68623b;
        int a2 = m.a(i5);
        if (a2 > i3) {
            a2 = i3;
        }
        int i6 = i2 + a2;
        int b3 = (i3 - a2) - m.b(i5);
        int i7 = b3;
        while (i7 > 0) {
            bArr[i4] = bArr2[i6];
            i7--;
            i4++;
            i6++;
        }
        if (i5 == 11 || i5 == 10) {
            int i8 = i4 - b3;
            if (i5 == 10) {
                b3 = 1;
            }
            while (b3 > 0) {
                int i9 = bArr[i8] & 255;
                if (i9 < 192) {
                    if (i9 >= 97 && i9 <= 122) {
                        bArr[i8] = (byte) (bArr[i8] ^ 32);
                    }
                    i8++;
                    b3--;
                } else if (i9 < 224) {
                    int i10 = i8 + 1;
                    bArr[i10] = (byte) (bArr[i10] ^ 32);
                    i8 += 2;
                    b3 -= 2;
                } else {
                    int i11 = i8 + 2;
                    bArr[i11] = (byte) (bArr[i11] ^ 5);
                    i8 += 3;
                    b3 -= 3;
                }
            }
        }
        for (byte b4 : kVar.f68624c) {
            bArr[i4] = b4;
            i4++;
        }
        return i4 - i;
    }
}
