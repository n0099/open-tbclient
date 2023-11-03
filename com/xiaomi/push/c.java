package com.xiaomi.push;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import kotlinx.coroutines.scheduling.CoroutineScheduler;
/* loaded from: classes10.dex */
public final class c {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final OutputStream f159a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f160a;
    public int b;

    /* loaded from: classes10.dex */
    public static class a extends IOException {
        public a() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    public c(OutputStream outputStream, byte[] bArr) {
        this.f159a = outputStream;
        this.f160a = bArr;
        this.b = 0;
        this.a = bArr.length;
    }

    public c(byte[] bArr, int i, int i2) {
        this.f159a = null;
        this.f160a = bArr;
        this.b = i;
        this.a = i + i2;
    }

    public static int a(int i) {
        if (i >= 0) {
            return d(i);
        }
        return 10;
    }

    public static int a(int i, int i2) {
        return c(i) + a(i2);
    }

    public static int a(int i, long j) {
        return c(i) + a(j);
    }

    public static int a(int i, com.xiaomi.push.a aVar) {
        return c(i) + a(aVar);
    }

    public static int a(int i, e eVar) {
        return c(i) + a(eVar);
    }

    public static int a(int i, String str) {
        return c(i) + a(str);
    }

    public static int a(int i, boolean z) {
        return c(i) + a(z);
    }

    public static int a(long j) {
        return c(j);
    }

    public static int a(com.xiaomi.push.a aVar) {
        return d(aVar.a()) + aVar.a();
    }

    public static int a(e eVar) {
        int b = eVar.b();
        return d(b) + b;
    }

    public static int a(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            return d(bytes.length) + bytes.length;
        } catch (UnsupportedEncodingException unused) {
            throw new RuntimeException("UTF-8 not supported.");
        }
    }

    public static int a(boolean z) {
        return 1;
    }

    public static c a(OutputStream outputStream) {
        return a(outputStream, 4096);
    }

    public static c a(OutputStream outputStream, int i) {
        return new c(outputStream, new byte[i]);
    }

    public static c a(byte[] bArr, int i, int i2) {
        return new c(bArr, i, i2);
    }

    public static int b(int i) {
        return d(i);
    }

    public static int b(int i, int i2) {
        return c(i) + b(i2);
    }

    public static int b(int i, long j) {
        return c(i) + b(j);
    }

    public static int b(long j) {
        return c(j);
    }

    public static int c(int i) {
        return d(f.a(i, 0));
    }

    public static int c(long j) {
        if (((-128) & j) == 0) {
            return 1;
        }
        if (((-16384) & j) == 0) {
            return 2;
        }
        if ((CoroutineScheduler.PARKED_VERSION_MASK & j) == 0) {
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
        return (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    private void c() {
        OutputStream outputStream = this.f159a;
        if (outputStream == null) {
            throw new a();
        }
        outputStream.write(this.f160a, 0, this.b);
        this.b = 0;
    }

    public static int d(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    public int a() {
        if (this.f159a == null) {
            return this.a - this.b;
        }
        throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array.");
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m315a() {
        if (this.f159a != null) {
            c();
        }
    }

    public void a(byte b) {
        if (this.b == this.a) {
            c();
        }
        byte[] bArr = this.f160a;
        int i = this.b;
        this.b = i + 1;
        bArr[i] = b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m316a(int i) {
        if (i >= 0) {
            m335d(i);
        } else {
            m334c(i);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m317a(int i, int i2) {
        c(i, 0);
        m316a(i2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m318a(int i, long j) {
        c(i, 0);
        m323a(j);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m319a(int i, com.xiaomi.push.a aVar) {
        c(i, 2);
        m324a(aVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m320a(int i, e eVar) {
        c(i, 2);
        m325a(eVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m321a(int i, String str) {
        c(i, 2);
        m326a(str);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m322a(int i, boolean z) {
        c(i, 0);
        m327a(z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m323a(long j) {
        m334c(j);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m324a(com.xiaomi.push.a aVar) {
        byte[] m259a = aVar.m259a();
        m335d(m259a.length);
        a(m259a);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m325a(e eVar) {
        m335d(eVar.a());
        eVar.a(this);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m326a(String str) {
        byte[] bytes = str.getBytes("UTF-8");
        m335d(bytes.length);
        a(bytes);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m327a(boolean z) {
        m333c(z ? 1 : 0);
    }

    public void a(byte[] bArr) {
        m328a(bArr, 0, bArr.length);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m328a(byte[] bArr, int i, int i2) {
        int i3 = this.a;
        int i4 = this.b;
        if (i3 - i4 >= i2) {
            System.arraycopy(bArr, i, this.f160a, i4, i2);
            this.b += i2;
            return;
        }
        int i5 = i3 - i4;
        System.arraycopy(bArr, i, this.f160a, i4, i5);
        int i6 = i + i5;
        int i7 = i2 - i5;
        this.b = this.a;
        c();
        if (i7 > this.a) {
            this.f159a.write(bArr, i6, i7);
            return;
        }
        System.arraycopy(bArr, i6, this.f160a, 0, i7);
        this.b = i7;
    }

    public void b() {
        if (a() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m329b(int i) {
        m335d(i);
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m330b(int i, int i2) {
        c(i, 0);
        m329b(i2);
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m331b(int i, long j) {
        c(i, 0);
        m332b(j);
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m332b(long j) {
        m334c(j);
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m333c(int i) {
        a((byte) i);
    }

    public void c(int i, int i2) {
        m335d(f.a(i, i2));
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m334c(long j) {
        while (((-128) & j) != 0) {
            m333c((((int) j) & 127) | 128);
            j >>>= 7;
        }
        m333c((int) j);
    }

    /* renamed from: d  reason: collision with other method in class */
    public void m335d(int i) {
        while ((i & (-128)) != 0) {
            m333c((i & 127) | 128);
            i >>>= 7;
        }
        m333c(i);
    }
}
