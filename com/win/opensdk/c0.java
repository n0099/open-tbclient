package com.win.opensdk;

import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
/* loaded from: classes7.dex */
public class c0 {

    /* renamed from: b  reason: collision with root package name */
    public ByteBuffer f39905b;

    /* renamed from: c  reason: collision with root package name */
    public b0 f39906c;

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f39904a = new byte[256];

    /* renamed from: d  reason: collision with root package name */
    public int f39907d = 0;

    public c0 a(byte[] bArr) {
        if (bArr != null) {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            this.f39905b = null;
            Arrays.fill(this.f39904a, (byte) 0);
            this.f39906c = new b0();
            this.f39907d = 0;
            ByteBuffer asReadOnlyBuffer = wrap.asReadOnlyBuffer();
            this.f39905b = asReadOnlyBuffer;
            asReadOnlyBuffer.position(0);
            this.f39905b.order(ByteOrder.LITTLE_ENDIAN);
        } else {
            this.f39905b = null;
            this.f39906c.f39880b = 2;
        }
        return this;
    }

    public final boolean a() {
        return this.f39906c.f39880b != 0;
    }

    public final int[] a(int i) {
        int[] iArr;
        byte[] bArr = new byte[i * 3];
        try {
            this.f39905b.get(bArr);
            iArr = new int[256];
            int i2 = 0;
            int i3 = 0;
            while (i2 < i) {
                int i4 = i3 + 1;
                try {
                    int i5 = i4 + 1;
                    int i6 = i5 + 1;
                    int i7 = i2 + 1;
                    iArr[i2] = ((bArr[i3] & 255) << 16) | (-16777216) | ((bArr[i4] & 255) << 8) | (bArr[i5] & 255);
                    i3 = i6;
                    i2 = i7;
                } catch (BufferUnderflowException unused) {
                    this.f39906c.f39880b = 1;
                    return iArr;
                }
            }
        } catch (BufferUnderflowException unused2) {
            iArr = null;
        }
        return iArr;
    }

    public final int b() {
        try {
            return this.f39905b.get() & 255;
        } catch (Exception unused) {
            this.f39906c.f39880b = 1;
            return 0;
        }
    }

    public final int c() {
        int b2 = b();
        this.f39907d = b2;
        int i = 0;
        if (b2 > 0) {
            while (i < this.f39907d) {
                try {
                    int i2 = this.f39907d - i;
                    this.f39905b.get(this.f39904a, i, i2);
                    i += i2;
                } catch (Exception unused) {
                    this.f39906c.f39880b = 1;
                }
            }
        }
        return i;
    }

    public final void d() {
        int b2;
        do {
            try {
                b2 = b();
                this.f39905b.position(this.f39905b.position() + b2);
            } catch (IllegalArgumentException unused) {
                return;
            }
        } while (b2 > 0);
    }
}
