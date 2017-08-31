package com.google.protobuf.micro;

import android.support.v4.media.TransportMediator;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
/* loaded from: classes2.dex */
public final class c {
    private final byte[] a;
    private final int b;
    private int c;
    private final OutputStream gSq;

    /* loaded from: classes2.dex */
    public static class a extends IOException {
        a() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    private c(OutputStream outputStream, byte[] bArr) {
        this.gSq = outputStream;
        this.a = bArr;
        this.c = 0;
        this.b = bArr.length;
    }

    private c(byte[] bArr, int i, int i2) {
        this.gSq = null;
        this.a = bArr;
        this.c = i;
        this.b = i + i2;
    }

    public static int G(int i, boolean z) {
        return vx(i) + nH(z);
    }

    public static c a(OutputStream outputStream, int i) {
        return new c(outputStream, new byte[i]);
    }

    public static int ag(int i, String str) {
        return vx(i) + b(str);
    }

    public static int b(int i, com.google.protobuf.micro.a aVar) {
        return vx(i) + c(aVar);
    }

    public static int b(int i, e eVar) {
        return vx(i) + b(eVar);
    }

    public static int b(e eVar) {
        int b = eVar.b();
        return b + vy(b);
    }

    public static int b(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            return bytes.length + vy(bytes.length);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported.");
        }
    }

    public static int bQ(int i, int i2) {
        return vx(i) + d(i2);
    }

    public static int c(int i) {
        if (i >= 0) {
            return vy(i);
        }
        return 10;
    }

    public static int c(int i, int i2) {
        return vx(i) + c(i2);
    }

    public static int c(com.google.protobuf.micro.a aVar) {
        return vy(aVar.a()) + aVar.a();
    }

    public static int d(int i) {
        return vy(i);
    }

    private void d() {
        if (this.gSq == null) {
            throw new a();
        }
        this.gSq.write(this.a, 0, this.c);
        this.c = 0;
    }

    public static int dq(long j) {
        return dt(j);
    }

    public static int dr(long j) {
        return dt(j);
    }

    public static int dt(long j) {
        if (((-128) & j) == 0) {
            return 1;
        }
        if (((-16384) & j) == 0) {
            return 2;
        }
        if (((-2097152) & j) == 0) {
            return 3;
        }
        if (((-268435456) & j) == 0) {
            return 4;
        }
        if (((-34359738368L) & j) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j) == 0) {
            return 8;
        }
        return (Long.MIN_VALUE & j) == 0 ? 9 : 10;
    }

    public static c h(OutputStream outputStream) {
        return a(outputStream, 4096);
    }

    public static c m(byte[] bArr, int i, int i2) {
        return new c(bArr, i, i2);
    }

    public static int n(int i, long j) {
        return vx(i) + dq(j);
    }

    public static int nH(boolean z) {
        return 1;
    }

    public static int o(int i, long j) {
        return vx(i) + dr(j);
    }

    public static int vx(int i) {
        return vy(f.a(i, 0));
    }

    public static int vy(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return ((-268435456) & i) == 0 ? 4 : 5;
    }

    public void a() {
        if (this.gSq != null) {
            d();
        }
    }

    public void a(byte b) {
        if (this.c == this.b) {
            d();
        }
        byte[] bArr = this.a;
        int i = this.c;
        this.c = i + 1;
        bArr[i] = b;
    }

    public void a(int i) {
        if (i >= 0) {
            g(i);
        } else {
            ds(i);
        }
    }

    public void a(int i, int i2) {
        e(i, 0);
        a(i2);
    }

    public void a(int i, com.google.protobuf.micro.a aVar) {
        e(i, 2);
        b(aVar);
    }

    public void a(int i, e eVar) {
        e(i, 2);
        a(eVar);
    }

    public void a(int i, String str) {
        e(i, 2);
        a(str);
    }

    public void a(int i, boolean z) {
        e(i, 0);
        a(z);
    }

    public void a(long j) {
        ds(j);
    }

    public void a(e eVar) {
        g(eVar.a());
        eVar.a(this);
    }

    public void a(String str) {
        byte[] bytes = str.getBytes("UTF-8");
        g(bytes.length);
        a(bytes);
    }

    public void a(boolean z) {
        e(z ? 1 : 0);
    }

    public void a(byte[] bArr) {
        b(bArr, 0, bArr.length);
    }

    public int b() {
        if (this.gSq == null) {
            return this.b - this.c;
        }
        throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array.");
    }

    public void b(int i) {
        g(i);
    }

    public void b(int i, int i2) {
        e(i, 0);
        b(i2);
    }

    public void b(int i, long j) {
        e(i, 0);
        a(j);
    }

    public void b(long j) {
        ds(j);
    }

    public void b(com.google.protobuf.micro.a aVar) {
        byte[] b = aVar.b();
        g(b.length);
        a(b);
    }

    public void b(byte[] bArr, int i, int i2) {
        if (this.b - this.c >= i2) {
            System.arraycopy(bArr, i, this.a, this.c, i2);
            this.c += i2;
            return;
        }
        int i3 = this.b - this.c;
        System.arraycopy(bArr, i, this.a, this.c, i3);
        int i4 = i + i3;
        int i5 = i2 - i3;
        this.c = this.b;
        d();
        if (i5 > this.b) {
            this.gSq.write(bArr, i4, i5);
            return;
        }
        System.arraycopy(bArr, i4, this.a, 0, i5);
        this.c = i5;
    }

    public void c() {
        if (b() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public void ds(long j) {
        while (((-128) & j) != 0) {
            e((((int) j) & TransportMediator.KEYCODE_MEDIA_PAUSE) | 128);
            j >>>= 7;
        }
        e((int) j);
    }

    public void e(int i) {
        a((byte) i);
    }

    public void e(int i, int i2) {
        g(f.a(i, i2));
    }

    public void g(int i) {
        while ((i & (-128)) != 0) {
            e((i & TransportMediator.KEYCODE_MEDIA_PAUSE) | 128);
            i >>>= 7;
        }
        e(i);
    }

    public void m(int i, long j) {
        e(i, 0);
        b(j);
    }
}
