package com.win.opensdk;

import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
/* loaded from: classes7.dex */
public class c0 {

    /* renamed from: b  reason: collision with root package name */
    public ByteBuffer f40289b;

    /* renamed from: c  reason: collision with root package name */
    public b0 f40290c;

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f40288a = new byte[256];

    /* renamed from: d  reason: collision with root package name */
    public int f40291d = 0;

    public c0 a(byte[] bArr) {
        if (bArr != null) {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            this.f40289b = null;
            Arrays.fill(this.f40288a, (byte) 0);
            this.f40290c = new b0();
            this.f40291d = 0;
            ByteBuffer asReadOnlyBuffer = wrap.asReadOnlyBuffer();
            this.f40289b = asReadOnlyBuffer;
            asReadOnlyBuffer.position(0);
            this.f40289b.order(ByteOrder.LITTLE_ENDIAN);
        } else {
            this.f40289b = null;
            this.f40290c.f40264b = 2;
        }
        return this;
    }

    public final boolean a() {
        return this.f40290c.f40264b != 0;
    }

    public final int[] a(int i) {
        int[] iArr;
        byte[] bArr = new byte[i * 3];
        try {
            this.f40289b.get(bArr);
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
                    this.f40290c.f40264b = 1;
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
            return this.f40289b.get() & 255;
        } catch (Exception unused) {
            this.f40290c.f40264b = 1;
            return 0;
        }
    }

    public final int c() {
        int b2 = b();
        this.f40291d = b2;
        int i = 0;
        if (b2 > 0) {
            while (i < this.f40291d) {
                try {
                    int i2 = this.f40291d - i;
                    this.f40289b.get(this.f40288a, i, i2);
                    i += i2;
                } catch (Exception unused) {
                    this.f40290c.f40264b = 1;
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
                this.f40289b.position(this.f40289b.position() + b2);
            } catch (IllegalArgumentException unused) {
                return;
            }
        } while (b2 > 0);
    }
}
