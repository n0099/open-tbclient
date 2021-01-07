package com.xiaomi.push;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final int f14198a;

    /* renamed from: a  reason: collision with other field name */
    private final OutputStream f225a;

    /* renamed from: a  reason: collision with other field name */
    private final byte[] f226a;

    /* renamed from: b  reason: collision with root package name */
    private int f14199b;

    /* loaded from: classes6.dex */
    public static class a extends IOException {
        a() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    private c(OutputStream outputStream, byte[] bArr) {
        this.f225a = outputStream;
        this.f226a = bArr;
        this.f14199b = 0;
        this.f14198a = bArr.length;
    }

    private c(byte[] bArr, int i, int i2) {
        this.f225a = null;
        this.f226a = bArr;
        this.f14199b = i;
        this.f14198a = i + i2;
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
        int b2 = eVar.b();
        return b2 + d(b2);
    }

    public static int a(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            return bytes.length + d(bytes.length);
        } catch (UnsupportedEncodingException e) {
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

    private void c() {
        if (this.f225a == null) {
            throw new a();
        }
        this.f225a.write(this.f226a, 0, this.f14199b);
        this.f14199b = 0;
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
        return ((-268435456) & i) == 0 ? 4 : 5;
    }

    public int a() {
        if (this.f225a == null) {
            return this.f14198a - this.f14199b;
        }
        throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array.");
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m206a() {
        if (this.f225a != null) {
            c();
        }
    }

    public void a(byte b2) {
        if (this.f14199b == this.f14198a) {
            c();
        }
        byte[] bArr = this.f226a;
        int i = this.f14199b;
        this.f14199b = i + 1;
        bArr[i] = b2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m207a(int i) {
        if (i >= 0) {
            m226d(i);
        } else {
            m225c(i);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m208a(int i, int i2) {
        c(i, 0);
        m207a(i2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m209a(int i, long j) {
        c(i, 0);
        m214a(j);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m210a(int i, com.xiaomi.push.a aVar) {
        c(i, 2);
        m215a(aVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m211a(int i, e eVar) {
        c(i, 2);
        m216a(eVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m212a(int i, String str) {
        c(i, 2);
        m217a(str);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m213a(int i, boolean z) {
        c(i, 0);
        m218a(z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m214a(long j) {
        m225c(j);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m215a(com.xiaomi.push.a aVar) {
        byte[] m153a = aVar.m153a();
        m226d(m153a.length);
        a(m153a);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m216a(e eVar) {
        m226d(eVar.a());
        eVar.a(this);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m217a(String str) {
        byte[] bytes = str.getBytes("UTF-8");
        m226d(bytes.length);
        a(bytes);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m218a(boolean z) {
        m224c(z ? 1 : 0);
    }

    public void a(byte[] bArr) {
        m219a(bArr, 0, bArr.length);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m219a(byte[] bArr, int i, int i2) {
        if (this.f14198a - this.f14199b >= i2) {
            System.arraycopy(bArr, i, this.f226a, this.f14199b, i2);
            this.f14199b += i2;
            return;
        }
        int i3 = this.f14198a - this.f14199b;
        System.arraycopy(bArr, i, this.f226a, this.f14199b, i3);
        int i4 = i + i3;
        int i5 = i2 - i3;
        this.f14199b = this.f14198a;
        c();
        if (i5 > this.f14198a) {
            this.f225a.write(bArr, i4, i5);
            return;
        }
        System.arraycopy(bArr, i4, this.f226a, 0, i5);
        this.f14199b = i5;
    }

    public void b() {
        if (a() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m220b(int i) {
        m226d(i);
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m221b(int i, int i2) {
        c(i, 0);
        m220b(i2);
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m222b(int i, long j) {
        c(i, 0);
        m223b(j);
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m223b(long j) {
        m225c(j);
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m224c(int i) {
        a((byte) i);
    }

    public void c(int i, int i2) {
        m226d(f.a(i, i2));
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m225c(long j) {
        while (((-128) & j) != 0) {
            m224c((((int) j) & 127) | 128);
            j >>>= 7;
        }
        m224c((int) j);
    }

    /* renamed from: d  reason: collision with other method in class */
    public void m226d(int i) {
        while ((i & (-128)) != 0) {
            m224c((i & 127) | 128);
            i >>>= 7;
        }
        m224c(i);
    }
}
