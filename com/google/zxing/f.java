package com.google.zxing;

import com.tencent.mm.sdk.platformtools.Util;
/* loaded from: classes.dex */
public final class f extends c {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f2873a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;

    public f(int i, int i2, int[] iArr) {
        super(i, i2);
        this.b = i;
        this.c = i2;
        this.d = 0;
        this.e = 0;
        this.f2873a = new byte[i * i2];
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = i3 * i;
            for (int i5 = 0; i5 < i; i5++) {
                int i6 = iArr[i4 + i5];
                int i7 = (i6 >> 16) & Util.MASK_8BIT;
                int i8 = (i6 >> 8) & Util.MASK_8BIT;
                int i9 = i6 & Util.MASK_8BIT;
                if (i7 == i8 && i8 == i9) {
                    this.f2873a[i4 + i5] = (byte) i7;
                } else {
                    this.f2873a[i4 + i5] = (byte) ((i9 + ((i7 + i8) + i8)) >> 2);
                }
            }
        }
    }

    @Override // com.google.zxing.c
    public byte[] a(int i, byte[] bArr) {
        if (i < 0 || i >= c()) {
            throw new IllegalArgumentException("Requested row is outside the image: " + i);
        }
        int b = b();
        if (bArr == null || bArr.length < b) {
            bArr = new byte[b];
        }
        System.arraycopy(this.f2873a, ((this.e + i) * this.b) + this.d, bArr, 0, b);
        return bArr;
    }

    @Override // com.google.zxing.c
    public byte[] a() {
        int b = b();
        int c = c();
        if (b == this.b && c == this.c) {
            return this.f2873a;
        }
        int i = b * c;
        byte[] bArr = new byte[i];
        int i2 = (this.e * this.b) + this.d;
        if (b == this.b) {
            System.arraycopy(this.f2873a, i2, bArr, 0, i);
            return bArr;
        }
        byte[] bArr2 = this.f2873a;
        for (int i3 = 0; i3 < c; i3++) {
            System.arraycopy(bArr2, i2, bArr, i3 * b, b);
            i2 += this.b;
        }
        return bArr;
    }
}
