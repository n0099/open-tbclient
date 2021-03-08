package com.win.opensdk;

import androidx.core.view.ViewCompat;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
/* loaded from: classes14.dex */
public class cf {
    public ByteBuffer b;
    public cc qlx;

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f8142a = new byte[256];
    public int d = 0;

    public final int[] Rr(int i) {
        int[] iArr = null;
        byte[] bArr = new byte[i * 3];
        try {
            this.b.get(bArr);
            iArr = new int[256];
            int i2 = 0;
            int i3 = 0;
            while (i3 < i) {
                int i4 = i2 + 1;
                int i5 = bArr[i2] & 255;
                int i6 = i4 + 1;
                int i7 = bArr[i4] & 255;
                i2 = i6 + 1;
                int i8 = i3 + 1;
                iArr[i3] = (i5 << 16) | ViewCompat.MEASURED_STATE_MASK | (i7 << 8) | (bArr[i6] & 255);
                i3 = i8;
            }
        } catch (BufferUnderflowException e) {
            this.qlx.b = 1;
        }
        return iArr;
    }

    public final boolean a() {
        return this.qlx.b != 0;
    }

    public cf at(byte[] bArr) {
        if (bArr != null) {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            this.b = null;
            Arrays.fill(this.f8142a, (byte) 0);
            this.qlx = new cc();
            this.d = 0;
            this.b = wrap.asReadOnlyBuffer();
            this.b.position(0);
            this.b.order(ByteOrder.LITTLE_ENDIAN);
        } else {
            this.b = null;
            this.qlx.b = 2;
        }
        return this;
    }

    public final int b() {
        try {
            return this.b.get() & 255;
        } catch (Exception e) {
            this.qlx.b = 1;
            return 0;
        }
    }

    public final int c() {
        this.d = b();
        int i = 0;
        if (this.d > 0) {
            while (i < this.d) {
                try {
                    int i2 = this.d - i;
                    this.b.get(this.f8142a, i, i2);
                    i += i2;
                } catch (Exception e) {
                    this.qlx.b = 1;
                }
            }
        }
        return i;
    }

    public final void d() {
        int b;
        do {
            try {
                b = b();
                this.b.position(this.b.position() + b);
            } catch (IllegalArgumentException e) {
                return;
            }
        } while (b > 0);
    }
}
