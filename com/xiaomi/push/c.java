package com.xiaomi.push;

import com.alibaba.fastjson.asm.Label;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import kotlinx.coroutines.scheduling.CoroutineScheduler;
/* loaded from: classes7.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final int f38203a;

    /* renamed from: a  reason: collision with other field name */
    public final OutputStream f167a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f168a;

    /* renamed from: b  reason: collision with root package name */
    public int f38204b;

    /* loaded from: classes7.dex */
    public static class a extends IOException {
        public a() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    public c(OutputStream outputStream, byte[] bArr) {
        this.f167a = outputStream;
        this.f168a = bArr;
        this.f38204b = 0;
        this.f38203a = bArr.length;
    }

    public c(byte[] bArr, int i2, int i3) {
        this.f167a = null;
        this.f168a = bArr;
        this.f38204b = i2;
        this.f38203a = i2 + i3;
    }

    public static int a(int i2) {
        if (i2 >= 0) {
            return d(i2);
        }
        return 10;
    }

    public static int a(int i2, int i3) {
        return c(i2) + a(i3);
    }

    public static int a(int i2, long j) {
        return c(i2) + a(j);
    }

    public static int a(int i2, com.xiaomi.push.a aVar) {
        return c(i2) + a(aVar);
    }

    public static int a(int i2, e eVar) {
        return c(i2) + a(eVar);
    }

    public static int a(int i2, String str) {
        return c(i2) + a(str);
    }

    public static int a(int i2, boolean z) {
        return c(i2) + a(z);
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

    public static c a(OutputStream outputStream, int i2) {
        return new c(outputStream, new byte[i2]);
    }

    public static c a(byte[] bArr, int i2, int i3) {
        return new c(bArr, i2, i3);
    }

    public static int b(int i2) {
        return d(i2);
    }

    public static int b(int i2, int i3) {
        return c(i2) + b(i3);
    }

    public static int b(int i2, long j) {
        return c(i2) + b(j);
    }

    public static int b(long j) {
        return c(j);
    }

    public static int c(int i2) {
        return d(f.a(i2, 0));
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
        OutputStream outputStream = this.f167a;
        if (outputStream == null) {
            throw new a();
        }
        outputStream.write(this.f168a, 0, this.f38204b);
        this.f38204b = 0;
    }

    public static int d(int i2) {
        if ((i2 & com.alipay.sdk.encrypt.a.f1872g) == 0) {
            return 1;
        }
        if ((i2 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i2) == 0) {
            return 3;
        }
        return (i2 & Label.FORWARD_REFERENCE_TYPE_MASK) == 0 ? 4 : 5;
    }

    public int a() {
        if (this.f167a == null) {
            return this.f38203a - this.f38204b;
        }
        throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array.");
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m181a() {
        if (this.f167a != null) {
            c();
        }
    }

    public void a(byte b2) {
        if (this.f38204b == this.f38203a) {
            c();
        }
        byte[] bArr = this.f168a;
        int i2 = this.f38204b;
        this.f38204b = i2 + 1;
        bArr[i2] = b2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m182a(int i2) {
        if (i2 >= 0) {
            m201d(i2);
        } else {
            m200c(i2);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m183a(int i2, int i3) {
        c(i2, 0);
        m182a(i3);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m184a(int i2, long j) {
        c(i2, 0);
        m189a(j);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m185a(int i2, com.xiaomi.push.a aVar) {
        c(i2, 2);
        m190a(aVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m186a(int i2, e eVar) {
        c(i2, 2);
        m191a(eVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m187a(int i2, String str) {
        c(i2, 2);
        m192a(str);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m188a(int i2, boolean z) {
        c(i2, 0);
        m193a(z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m189a(long j) {
        m200c(j);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m190a(com.xiaomi.push.a aVar) {
        byte[] m125a = aVar.m125a();
        m201d(m125a.length);
        a(m125a);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m191a(e eVar) {
        m201d(eVar.a());
        eVar.a(this);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m192a(String str) {
        byte[] bytes = str.getBytes("UTF-8");
        m201d(bytes.length);
        a(bytes);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m193a(boolean z) {
        m199c(z ? 1 : 0);
    }

    public void a(byte[] bArr) {
        m194a(bArr, 0, bArr.length);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m194a(byte[] bArr, int i2, int i3) {
        int i4 = this.f38203a;
        int i5 = this.f38204b;
        if (i4 - i5 >= i3) {
            System.arraycopy(bArr, i2, this.f168a, i5, i3);
            this.f38204b += i3;
            return;
        }
        int i6 = i4 - i5;
        System.arraycopy(bArr, i2, this.f168a, i5, i6);
        int i7 = i2 + i6;
        int i8 = i3 - i6;
        this.f38204b = this.f38203a;
        c();
        if (i8 > this.f38203a) {
            this.f167a.write(bArr, i7, i8);
            return;
        }
        System.arraycopy(bArr, i7, this.f168a, 0, i8);
        this.f38204b = i8;
    }

    public void b() {
        if (a() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m195b(int i2) {
        m201d(i2);
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m196b(int i2, int i3) {
        c(i2, 0);
        m195b(i3);
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m197b(int i2, long j) {
        c(i2, 0);
        m198b(j);
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m198b(long j) {
        m200c(j);
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m199c(int i2) {
        a((byte) i2);
    }

    public void c(int i2, int i3) {
        m201d(f.a(i2, i3));
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m200c(long j) {
        while (((-128) & j) != 0) {
            m199c((((int) j) & 127) | 128);
            j >>>= 7;
        }
        m199c((int) j);
    }

    /* renamed from: d  reason: collision with other method in class */
    public void m201d(int i2) {
        while ((i2 & com.alipay.sdk.encrypt.a.f1872g) != 0) {
            m199c((i2 & 127) | 128);
            i2 >>>= 7;
        }
        m199c(i2);
    }
}
