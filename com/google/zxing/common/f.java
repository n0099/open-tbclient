package com.google.zxing.common;

import com.google.zxing.NotFoundException;
/* loaded from: classes.dex */
public class f extends com.google.zxing.a {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f2863a = new byte[0];
    private byte[] b;
    private final int[] c;

    public f(com.google.zxing.c cVar) {
        super(cVar);
        this.b = f2863a;
        this.c = new int[32];
    }

    @Override // com.google.zxing.a
    public a b() {
        com.google.zxing.c a2 = a();
        int b = a2.b();
        int c = a2.c();
        a aVar = new a(b, c);
        a(b);
        int[] iArr = this.c;
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= 5) {
                break;
            }
            byte[] a3 = a2.a((c * i2) / 5, this.b);
            int i3 = (b << 2) / 5;
            for (int i4 = b / 5; i4 < i3; i4++) {
                int i5 = (a3[i4] & 255) >> 3;
                iArr[i5] = iArr[i5] + 1;
            }
            i = i2 + 1;
        }
        int a4 = a(iArr);
        byte[] a5 = a2.a();
        for (int i6 = 0; i6 < c; i6++) {
            int i7 = i6 * b;
            for (int i8 = 0; i8 < b; i8++) {
                if ((a5[i7 + i8] & 255) < a4) {
                    aVar.b(i8, i6);
                }
            }
        }
        return aVar;
    }

    private void a(int i) {
        if (this.b.length < i) {
            this.b = new byte[i];
        }
        for (int i2 = 0; i2 < 32; i2++) {
            this.c[i2] = 0;
        }
    }

    private static int a(int[] iArr) {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        int length = iArr.length;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < length; i8++) {
            if (iArr[i8] > i5) {
                i5 = iArr[i8];
                i6 = i8;
            }
            if (iArr[i8] > i7) {
                i7 = iArr[i8];
            }
        }
        int i9 = 0;
        int i10 = 0;
        while (i4 < length) {
            int i11 = i4 - i6;
            int i12 = i11 * iArr[i4] * i11;
            if (i12 > i9) {
                i3 = i4;
            } else {
                i12 = i9;
                i3 = i10;
            }
            i4++;
            i10 = i3;
            i9 = i12;
        }
        if (i6 > i10) {
            i = i10;
            i10 = i6;
        } else {
            i = i6;
        }
        if (i10 - i <= (length >> 4)) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i13 = i10 - 1;
        int i14 = -1;
        int i15 = i10 - 1;
        while (i15 > i) {
            int i16 = i15 - i;
            int i17 = i16 * i16 * (i10 - i15) * (i7 - iArr[i15]);
            if (i17 > i14) {
                i2 = i15;
            } else {
                i17 = i14;
                i2 = i13;
            }
            i15--;
            i13 = i2;
            i14 = i17;
        }
        return i13 << 3;
    }
}
