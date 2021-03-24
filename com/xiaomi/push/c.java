package com.xiaomi.push;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
/* loaded from: classes7.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final int f40302a;

    /* renamed from: a  reason: collision with other field name */
    public final OutputStream f167a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f168a;

    /* renamed from: b  reason: collision with root package name */
    public int f40303b;

    /* loaded from: classes7.dex */
    public static class a extends IOException {
        public a() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    public c(OutputStream outputStream, byte[] bArr) {
        this.f167a = outputStream;
        this.f168a = bArr;
        this.f40303b = 0;
        this.f40302a = bArr.length;
    }

    public c(byte[] bArr, int i, int i2) {
        this.f167a = null;
        this.f168a = bArr;
        this.f40303b = i;
        this.f40302a = i + i2;
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
        return d(b2) + b2;
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
        return (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    private void c() {
        OutputStream outputStream = this.f167a;
        if (outputStream == null) {
            throw new a();
        }
        outputStream.write(this.f168a, 0, this.f40303b);
        this.f40303b = 0;
    }

    public static int d(int i) {
        if ((i & com.alipay.sdk.encrypt.a.f1896g) == 0) {
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
        if (this.f167a == null) {
            return this.f40302a - this.f40303b;
        }
        throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array.");
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m174a() {
        if (this.f167a != null) {
            c();
        }
    }

    public void a(byte b2) {
        if (this.f40303b == this.f40302a) {
            c();
        }
        byte[] bArr = this.f168a;
        int i = this.f40303b;
        this.f40303b = i + 1;
        bArr[i] = b2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m175a(int i) {
        if (i >= 0) {
            m194d(i);
        } else {
            m193c(i);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m176a(int i, int i2) {
        c(i, 0);
        m175a(i2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m177a(int i, long j) {
        c(i, 0);
        m182a(j);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m178a(int i, com.xiaomi.push.a aVar) {
        c(i, 2);
        m183a(aVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m179a(int i, e eVar) {
        c(i, 2);
        m184a(eVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m180a(int i, String str) {
        c(i, 2);
        m185a(str);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m181a(int i, boolean z) {
        c(i, 0);
        m186a(z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m182a(long j) {
        m193c(j);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m183a(com.xiaomi.push.a aVar) {
        byte[] m118a = aVar.m118a();
        m194d(m118a.length);
        a(m118a);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m184a(e eVar) {
        m194d(eVar.a());
        eVar.a(this);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m185a(String str) {
        byte[] bytes = str.getBytes("UTF-8");
        m194d(bytes.length);
        a(bytes);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m186a(boolean z) {
        m192c(z ? 1 : 0);
    }

    public void a(byte[] bArr) {
        m187a(bArr, 0, bArr.length);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m187a(byte[] bArr, int i, int i2) {
        int i3 = this.f40302a;
        int i4 = this.f40303b;
        if (i3 - i4 >= i2) {
            System.arraycopy(bArr, i, this.f168a, i4, i2);
            this.f40303b += i2;
            return;
        }
        int i5 = i3 - i4;
        System.arraycopy(bArr, i, this.f168a, i4, i5);
        int i6 = i + i5;
        int i7 = i2 - i5;
        this.f40303b = this.f40302a;
        c();
        if (i7 > this.f40302a) {
            this.f167a.write(bArr, i6, i7);
            return;
        }
        System.arraycopy(bArr, i6, this.f168a, 0, i7);
        this.f40303b = i7;
    }

    public void b() {
        if (a() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m188b(int i) {
        m194d(i);
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m189b(int i, int i2) {
        c(i, 0);
        m188b(i2);
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m190b(int i, long j) {
        c(i, 0);
        m191b(j);
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m191b(long j) {
        m193c(j);
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m192c(int i) {
        a((byte) i);
    }

    public void c(int i, int i2) {
        m194d(f.a(i, i2));
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m193c(long j) {
        while (((-128) & j) != 0) {
            m192c((((int) j) & 127) | 128);
            j >>>= 7;
        }
        m192c((int) j);
    }

    /* renamed from: d  reason: collision with other method in class */
    public void m194d(int i) {
        while ((i & com.alipay.sdk.encrypt.a.f1896g) != 0) {
            m192c((i & 127) | 128);
            i >>>= 7;
        }
        m192c(i);
    }
}
