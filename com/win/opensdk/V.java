package com.win.opensdk;

import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
/* loaded from: classes7.dex */
public class V {

    /* renamed from: b  reason: collision with root package name */
    public ByteBuffer f36965b;

    /* renamed from: c  reason: collision with root package name */
    public U f36966c;

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f36964a = new byte[256];

    /* renamed from: d  reason: collision with root package name */
    public int f36967d = 0;

    public V a(byte[] bArr) {
        if (bArr != null) {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            this.f36965b = null;
            Arrays.fill(this.f36964a, (byte) 0);
            this.f36966c = new U();
            this.f36967d = 0;
            ByteBuffer asReadOnlyBuffer = wrap.asReadOnlyBuffer();
            this.f36965b = asReadOnlyBuffer;
            asReadOnlyBuffer.position(0);
            this.f36965b.order(ByteOrder.LITTLE_ENDIAN);
        } else {
            this.f36965b = null;
            this.f36966c.f36954b = 2;
        }
        return this;
    }

    public final boolean a() {
        return this.f36966c.f36954b != 0;
    }

    public final int[] a(int i2) {
        int[] iArr;
        byte[] bArr = new byte[i2 * 3];
        try {
            this.f36965b.get(bArr);
            iArr = new int[256];
            int i3 = 0;
            int i4 = 0;
            while (i3 < i2) {
                int i5 = i4 + 1;
                try {
                    int i6 = i5 + 1;
                    int i7 = i6 + 1;
                    int i8 = i3 + 1;
                    iArr[i3] = ((bArr[i4] & 255) << 16) | (-16777216) | ((bArr[i5] & 255) << 8) | (bArr[i6] & 255);
                    i4 = i7;
                    i3 = i8;
                } catch (BufferUnderflowException unused) {
                    this.f36966c.f36954b = 1;
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
            return this.f36965b.get() & 255;
        } catch (Exception unused) {
            this.f36966c.f36954b = 1;
            return 0;
        }
    }

    public final int c() {
        int b2 = b();
        this.f36967d = b2;
        int i2 = 0;
        if (b2 > 0) {
            while (i2 < this.f36967d) {
                try {
                    int i3 = this.f36967d - i2;
                    this.f36965b.get(this.f36964a, i2, i3);
                    i2 += i3;
                } catch (Exception unused) {
                    this.f36966c.f36954b = 1;
                }
            }
        }
        return i2;
    }

    public final void d() {
        int b2;
        do {
            try {
                b2 = b();
                this.f36965b.position(this.f36965b.position() + b2);
            } catch (IllegalArgumentException unused) {
                return;
            }
        } while (b2 > 0);
    }
}
