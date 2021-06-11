package g.b.a;
/* loaded from: classes8.dex */
public final class f {
    public static void a(int[] iArr, int i2, int i3, int[] iArr2, int i4) {
        int[] iArr3 = new int[i4];
        int[] iArr4 = new int[16];
        int[] iArr5 = new int[16];
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            int i7 = iArr2[i6];
            iArr4[i7] = iArr4[i7] + 1;
        }
        iArr5[1] = 0;
        int i8 = 1;
        while (i8 < 15) {
            int i9 = i8 + 1;
            iArr5[i9] = iArr5[i8] + iArr4[i8];
            i8 = i9;
        }
        for (int i10 = 0; i10 < i4; i10++) {
            if (iArr2[i10] != 0) {
                int i11 = iArr2[i10];
                int i12 = iArr5[i11];
                iArr5[i11] = i12 + 1;
                iArr3[i12] = i10;
            }
        }
        int i13 = 1 << i3;
        if (iArr5[15] == 1) {
            for (int i14 = 0; i14 < i13; i14++) {
                iArr[i2 + i14] = iArr3[0];
            }
            return;
        }
        int i15 = 2;
        int i16 = 0;
        int i17 = 1;
        int i18 = 2;
        while (i17 <= i3) {
            while (iArr4[i17] > 0) {
                d(iArr, i2 + i5, i18, i13, iArr3[i16] | (i17 << 16));
                i5 = b(i5, i17);
                iArr4[i17] = iArr4[i17] - 1;
                i16++;
            }
            i17++;
            i18 <<= 1;
        }
        int i19 = i13 - 1;
        int i20 = -1;
        int i21 = i3 + 1;
        int i22 = i2;
        while (i21 <= 15) {
            while (iArr4[i21] > 0) {
                int i23 = i5 & i19;
                if (i23 != i20) {
                    i22 += i13;
                    int c2 = c(iArr4, i21, i3);
                    iArr[i2 + i23] = ((c2 + i3) << 16) | ((i22 - i2) - i23);
                    i13 = 1 << c2;
                    i20 = i23;
                }
                d(iArr, (i5 >> i3) + i22, i15, i13, ((i21 - i3) << 16) | iArr3[i16]);
                i5 = b(i5, i21);
                iArr4[i21] = iArr4[i21] - 1;
                i16++;
            }
            i21++;
            i15 <<= 1;
        }
    }

    public static int b(int i2, int i3) {
        int i4 = 1 << (i3 - 1);
        while ((i2 & i4) != 0) {
            i4 >>= 1;
        }
        return (i2 & (i4 - 1)) + i4;
    }

    public static int c(int[] iArr, int i2, int i3) {
        int i4;
        int i5 = 1 << (i2 - i3);
        while (i2 < 15 && (i4 = i5 - iArr[i2]) > 0) {
            i2++;
            i5 = i4 << 1;
        }
        return i2 - i3;
    }

    public static void d(int[] iArr, int i2, int i3, int i4, int i5) {
        do {
            i4 -= i3;
            iArr[i2 + i4] = i5;
        } while (i4 > 0);
    }
}
