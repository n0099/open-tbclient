package com.google.zxing.common;

import com.tencent.mm.sdk.platformtools.Util;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f2860a;
    private int b;
    private int c;

    public b(byte[] bArr) {
        this.f2860a = bArr;
    }

    public int a(int i) {
        int i2;
        int i3;
        if (i < 1 || i > 32 || i > a()) {
            throw new IllegalArgumentException(String.valueOf(i));
        }
        if (this.c > 0) {
            int i4 = 8 - this.c;
            int i5 = i < i4 ? i : i4;
            int i6 = i4 - i5;
            int i7 = (((Util.MASK_8BIT >> (8 - i5)) << i6) & this.f2860a[this.b]) >> i6;
            int i8 = i - i5;
            this.c = i5 + this.c;
            if (this.c == 8) {
                this.c = 0;
                this.b++;
            }
            i2 = i7;
            i3 = i8;
        } else {
            i2 = 0;
            i3 = i;
        }
        if (i3 > 0) {
            while (i3 >= 8) {
                i2 = (i2 << 8) | (this.f2860a[this.b] & 255);
                this.b++;
                i3 -= 8;
            }
            if (i3 > 0) {
                int i9 = 8 - i3;
                int i10 = (i2 << i3) | ((((Util.MASK_8BIT >> i9) << i9) & this.f2860a[this.b]) >> i9);
                this.c = i3 + this.c;
                return i10;
            }
            return i2;
        }
        return i2;
    }

    public int a() {
        return ((this.f2860a.length - this.b) * 8) - this.c;
    }
}
