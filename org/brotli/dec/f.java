package org.brotli.dec;
/* loaded from: classes4.dex */
final class f {
    private static int et(int i, int i2) {
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

    private static int e(int[] iArr, int i, int i2) {
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
        int i4;
        int i5;
        int[] iArr3 = new int[i3];
        int[] iArr4 = new int[16];
        int[] iArr5 = new int[16];
        for (int i6 = 0; i6 < i3; i6++) {
            int i7 = iArr2[i6];
            iArr4[i7] = iArr4[i7] + 1;
        }
        iArr5[1] = 0;
        for (int i8 = 1; i8 < 15; i8++) {
            iArr5[i8 + 1] = iArr5[i8] + iArr4[i8];
        }
        for (int i9 = 0; i9 < i3; i9++) {
            if (iArr2[i9] != 0) {
                int i10 = iArr2[i9];
                int i11 = iArr5[i10];
                iArr5[i10] = i11 + 1;
                iArr3[i11] = i9;
            }
        }
        int i12 = 1 << i2;
        if (iArr5[15] == 1) {
            for (int i13 = 0; i13 < i12; i13++) {
                iArr[i + i13] = iArr3[0];
            }
            return;
        }
        int i14 = 0;
        int i15 = 0;
        int i16 = 1;
        int i17 = 2;
        while (i16 <= i2) {
            int i18 = i14;
            while (iArr4[i16] > 0) {
                b(iArr, i + i18, i17, i12, iArr3[i15] | (i16 << 16));
                i18 = et(i18, i16);
                iArr4[i16] = iArr4[i16] - 1;
                i15++;
            }
            i16++;
            i17 <<= 1;
            i14 = i18;
        }
        int i19 = i12 - 1;
        int i20 = -1;
        int i21 = i2 + 1;
        int i22 = 2;
        int i23 = i;
        int i24 = i12;
        int i25 = i12;
        int i26 = i15;
        int i27 = i14;
        while (i21 <= 15) {
            int i28 = i23;
            int i29 = i20;
            int i30 = i27;
            while (iArr4[i21] > 0) {
                if ((i30 & i19) != i29) {
                    i28 += i25;
                    int e = e(iArr4, i21, i2);
                    i5 = 1 << e;
                    i4 = i24 + i5;
                    i29 = i30 & i19;
                    iArr[i + i29] = ((e + i2) << 16) | ((i28 - i) - i29);
                } else {
                    i4 = i24;
                    i5 = i25;
                }
                b(iArr, (i30 >> i2) + i28, i22, i5, ((i21 - i2) << 16) | iArr3[i26]);
                i30 = et(i30, i21);
                iArr4[i21] = iArr4[i21] - 1;
                i24 = i4;
                i25 = i5;
                i26++;
            }
            i21++;
            i22 <<= 1;
            i23 = i28;
            i20 = i29;
            i27 = i30;
        }
    }
}
