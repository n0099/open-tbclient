package com.google.zxing.oned.rss;
/* loaded from: classes6.dex */
public final class RSSUtils {
    private RSSUtils() {
    }

    public static int getRSSvalue(int[] iArr, int i, boolean z) {
        int i2 = 0;
        for (int i3 : iArr) {
            i2 += i3;
        }
        int length = iArr.length;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = i2;
        while (i4 < length - 1) {
            i5 |= 1 << i4;
            int i8 = 1;
            while (i8 < iArr[i4]) {
                int combins = combins((i7 - i8) - 1, (length - i4) - 2);
                if (z && i5 == 0 && (i7 - i8) - ((length - i4) - 1) >= (length - i4) - 1) {
                    combins -= combins((i7 - i8) - (length - i4), (length - i4) - 2);
                }
                if ((length - i4) - 1 > 1) {
                    int i9 = 0;
                    for (int i10 = (i7 - i8) - ((length - i4) - 2); i10 > i; i10--) {
                        i9 += combins(((i7 - i8) - i10) - 1, (length - i4) - 3);
                    }
                    combins -= ((length - 1) - i4) * i9;
                } else if (i7 - i8 > i) {
                    combins--;
                }
                i6 += combins;
                i8++;
                i5 &= (1 << i4) ^ (-1);
            }
            i4++;
            i7 -= i8;
        }
        return i6;
    }

    private static int combins(int i, int i2) {
        int i3;
        int i4;
        if (i - i2 > i2) {
            i4 = i - i2;
            i3 = i2;
        } else {
            i3 = i - i2;
            i4 = i2;
        }
        int i5 = 1;
        int i6 = 1;
        while (i > i4) {
            i6 *= i;
            if (i5 <= i3) {
                i6 /= i5;
                i5++;
            }
            i--;
        }
        int i7 = i6;
        while (i5 <= i3) {
            i7 /= i5;
            i5++;
        }
        return i7;
    }
}
