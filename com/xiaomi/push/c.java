package com.xiaomi.push;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
/* loaded from: classes12.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final int f4828a;

    /* renamed from: a  reason: collision with other field name */
    private final OutputStream f146a;

    /* renamed from: a  reason: collision with other field name */
    private final byte[] f147a;
    private int b;

    /* loaded from: classes12.dex */
    public static class a extends IOException {
        a() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    private c(OutputStream outputStream, byte[] bArr) {
        this.f146a = outputStream;
        this.f147a = bArr;
        this.b = 0;
        this.f4828a = bArr.length;
    }

    private c(byte[] bArr, int i, int i2) {
        this.f146a = null;
        this.f147a = bArr;
        this.b = i;
        this.f4828a = i + i2;
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
        return b + d(b);
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
        if (this.f146a == null) {
            throw new a();
        }
        this.f146a.write(this.f147a, 0, this.b);
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
        return ((-268435456) & i) == 0 ? 4 : 5;
    }

    public int a() {
        if (this.f146a == null) {
            return this.f4828a - this.b;
        }
        throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array.");
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m177a() {
        if (this.f146a != null) {
            c();
        }
    }

    public void a(byte b) {
        if (this.b == this.f4828a) {
            c();
        }
        byte[] bArr = this.f147a;
        int i = this.b;
        this.b = i + 1;
        bArr[i] = b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m178a(int i) {
        if (i >= 0) {
            m197d(i);
        } else {
            m196c(i);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m179a(int i, int i2) {
        c(i, 0);
        m178a(i2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m180a(int i, long j) {
        c(i, 0);
        m185a(j);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m181a(int i, com.xiaomi.push.a aVar) {
        c(i, 2);
        m186a(aVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m182a(int i, e eVar) {
        c(i, 2);
        m187a(eVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m183a(int i, String str) {
        c(i, 2);
        m188a(str);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m184a(int i, boolean z) {
        c(i, 0);
        m189a(z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m185a(long j) {
        m196c(j);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m186a(com.xiaomi.push.a aVar) {
        byte[] m124a = aVar.m124a();
        m197d(m124a.length);
        a(m124a);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m187a(e eVar) {
        m197d(eVar.a());
        eVar.a(this);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m188a(String str) {
        byte[] bytes = str.getBytes("UTF-8");
        m197d(bytes.length);
        a(bytes);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m189a(boolean z) {
        m195c(z ? 1 : 0);
    }

    public void a(byte[] bArr) {
        m190a(bArr, 0, bArr.length);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m190a(byte[] bArr, int i, int i2) {
        if (this.f4828a - this.b >= i2) {
            System.arraycopy(bArr, i, this.f147a, this.b, i2);
            this.b += i2;
            return;
        }
        int i3 = this.f4828a - this.b;
        System.arraycopy(bArr, i, this.f147a, this.b, i3);
        int i4 = i + i3;
        int i5 = i2 - i3;
        this.b = this.f4828a;
        c();
        if (i5 > this.f4828a) {
            this.f146a.write(bArr, i4, i5);
            return;
        }
        System.arraycopy(bArr, i4, this.f147a, 0, i5);
        this.b = i5;
    }

    public void b() {
        if (a() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m191b(int i) {
        m197d(i);
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m192b(int i, int i2) {
        c(i, 0);
        m191b(i2);
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m193b(int i, long j) {
        c(i, 0);
        m194b(j);
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m194b(long j) {
        m196c(j);
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m195c(int i) {
        a((byte) i);
    }

    public void c(int i, int i2) {
        m197d(f.a(i, i2));
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m196c(long j) {
        while (((-128) & j) != 0) {
            m195c((((int) j) & 127) | 128);
            j >>>= 7;
        }
        m195c((int) j);
    }

    /* renamed from: d  reason: collision with other method in class */
    public void m197d(int i) {
        while ((i & (-128)) != 0) {
            m195c((i & 127) | 128);
            i >>>= 7;
        }
        m195c(i);
    }
}
