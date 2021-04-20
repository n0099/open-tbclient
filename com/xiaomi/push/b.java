package com.xiaomi.push;

import com.google.protobuf.CodedInputStream;
import java.io.InputStream;
import java.util.Vector;
import kotlin.jvm.internal.ByteCompanionObject;
/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public int f40549a;

    /* renamed from: a  reason: collision with other field name */
    public final InputStream f142a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f143a;

    /* renamed from: b  reason: collision with root package name */
    public int f40550b;

    /* renamed from: c  reason: collision with root package name */
    public int f40551c;

    /* renamed from: d  reason: collision with root package name */
    public int f40552d;

    /* renamed from: e  reason: collision with root package name */
    public int f40553e;

    /* renamed from: f  reason: collision with root package name */
    public int f40554f;

    /* renamed from: g  reason: collision with root package name */
    public int f40555g;

    /* renamed from: h  reason: collision with root package name */
    public int f40556h;
    public int i;

    public b(InputStream inputStream) {
        this.f40554f = Integer.MAX_VALUE;
        this.f40556h = 64;
        this.i = CodedInputStream.DEFAULT_SIZE_LIMIT;
        this.f143a = new byte[4096];
        this.f40549a = 0;
        this.f40551c = 0;
        this.f142a = inputStream;
    }

    public b(byte[] bArr, int i, int i2) {
        this.f40554f = Integer.MAX_VALUE;
        this.f40556h = 64;
        this.i = CodedInputStream.DEFAULT_SIZE_LIMIT;
        this.f143a = bArr;
        this.f40549a = i2 + i;
        this.f40551c = i;
        this.f142a = null;
    }

    public static b a(InputStream inputStream) {
        return new b(inputStream);
    }

    public static b a(byte[] bArr, int i, int i2) {
        return new b(bArr, i, i2);
    }

    private boolean a(boolean z) {
        int i = this.f40551c;
        int i2 = this.f40549a;
        if (i >= i2) {
            int i3 = this.f40553e;
            if (i3 + i2 == this.f40554f) {
                if (z) {
                    throw d.a();
                }
                return false;
            }
            this.f40553e = i3 + i2;
            this.f40551c = 0;
            InputStream inputStream = this.f142a;
            int read = inputStream == null ? -1 : inputStream.read(this.f143a);
            this.f40549a = read;
            if (read == 0 || read < -1) {
                throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + this.f40549a + "\nThe InputStream implementation is buggy.");
            } else if (read == -1) {
                this.f40549a = 0;
                if (z) {
                    throw d.a();
                }
                return false;
            } else {
                b();
                int i4 = this.f40553e + this.f40549a + this.f40550b;
                if (i4 > this.i || i4 < 0) {
                    throw d.h();
                }
                return true;
            }
        }
        throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
    }

    private void b() {
        int i = this.f40549a + this.f40550b;
        this.f40549a = i;
        int i2 = this.f40553e + i;
        int i3 = this.f40554f;
        if (i2 <= i3) {
            this.f40550b = 0;
            return;
        }
        int i4 = i2 - i3;
        this.f40550b = i4;
        this.f40549a = i - i4;
    }

    public byte a() {
        if (this.f40551c == this.f40549a) {
            a(true);
        }
        byte[] bArr = this.f143a;
        int i = this.f40551c;
        this.f40551c = i + 1;
        return bArr[i];
    }

    /* renamed from: a  reason: collision with other method in class */
    public int m142a() {
        if (m153b()) {
            this.f40552d = 0;
            return 0;
        }
        int d2 = d();
        this.f40552d = d2;
        if (d2 != 0) {
            return d2;
        }
        throw d.d();
    }

    public int a(int i) {
        if (i >= 0) {
            int i2 = i + this.f40553e + this.f40551c;
            int i3 = this.f40554f;
            if (i2 <= i3) {
                this.f40554f = i2;
                b();
                return i3;
            }
            throw d.a();
        }
        throw d.b();
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m143a() {
        return m154c();
    }

    /* renamed from: a  reason: collision with other method in class */
    public a m144a() {
        int d2 = d();
        int i = this.f40549a;
        int i2 = this.f40551c;
        if (d2 > i - i2 || d2 <= 0) {
            return a.a(m150a(d2));
        }
        a a2 = a.a(this.f143a, i2, d2);
        this.f40551c += d2;
        return a2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m145a() {
        int d2 = d();
        if (d2 > this.f40549a - this.f40551c || d2 <= 0) {
            return new String(m150a(d2), "UTF-8");
        }
        String str = new String(this.f143a, this.f40551c, d2, "UTF-8");
        this.f40551c += d2;
        return str;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m146a() {
        int m142a;
        do {
            m142a = m142a();
            if (m142a == 0) {
                return;
            }
        } while (m149a(m142a));
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m147a(int i) {
        if (this.f40552d != i) {
            throw d.e();
        }
    }

    public void a(e eVar) {
        int d2 = d();
        if (this.f40555g >= this.f40556h) {
            throw d.g();
        }
        int a2 = a(d2);
        this.f40555g++;
        eVar.a(this);
        m147a(0);
        this.f40555g--;
        b(a2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m148a() {
        return d() != 0;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m149a(int i) {
        int a2 = f.a(i);
        if (a2 == 0) {
            m151b();
            return true;
        } else if (a2 == 1) {
            m155d();
            return true;
        } else if (a2 == 2) {
            c(d());
            return true;
        } else if (a2 == 3) {
            m146a();
            m147a(f.a(f.b(i), 4));
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
    public byte[] m150a(int i) {
        if (i < 0) {
            throw d.b();
        }
        int i2 = this.f40553e;
        int i3 = this.f40551c;
        int i4 = i2 + i3 + i;
        int i5 = this.f40554f;
        if (i4 > i5) {
            c((i5 - i2) - i3);
            throw d.a();
        }
        int i6 = this.f40549a;
        if (i <= i6 - i3) {
            byte[] bArr = new byte[i];
            System.arraycopy(this.f143a, i3, bArr, 0, i);
            this.f40551c += i;
            return bArr;
        } else if (i >= 4096) {
            this.f40553e = i2 + i6;
            this.f40551c = 0;
            this.f40549a = 0;
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
                    this.f40553e += read;
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
            this.f40551c = this.f40549a;
            while (true) {
                a(true);
                int i12 = i - i11;
                int i13 = this.f40549a;
                if (i12 <= i13) {
                    System.arraycopy(this.f143a, 0, bArr5, i11, i12);
                    this.f40551c = i12;
                    return bArr5;
                }
                System.arraycopy(this.f143a, 0, bArr5, i11, i13);
                int i14 = this.f40549a;
                i11 += i14;
                this.f40551c = i14;
            }
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public int m151b() {
        return d();
    }

    /* renamed from: b  reason: collision with other method in class */
    public long m152b() {
        return m154c();
    }

    public void b(int i) {
        this.f40554f = i;
        b();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m153b() {
        return this.f40551c == this.f40549a && !a(false);
    }

    public int c() {
        return d();
    }

    /* renamed from: c  reason: collision with other method in class */
    public long m154c() {
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
        int i2 = this.f40553e;
        int i3 = this.f40551c;
        int i4 = i2 + i3 + i;
        int i5 = this.f40554f;
        if (i4 > i5) {
            c((i5 - i2) - i3);
            throw d.a();
        }
        int i6 = this.f40549a;
        if (i <= i6 - i3) {
            this.f40551c = i3 + i;
            return;
        }
        int i7 = i6 - i3;
        this.f40553e = i2 + i6;
        this.f40551c = 0;
        this.f40549a = 0;
        while (i7 < i) {
            InputStream inputStream = this.f142a;
            int skip = inputStream == null ? -1 : (int) inputStream.skip(i - i7);
            if (skip <= 0) {
                throw d.a();
            }
            i7 += skip;
            this.f40553e += skip;
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
    public long m155d() {
        byte a2 = a();
        byte a3 = a();
        return ((a3 & 255) << 8) | (a2 & 255) | ((a() & 255) << 16) | ((a() & 255) << 24) | ((a() & 255) << 32) | ((a() & 255) << 40) | ((a() & 255) << 48) | ((a() & 255) << 56);
    }

    public int e() {
        return (a() & 255) | ((a() & 255) << 8) | ((a() & 255) << 16) | ((a() & 255) << 24);
    }
}
