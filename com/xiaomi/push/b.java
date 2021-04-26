package com.xiaomi.push;

import com.google.protobuf.CodedInputStream;
import java.io.InputStream;
import java.util.Vector;
import kotlin.jvm.internal.ByteCompanionObject;
/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public int f38159a;

    /* renamed from: a  reason: collision with other field name */
    public final InputStream f142a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f143a;

    /* renamed from: b  reason: collision with root package name */
    public int f38160b;

    /* renamed from: c  reason: collision with root package name */
    public int f38161c;

    /* renamed from: d  reason: collision with root package name */
    public int f38162d;

    /* renamed from: e  reason: collision with root package name */
    public int f38163e;

    /* renamed from: f  reason: collision with root package name */
    public int f38164f;

    /* renamed from: g  reason: collision with root package name */
    public int f38165g;

    /* renamed from: h  reason: collision with root package name */
    public int f38166h;

    /* renamed from: i  reason: collision with root package name */
    public int f38167i;

    public b(InputStream inputStream) {
        this.f38164f = Integer.MAX_VALUE;
        this.f38166h = 64;
        this.f38167i = CodedInputStream.DEFAULT_SIZE_LIMIT;
        this.f143a = new byte[4096];
        this.f38159a = 0;
        this.f38161c = 0;
        this.f142a = inputStream;
    }

    public b(byte[] bArr, int i2, int i3) {
        this.f38164f = Integer.MAX_VALUE;
        this.f38166h = 64;
        this.f38167i = CodedInputStream.DEFAULT_SIZE_LIMIT;
        this.f143a = bArr;
        this.f38159a = i3 + i2;
        this.f38161c = i2;
        this.f142a = null;
    }

    public static b a(InputStream inputStream) {
        return new b(inputStream);
    }

    public static b a(byte[] bArr, int i2, int i3) {
        return new b(bArr, i2, i3);
    }

    private boolean a(boolean z) {
        int i2 = this.f38161c;
        int i3 = this.f38159a;
        if (i2 >= i3) {
            int i4 = this.f38163e;
            if (i4 + i3 == this.f38164f) {
                if (z) {
                    throw d.a();
                }
                return false;
            }
            this.f38163e = i4 + i3;
            this.f38161c = 0;
            InputStream inputStream = this.f142a;
            int read = inputStream == null ? -1 : inputStream.read(this.f143a);
            this.f38159a = read;
            if (read == 0 || read < -1) {
                throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + this.f38159a + "\nThe InputStream implementation is buggy.");
            } else if (read == -1) {
                this.f38159a = 0;
                if (z) {
                    throw d.a();
                }
                return false;
            } else {
                b();
                int i5 = this.f38163e + this.f38159a + this.f38160b;
                if (i5 > this.f38167i || i5 < 0) {
                    throw d.h();
                }
                return true;
            }
        }
        throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
    }

    private void b() {
        int i2 = this.f38159a + this.f38160b;
        this.f38159a = i2;
        int i3 = this.f38163e + i2;
        int i4 = this.f38164f;
        if (i3 <= i4) {
            this.f38160b = 0;
            return;
        }
        int i5 = i3 - i4;
        this.f38160b = i5;
        this.f38159a = i2 - i5;
    }

    public byte a() {
        if (this.f38161c == this.f38159a) {
            a(true);
        }
        byte[] bArr = this.f143a;
        int i2 = this.f38161c;
        this.f38161c = i2 + 1;
        return bArr[i2];
    }

    /* renamed from: a  reason: collision with other method in class */
    public int m145a() {
        if (m156b()) {
            this.f38162d = 0;
            return 0;
        }
        int d2 = d();
        this.f38162d = d2;
        if (d2 != 0) {
            return d2;
        }
        throw d.d();
    }

    public int a(int i2) {
        if (i2 >= 0) {
            int i3 = i2 + this.f38163e + this.f38161c;
            int i4 = this.f38164f;
            if (i3 <= i4) {
                this.f38164f = i3;
                b();
                return i4;
            }
            throw d.a();
        }
        throw d.b();
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m146a() {
        return m157c();
    }

    /* renamed from: a  reason: collision with other method in class */
    public a m147a() {
        int d2 = d();
        int i2 = this.f38159a;
        int i3 = this.f38161c;
        if (d2 > i2 - i3 || d2 <= 0) {
            return a.a(m153a(d2));
        }
        a a2 = a.a(this.f143a, i3, d2);
        this.f38161c += d2;
        return a2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m148a() {
        int d2 = d();
        if (d2 > this.f38159a - this.f38161c || d2 <= 0) {
            return new String(m153a(d2), "UTF-8");
        }
        String str = new String(this.f143a, this.f38161c, d2, "UTF-8");
        this.f38161c += d2;
        return str;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m149a() {
        int m145a;
        do {
            m145a = m145a();
            if (m145a == 0) {
                return;
            }
        } while (m152a(m145a));
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m150a(int i2) {
        if (this.f38162d != i2) {
            throw d.e();
        }
    }

    public void a(e eVar) {
        int d2 = d();
        if (this.f38165g >= this.f38166h) {
            throw d.g();
        }
        int a2 = a(d2);
        this.f38165g++;
        eVar.a(this);
        m150a(0);
        this.f38165g--;
        b(a2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m151a() {
        return d() != 0;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m152a(int i2) {
        int a2 = f.a(i2);
        if (a2 == 0) {
            m154b();
            return true;
        } else if (a2 == 1) {
            m158d();
            return true;
        } else if (a2 == 2) {
            c(d());
            return true;
        } else if (a2 == 3) {
            m149a();
            m150a(f.a(f.b(i2), 4));
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
    public byte[] m153a(int i2) {
        if (i2 < 0) {
            throw d.b();
        }
        int i3 = this.f38163e;
        int i4 = this.f38161c;
        int i5 = i3 + i4 + i2;
        int i6 = this.f38164f;
        if (i5 > i6) {
            c((i6 - i3) - i4);
            throw d.a();
        }
        int i7 = this.f38159a;
        if (i2 <= i7 - i4) {
            byte[] bArr = new byte[i2];
            System.arraycopy(this.f143a, i4, bArr, 0, i2);
            this.f38161c += i2;
            return bArr;
        } else if (i2 >= 4096) {
            this.f38163e = i3 + i7;
            this.f38161c = 0;
            this.f38159a = 0;
            int i8 = i7 - i4;
            int i9 = i2 - i8;
            Vector vector = new Vector();
            while (i9 > 0) {
                int min = Math.min(i9, 4096);
                byte[] bArr2 = new byte[min];
                int i10 = 0;
                while (i10 < min) {
                    InputStream inputStream = this.f142a;
                    int read = inputStream == null ? -1 : inputStream.read(bArr2, i10, min - i10);
                    if (read == -1) {
                        throw d.a();
                    }
                    this.f38163e += read;
                    i10 += read;
                }
                i9 -= min;
                vector.addElement(bArr2);
            }
            byte[] bArr3 = new byte[i2];
            System.arraycopy(this.f143a, i4, bArr3, 0, i8);
            for (int i11 = 0; i11 < vector.size(); i11++) {
                byte[] bArr4 = (byte[]) vector.elementAt(i11);
                System.arraycopy(bArr4, 0, bArr3, i8, bArr4.length);
                i8 += bArr4.length;
            }
            return bArr3;
        } else {
            byte[] bArr5 = new byte[i2];
            int i12 = i7 - i4;
            System.arraycopy(this.f143a, i4, bArr5, 0, i12);
            this.f38161c = this.f38159a;
            while (true) {
                a(true);
                int i13 = i2 - i12;
                int i14 = this.f38159a;
                if (i13 <= i14) {
                    System.arraycopy(this.f143a, 0, bArr5, i12, i13);
                    this.f38161c = i13;
                    return bArr5;
                }
                System.arraycopy(this.f143a, 0, bArr5, i12, i14);
                int i15 = this.f38159a;
                i12 += i15;
                this.f38161c = i15;
            }
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public int m154b() {
        return d();
    }

    /* renamed from: b  reason: collision with other method in class */
    public long m155b() {
        return m157c();
    }

    public void b(int i2) {
        this.f38164f = i2;
        b();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m156b() {
        return this.f38161c == this.f38159a && !a(false);
    }

    public int c() {
        return d();
    }

    /* renamed from: c  reason: collision with other method in class */
    public long m157c() {
        long j = 0;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            byte a2 = a();
            j |= (a2 & ByteCompanionObject.MAX_VALUE) << i2;
            if ((a2 & ByteCompanionObject.MIN_VALUE) == 0) {
                return j;
            }
        }
        throw d.c();
    }

    public void c(int i2) {
        if (i2 < 0) {
            throw d.b();
        }
        int i3 = this.f38163e;
        int i4 = this.f38161c;
        int i5 = i3 + i4 + i2;
        int i6 = this.f38164f;
        if (i5 > i6) {
            c((i6 - i3) - i4);
            throw d.a();
        }
        int i7 = this.f38159a;
        if (i2 <= i7 - i4) {
            this.f38161c = i4 + i2;
            return;
        }
        int i8 = i7 - i4;
        this.f38163e = i3 + i7;
        this.f38161c = 0;
        this.f38159a = 0;
        while (i8 < i2) {
            InputStream inputStream = this.f142a;
            int skip = inputStream == null ? -1 : (int) inputStream.skip(i2 - i8);
            if (skip <= 0) {
                throw d.a();
            }
            i8 += skip;
            this.f38163e += skip;
        }
    }

    public int d() {
        int i2;
        byte a2 = a();
        if (a2 >= 0) {
            return a2;
        }
        int i3 = a2 & ByteCompanionObject.MAX_VALUE;
        byte a3 = a();
        if (a3 >= 0) {
            i2 = a3 << 7;
        } else {
            i3 |= (a3 & ByteCompanionObject.MAX_VALUE) << 7;
            byte a4 = a();
            if (a4 >= 0) {
                i2 = a4 << 14;
            } else {
                i3 |= (a4 & ByteCompanionObject.MAX_VALUE) << 14;
                byte a5 = a();
                if (a5 < 0) {
                    int i4 = i3 | ((a5 & ByteCompanionObject.MAX_VALUE) << 21);
                    byte a6 = a();
                    int i5 = i4 | (a6 << 28);
                    if (a6 < 0) {
                        for (int i6 = 0; i6 < 5; i6++) {
                            if (a() >= 0) {
                                return i5;
                            }
                        }
                        throw d.c();
                    }
                    return i5;
                }
                i2 = a5 << 21;
            }
        }
        return i3 | i2;
    }

    /* renamed from: d  reason: collision with other method in class */
    public long m158d() {
        byte a2 = a();
        byte a3 = a();
        return ((a3 & 255) << 8) | (a2 & 255) | ((a() & 255) << 16) | ((a() & 255) << 24) | ((a() & 255) << 32) | ((a() & 255) << 40) | ((a() & 255) << 48) | ((a() & 255) << 56);
    }

    public int e() {
        return (a() & 255) | ((a() & 255) << 8) | ((a() & 255) << 16) | ((a() & 255) << 24);
    }
}
