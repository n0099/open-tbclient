package org.brotli.dec;
/* loaded from: classes7.dex */
final class f {
    private static int eE(int i, int i2) {
        int i3 = 1 << (i2 - 1);
        while ((i & i3) != 0) {
            i3 >>= 1;
        }
        return i3 + ((i3 - 1) & i);
    }

    private static void b(int[] iArr, int i, int i2, int i3, int i4) {
        do {
            i3 -= i2;
            iArr[i + i3] = i4;
        } while (i3 > 0);
    }

    private static int d(int[] iArr, int i, int i2) {
        int i3;
        int i4 = 1 << (i - i2);
        while (i < 15 && (i3 = i4 - iArr[i]) > 0) {
            i++;
            i4 = i3 << 1;
        }
        return i - i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(int[] iArr, int i, int i2, int[] iArr2, int i3) {
        int[] iArr3 = new int[i3];
        int[] iArr4 = new int[16];
        int[] iArr5 = new int[16];
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = iArr2[i4];
            iArr4[i5] = iArr4[i5] + 1;
        }
        iArr5[1] = 0;
        for (int i6 = 1; i6 < 15; i6++) {
            iArr5[i6 + 1] = iArr5[i6] + iArr4[i6];
        }
        for (int i7 = 0; i7 < i3; i7++) {
            if (iArr2[i7] != 0) {
                int i8 = iArr2[i7];
                int i9 = iArr5[i8];
                iArr5[i8] = i9 + 1;
                iArr3[i9] = i7;
            }
        }
        int i10 = 1 << i2;
        if (iArr5[15] == 1) {
            for (int i11 = 0; i11 < i10; i11++) {
                iArr[i + i11] = iArr3[0];
            }
            return;
        }
        int i12 = 1;
        int i13 = 0;
        int i14 = 2;
        int i15 = 0;
        while (i12 <= i2) {
            int i16 = i13;
            while (iArr4[i12] > 0) {
                int i17 = i15 + 1;
                b(iArr, i + i16, i14, i10, iArr3[i15] | (i12 << 16));
                int eE = eE(i16, i12);
                iArr4[i12] = iArr4[i12] - 1;
                i16 = eE;
                i15 = i17;
            }
            i12++;
            i14 <<= 1;
            i13 = i16;
        }
        int i18 = i10 - 1;
        int i19 = 2;
        int i20 = i2 + 1;
        int i21 = i10;
        int i22 = i10;
        int i23 = i13;
        int i24 = -1;
        int i25 = i15;
        int i26 = i;
        while (i20 <= 15) {
            int i27 = i23;
            while (iArr4[i20] > 0) {
                if ((i27 & i18) != i24) {
                    i26 += i22;
                    int d = d(iArr4, i20, i2);
                    i22 = 1 << d;
                    i21 += i22;
                    i24 = i27 & i18;
                    iArr[i + i24] = ((d + i2) << 16) | ((i26 - i) - i24);
                }
                int i28 = i25 + 1;
                b(iArr, i26 + (i27 >> i2), i19, i22, iArr3[i25] | ((i20 - i2) << 16));
                int eE2 = eE(i27, i20);
                iArr4[i20] = iArr4[i20] - 1;
                i27 = eE2;
                i25 = i28;
            }
            i20++;
            i19 <<= 1;
            i23 = i27;
        }
    }
}
