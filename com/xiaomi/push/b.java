package com.xiaomi.push;

import com.google.protobuf.CodedInputStream;
import java.io.InputStream;
import java.util.Vector;
import kotlin.jvm.internal.ByteCompanionObject;
/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public int f40260a;

    /* renamed from: a  reason: collision with other field name */
    public final InputStream f142a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f143a;

    /* renamed from: b  reason: collision with root package name */
    public int f40261b;

    /* renamed from: c  reason: collision with root package name */
    public int f40262c;

    /* renamed from: d  reason: collision with root package name */
    public int f40263d;

    /* renamed from: e  reason: collision with root package name */
    public int f40264e;

    /* renamed from: f  reason: collision with root package name */
    public int f40265f;

    /* renamed from: g  reason: collision with root package name */
    public int f40266g;

    /* renamed from: h  reason: collision with root package name */
    public int f40267h;
    public int i;

    public b(InputStream inputStream) {
        this.f40265f = Integer.MAX_VALUE;
        this.f40267h = 64;
        this.i = CodedInputStream.DEFAULT_SIZE_LIMIT;
        this.f143a = new byte[4096];
        this.f40260a = 0;
        this.f40262c = 0;
        this.f142a = inputStream;
    }

    public b(byte[] bArr, int i, int i2) {
        this.f40265f = Integer.MAX_VALUE;
        this.f40267h = 64;
        this.i = CodedInputStream.DEFAULT_SIZE_LIMIT;
        this.f143a = bArr;
        this.f40260a = i2 + i;
        this.f40262c = i;
        this.f142a = null;
    }

    public static b a(InputStream inputStream) {
        return new b(inputStream);
    }

    public static b a(byte[] bArr, int i, int i2) {
        return new b(bArr, i, i2);
    }

    private boolean a(boolean z) {
        int i = this.f40262c;
        int i2 = this.f40260a;
        if (i >= i2) {
            int i3 = this.f40264e;
            if (i3 + i2 == this.f40265f) {
                if (z) {
                    throw d.a();
                }
                return false;
            }
            this.f40264e = i3 + i2;
            this.f40262c = 0;
            InputStream inputStream = this.f142a;
            int read = inputStream == null ? -1 : inputStream.read(this.f143a);
            this.f40260a = read;
            if (read == 0 || read < -1) {
                throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + this.f40260a + "\nThe InputStream implementation is buggy.");
            } else if (read == -1) {
                this.f40260a = 0;
                if (z) {
                    throw d.a();
                }
                return false;
            } else {
                b();
                int i4 = this.f40264e + this.f40260a + this.f40261b;
                if (i4 > this.i || i4 < 0) {
                    throw d.h();
                }
                return true;
            }
        }
        throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
    }

    private void b() {
        int i = this.f40260a + this.f40261b;
        this.f40260a = i;
        int i2 = this.f40264e + i;
        int i3 = this.f40265f;
        if (i2 <= i3) {
            this.f40261b = 0;
            return;
        }
        int i4 = i2 - i3;
        this.f40261b = i4;
        this.f40260a = i - i4;
    }

    public byte a() {
        if (this.f40262c == this.f40260a) {
            a(true);
        }
        byte[] bArr = this.f143a;
        int i = this.f40262c;
        this.f40262c = i + 1;
        return bArr[i];
    }

    /* renamed from: a  reason: collision with other method in class */
    public int m138a() {
        if (m149b()) {
            this.f40263d = 0;
            return 0;
        }
        int d2 = d();
        this.f40263d = d2;
        if (d2 != 0) {
            return d2;
        }
        throw d.d();
    }

    public int a(int i) {
        if (i >= 0) {
            int i2 = i + this.f40264e + this.f40262c;
            int i3 = this.f40265f;
            if (i2 <= i3) {
                this.f40265f = i2;
                b();
                return i3;
            }
            throw d.a();
        }
        throw d.b();
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m139a() {
        return m150c();
    }

    /* renamed from: a  reason: collision with other method in class */
    public a m140a() {
        int d2 = d();
        int i = this.f40260a;
        int i2 = this.f40262c;
        if (d2 > i - i2 || d2 <= 0) {
            return a.a(m146a(d2));
        }
        a a2 = a.a(this.f143a, i2, d2);
        this.f40262c += d2;
        return a2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m141a() {
        int d2 = d();
        if (d2 > this.f40260a - this.f40262c || d2 <= 0) {
            return new String(m146a(d2), "UTF-8");
        }
        String str = new String(this.f143a, this.f40262c, d2, "UTF-8");
        this.f40262c += d2;
        return str;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m142a() {
        int m138a;
        do {
            m138a = m138a();
            if (m138a == 0) {
                return;
            }
        } while (m145a(m138a));
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m143a(int i) {
        if (this.f40263d != i) {
            throw d.e();
        }
    }

    public void a(e eVar) {
        int d2 = d();
        if (this.f40266g >= this.f40267h) {
            throw d.g();
        }
        int a2 = a(d2);
        this.f40266g++;
        eVar.a(this);
        m143a(0);
        this.f40266g--;
        b(a2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m144a() {
        return d() != 0;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m145a(int i) {
        int a2 = f.a(i);
        if (a2 == 0) {
            m147b();
            return true;
        } else if (a2 == 1) {
            m151d();
            return true;
        } else if (a2 == 2) {
            c(d());
            return true;
        } else if (a2 == 3) {
            m142a();
            m143a(f.a(f.b(i), 4));
            return true;
        } else if (a2 != 4) {
            if (a2 == 5) {
                e();
                return true;
            }
            throw d.f();
        } else {
            return false;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m146a(int i) {
        if (i < 0) {
            throw d.b();
        }
        int i2 = this.f40264e;
        int i3 = this.f40262c;
        int i4 = i2 + i3 + i;
        int i5 = this.f40265f;
        if (i4 > i5) {
            c((i5 - i2) - i3);
            throw d.a();
        }
        int i6 = this.f40260a;
        if (i <= i6 - i3) {
            byte[] bArr = new byte[i];
            System.arraycopy(this.f143a, i3, bArr, 0, i);
            this.f40262c += i;
            return bArr;
        } else if (i >= 4096) {
            this.f40264e = i2 + i6;
            this.f40262c = 0;
            this.f40260a = 0;
            int i7 = i6 - i3;
            int i8 = i - i7;
            Vector vector = new Vector();
            while (i8 > 0) {
                int min = Math.min(i8, 4096);
                byte[] bArr2 = new byte[min];
                int i9 = 0;
                while (i9 < min) {
                    InputStream inputStream = this.f142a;
                    int read = inputStream == null ? -1 : inputStream.read(bArr2, i9, min - i9);
                    if (read == -1) {
                        throw d.a();
                    }
                    this.f40264e += read;
                    i9 += read;
                }
                i8 -= min;
                vector.addElement(bArr2);
            }
            byte[] bArr3 = new byte[i];
            System.arraycopy(this.f143a, i3, bArr3, 0, i7);
            for (int i10 = 0; i10 < vector.size(); i10++) {
                byte[] bArr4 = (byte[]) vector.elementAt(i10);
                System.arraycopy(bArr4, 0, bArr3, i7, bArr4.length);
                i7 += bArr4.length;
            }
            return bArr3;
        } else {
            byte[] bArr5 = new byte[i];
            int i11 = i6 - i3;
            System.arraycopy(this.f143a, i3, bArr5, 0, i11);
            this.f40262c = this.f40260a;
            while (true) {
                a(true);
                int i12 = i - i11;
                int i13 = this.f40260a;
                if (i12 <= i13) {
                    System.arraycopy(this.f143a, 0, bArr5, i11, i12);
                    this.f40262c = i12;
                    return bArr5;
                }
                System.arraycopy(this.f143a, 0, bArr5, i11, i13);
                int i14 = this.f40260a;
                i11 += i14;
                this.f40262c = i14;
            }
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public int m147b() {
        return d();
    }

    /* renamed from: b  reason: collision with other method in class */
    public long m148b() {
        return m150c();
    }

    public void b(int i) {
        this.f40265f = i;
        b();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m149b() {
        return this.f40262c == this.f40260a && !a(false);
    }

    public int c() {
        return d();
    }

    /* renamed from: c  reason: collision with other method in class */
    public long m150c() {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte a2 = a();
            j |= (a2 & ByteCompanionObject.MAX_VALUE) << i;
            if ((a2 & ByteCompanionObject.MIN_VALUE) == 0) {
                return j;
            }
        }
        throw d.c();
    }

    public void c(int i) {
        if (i < 0) {
            throw d.b();
        }
        int i2 = this.f40264e;
        int i3 = this.f40262c;
        int i4 = i2 + i3 + i;
        int i5 = this.f40265f;
        if (i4 > i5) {
            c((i5 - i2) - i3);
            throw d.a();
        }
        int i6 = this.f40260a;
        if (i <= i6 - i3) {
            this.f40262c = i3 + i;
            return;
        }
        int i7 = i6 - i3;
        this.f40264e = i2 + i6;
        this.f40262c = 0;
        this.f40260a = 0;
        while (i7 < i) {
            InputStream inputStream = this.f142a;
            int skip = inputStream == null ? -1 : (int) inputStream.skip(i - i7);
            if (skip <= 0) {
                throw d.a();
            }
            i7 += skip;
            this.f40264e += skip;
        }
    }

    public int d() {
        int i;
        byte a2 = a();
        if (a2 >= 0) {
            return a2;
        }
        int i2 = a2 & ByteCompanionObject.MAX_VALUE;
        byte a3 = a();
        if (a3 >= 0) {
            i = a3 << 7;
        } else {
            i2 |= (a3 & ByteCompanionObject.MAX_VALUE) << 7;
            byte a4 = a();
            if (a4 >= 0) {
                i = a4 << 14;
            } else {
                i2 |= (a4 & ByteCompanionObject.MAX_VALUE) << 14;
                byte a5 = a();
                if (a5 < 0) {
                    int i3 = i2 | ((a5 & ByteCompanionObject.MAX_VALUE) << 21);
                    byte a6 = a();
                    int i4 = i3 | (a6 << 28);
                    if (a6 < 0) {
                        for (int i5 = 0; i5 < 5; i5++) {
                            if (a() >= 0) {
                                return i4;
                            }
                        }
                        throw d.c();
                    }
                    return i4;
                }
                i = a5 << 21;
            }
        }
        return i2 | i;
    }

    /* renamed from: d  reason: collision with other method in class */
    public long m151d() {
        byte a2 = a();
        byte a3 = a();
        return ((a3 & 255) << 8) | (a2 & 255) | ((a() & 255) << 16) | ((a() & 255) << 24) | ((a() & 255) << 32) | ((a() & 255) << 40) | ((a() & 255) << 48) | ((a() & 255) << 56);
    }

    public int e() {
        return (a() & 255) | ((a() & 255) << 8) | ((a() & 255) << 16) | ((a() & 255) << 24);
    }
}
