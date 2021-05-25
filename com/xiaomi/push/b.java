package com.xiaomi.push;

import com.google.protobuf.CodedInputStream;
import java.io.InputStream;
import java.util.Vector;
import kotlin.jvm.internal.ByteCompanionObject;
/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public int f37333a;

    /* renamed from: a  reason: collision with other field name */
    public final InputStream f142a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f143a;

    /* renamed from: b  reason: collision with root package name */
    public int f37334b;

    /* renamed from: c  reason: collision with root package name */
    public int f37335c;

    /* renamed from: d  reason: collision with root package name */
    public int f37336d;

    /* renamed from: e  reason: collision with root package name */
    public int f37337e;

    /* renamed from: f  reason: collision with root package name */
    public int f37338f;

    /* renamed from: g  reason: collision with root package name */
    public int f37339g;

    /* renamed from: h  reason: collision with root package name */
    public int f37340h;

    /* renamed from: i  reason: collision with root package name */
    public int f37341i;

    public b(InputStream inputStream) {
        this.f37338f = Integer.MAX_VALUE;
        this.f37340h = 64;
        this.f37341i = CodedInputStream.DEFAULT_SIZE_LIMIT;
        this.f143a = new byte[4096];
        this.f37333a = 0;
        this.f37335c = 0;
        this.f142a = inputStream;
    }

    public b(byte[] bArr, int i2, int i3) {
        this.f37338f = Integer.MAX_VALUE;
        this.f37340h = 64;
        this.f37341i = CodedInputStream.DEFAULT_SIZE_LIMIT;
        this.f143a = bArr;
        this.f37333a = i3 + i2;
        this.f37335c = i2;
        this.f142a = null;
    }

    public static b a(InputStream inputStream) {
        return new b(inputStream);
    }

    public static b a(byte[] bArr, int i2, int i3) {
        return new b(bArr, i2, i3);
    }

    private boolean a(boolean z) {
        int i2 = this.f37335c;
        int i3 = this.f37333a;
        if (i2 >= i3) {
            int i4 = this.f37337e;
            if (i4 + i3 == this.f37338f) {
                if (z) {
                    throw d.a();
                }
                return false;
            }
            this.f37337e = i4 + i3;
            this.f37335c = 0;
            InputStream inputStream = this.f142a;
            int read = inputStream == null ? -1 : inputStream.read(this.f143a);
            this.f37333a = read;
            if (read == 0 || read < -1) {
                throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + this.f37333a + "\nThe InputStream implementation is buggy.");
            } else if (read == -1) {
                this.f37333a = 0;
                if (z) {
                    throw d.a();
                }
                return false;
            } else {
                b();
                int i5 = this.f37337e + this.f37333a + this.f37334b;
                if (i5 > this.f37341i || i5 < 0) {
                    throw d.h();
                }
                return true;
            }
        }
        throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
    }

    private void b() {
        int i2 = this.f37333a + this.f37334b;
        this.f37333a = i2;
        int i3 = this.f37337e + i2;
        int i4 = this.f37338f;
        if (i3 <= i4) {
            this.f37334b = 0;
            return;
        }
        int i5 = i3 - i4;
        this.f37334b = i5;
        this.f37333a = i2 - i5;
    }

    public byte a() {
        if (this.f37335c == this.f37333a) {
            a(true);
        }
        byte[] bArr = this.f143a;
        int i2 = this.f37335c;
        this.f37335c = i2 + 1;
        return bArr[i2];
    }

    /* renamed from: a  reason: collision with other method in class */
    public int m144a() {
        if (m155b()) {
            this.f37336d = 0;
            return 0;
        }
        int d2 = d();
        this.f37336d = d2;
        if (d2 != 0) {
            return d2;
        }
        throw d.d();
    }

    public int a(int i2) {
        if (i2 >= 0) {
            int i3 = i2 + this.f37337e + this.f37335c;
            int i4 = this.f37338f;
            if (i3 <= i4) {
                this.f37338f = i3;
                b();
                return i4;
            }
            throw d.a();
        }
        throw d.b();
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m145a() {
        return m156c();
    }

    /* renamed from: a  reason: collision with other method in class */
    public a m146a() {
        int d2 = d();
        int i2 = this.f37333a;
        int i3 = this.f37335c;
        if (d2 > i2 - i3 || d2 <= 0) {
            return a.a(m152a(d2));
        }
        a a2 = a.a(this.f143a, i3, d2);
        this.f37335c += d2;
        return a2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m147a() {
        int d2 = d();
        if (d2 > this.f37333a - this.f37335c || d2 <= 0) {
            return new String(m152a(d2), "UTF-8");
        }
        String str = new String(this.f143a, this.f37335c, d2, "UTF-8");
        this.f37335c += d2;
        return str;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m148a() {
        int m144a;
        do {
            m144a = m144a();
            if (m144a == 0) {
                return;
            }
        } while (m151a(m144a));
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m149a(int i2) {
        if (this.f37336d != i2) {
            throw d.e();
        }
    }

    public void a(e eVar) {
        int d2 = d();
        if (this.f37339g >= this.f37340h) {
            throw d.g();
        }
        int a2 = a(d2);
        this.f37339g++;
        eVar.a(this);
        m149a(0);
        this.f37339g--;
        b(a2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m150a() {
        return d() != 0;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m151a(int i2) {
        int a2 = f.a(i2);
        if (a2 == 0) {
            m153b();
            return true;
        } else if (a2 == 1) {
            m157d();
            return true;
        } else if (a2 == 2) {
            c(d());
            return true;
        } else if (a2 == 3) {
            m148a();
            m149a(f.a(f.b(i2), 4));
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
    public byte[] m152a(int i2) {
        if (i2 < 0) {
            throw d.b();
        }
        int i3 = this.f37337e;
        int i4 = this.f37335c;
        int i5 = i3 + i4 + i2;
        int i6 = this.f37338f;
        if (i5 > i6) {
            c((i6 - i3) - i4);
            throw d.a();
        }
        int i7 = this.f37333a;
        if (i2 <= i7 - i4) {
            byte[] bArr = new byte[i2];
            System.arraycopy(this.f143a, i4, bArr, 0, i2);
            this.f37335c += i2;
            return bArr;
        } else if (i2 >= 4096) {
            this.f37337e = i3 + i7;
            this.f37335c = 0;
            this.f37333a = 0;
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
                    this.f37337e += read;
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
            this.f37335c = this.f37333a;
            while (true) {
                a(true);
                int i13 = i2 - i12;
                int i14 = this.f37333a;
                if (i13 <= i14) {
                    System.arraycopy(this.f143a, 0, bArr5, i12, i13);
                    this.f37335c = i13;
                    return bArr5;
                }
                System.arraycopy(this.f143a, 0, bArr5, i12, i14);
                int i15 = this.f37333a;
                i12 += i15;
                this.f37335c = i15;
            }
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public int m153b() {
        return d();
    }

    /* renamed from: b  reason: collision with other method in class */
    public long m154b() {
        return m156c();
    }

    public void b(int i2) {
        this.f37338f = i2;
        b();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m155b() {
        return this.f37335c == this.f37333a && !a(false);
    }

    public int c() {
        return d();
    }

    /* renamed from: c  reason: collision with other method in class */
    public long m156c() {
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
        int i3 = this.f37337e;
        int i4 = this.f37335c;
        int i5 = i3 + i4 + i2;
        int i6 = this.f37338f;
        if (i5 > i6) {
            c((i6 - i3) - i4);
            throw d.a();
        }
        int i7 = this.f37333a;
        if (i2 <= i7 - i4) {
            this.f37335c = i4 + i2;
            return;
        }
        int i8 = i7 - i4;
        this.f37337e = i3 + i7;
        this.f37335c = 0;
        this.f37333a = 0;
        while (i8 < i2) {
            InputStream inputStream = this.f142a;
            int skip = inputStream == null ? -1 : (int) inputStream.skip(i2 - i8);
            if (skip <= 0) {
                throw d.a();
            }
            i8 += skip;
            this.f37337e += skip;
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
    public long m157d() {
        byte a2 = a();
        byte a3 = a();
        return ((a3 & 255) << 8) | (a2 & 255) | ((a() & 255) << 16) | ((a() & 255) << 24) | ((a() & 255) << 32) | ((a() & 255) << 40) | ((a() & 255) << 48) | ((a() & 255) << 56);
    }

    public int e() {
        return (a() & 255) | ((a() & 255) << 8) | ((a() & 255) << 16) | ((a() & 255) << 24);
    }
}
