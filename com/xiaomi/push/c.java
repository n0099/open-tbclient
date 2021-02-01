package com.xiaomi.push;

import com.thunder.livesdk.system.ThunderNetStateService;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final int f13900a;

    /* renamed from: a  reason: collision with other field name */
    private final OutputStream f224a;

    /* renamed from: a  reason: collision with other field name */
    private final byte[] f225a;

    /* renamed from: b  reason: collision with root package name */
    private int f13901b;

    /* loaded from: classes6.dex */
    public static class a extends IOException {
        a() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    private c(OutputStream outputStream, byte[] bArr) {
        this.f224a = outputStream;
        this.f225a = bArr;
        this.f13901b = 0;
        this.f13900a = bArr.length;
    }

    private c(byte[] bArr, int i, int i2) {
        this.f224a = null;
        this.f225a = bArr;
        this.f13901b = i;
        this.f13900a = i + i2;
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
        if (this.f224a == null) {
            throw new a();
        }
        this.f224a.write(this.f225a, 0, this.f13901b);
        this.f13901b = 0;
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
        if (this.f224a == null) {
            return this.f13900a - this.f13901b;
        }
        throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array.");
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m202a() {
        if (this.f224a != null) {
            c();
        }
    }

    public void a(byte b2) {
        if (this.f13901b == this.f13900a) {
            c();
        }
        byte[] bArr = this.f225a;
        int i = this.f13901b;
        this.f13901b = i + 1;
        bArr[i] = b2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m203a(int i) {
        if (i >= 0) {
            m222d(i);
        } else {
            m221c(i);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m204a(int i, int i2) {
        c(i, 0);
        m203a(i2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m205a(int i, long j) {
        c(i, 0);
        m210a(j);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m206a(int i, com.xiaomi.push.a aVar) {
        c(i, 2);
        m211a(aVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m207a(int i, e eVar) {
        c(i, 2);
        m212a(eVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m208a(int i, String str) {
        c(i, 2);
        m213a(str);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m209a(int i, boolean z) {
        c(i, 0);
        m214a(z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m210a(long j) {
        m221c(j);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m211a(com.xiaomi.push.a aVar) {
        byte[] m149a = aVar.m149a();
        m222d(m149a.length);
        a(m149a);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m212a(e eVar) {
        m222d(eVar.a());
        eVar.a(this);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m213a(String str) {
        byte[] bytes = str.getBytes("UTF-8");
        m222d(bytes.length);
        a(bytes);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m214a(boolean z) {
        m220c(z ? 1 : 0);
    }

    public void a(byte[] bArr) {
        m215a(bArr, 0, bArr.length);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m215a(byte[] bArr, int i, int i2) {
        if (this.f13900a - this.f13901b >= i2) {
            System.arraycopy(bArr, i, this.f225a, this.f13901b, i2);
            this.f13901b += i2;
            return;
        }
        int i3 = this.f13900a - this.f13901b;
        System.arraycopy(bArr, i, this.f225a, this.f13901b, i3);
        int i4 = i + i3;
        int i5 = i2 - i3;
        this.f13901b = this.f13900a;
        c();
        if (i5 > this.f13900a) {
            this.f224a.write(bArr, i4, i5);
            return;
        }
        System.arraycopy(bArr, i4, this.f225a, 0, i5);
        this.f13901b = i5;
    }

    public void b() {
        if (a() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m216b(int i) {
        m222d(i);
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m217b(int i, int i2) {
        c(i, 0);
        m216b(i2);
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m218b(int i, long j) {
        c(i, 0);
        m219b(j);
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m219b(long j) {
        m221c(j);
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m220c(int i) {
        a((byte) i);
    }

    public void c(int i, int i2) {
        m222d(f.a(i, i2));
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m221c(long j) {
        while (((-128) & j) != 0) {
            m220c((((int) j) & ThunderNetStateService.NetState.SYSNET_UNKNOWN) | 128);
            j >>>= 7;
        }
        m220c((int) j);
    }

    /* renamed from: d  reason: collision with other method in class */
    public void m222d(int i) {
        while ((i & (-128)) != 0) {
            m220c((i & ThunderNetStateService.NetState.SYSNET_UNKNOWN) | 128);
            i >>>= 7;
        }
        m220c(i);
    }
}
