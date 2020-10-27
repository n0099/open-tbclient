package com.xiaomi.push;

import android.support.v7.widget.ActivityChooserView;
import java.io.InputStream;
import java.util.Vector;
/* loaded from: classes12.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private int f4804a;

    /* renamed from: a  reason: collision with other field name */
    private final InputStream f116a;

    /* renamed from: a  reason: collision with other field name */
    private final byte[] f117a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;

    private b(InputStream inputStream) {
        this.f = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.h = 64;
        this.i = 67108864;
        this.f117a = new byte[4096];
        this.f4804a = 0;
        this.c = 0;
        this.f116a = inputStream;
    }

    private b(byte[] bArr, int i, int i2) {
        this.f = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.h = 64;
        this.i = 67108864;
        this.f117a = bArr;
        this.f4804a = i + i2;
        this.c = i;
        this.f116a = null;
    }

    public static b a(InputStream inputStream) {
        return new b(inputStream);
    }

    public static b a(byte[] bArr, int i, int i2) {
        return new b(bArr, i, i2);
    }

    private boolean a(boolean z) {
        if (this.c < this.f4804a) {
            throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
        }
        if (this.e + this.f4804a == this.f) {
            if (z) {
                throw d.a();
            }
            return false;
        }
        this.e += this.f4804a;
        this.c = 0;
        this.f4804a = this.f116a == null ? -1 : this.f116a.read(this.f117a);
        if (this.f4804a == 0 || this.f4804a < -1) {
            throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + this.f4804a + "\nThe InputStream implementation is buggy.");
        }
        if (this.f4804a == -1) {
            this.f4804a = 0;
            if (z) {
                throw d.a();
            }
            return false;
        }
        b();
        int i = this.e + this.f4804a + this.b;
        if (i > this.i || i < 0) {
            throw d.h();
        }
        return true;
    }

    private void b() {
        this.f4804a += this.b;
        int i = this.e + this.f4804a;
        if (i <= this.f) {
            this.b = 0;
            return;
        }
        this.b = i - this.f;
        this.f4804a -= this.b;
    }

    public byte a() {
        if (this.c == this.f4804a) {
            a(true);
        }
        byte[] bArr = this.f117a;
        int i = this.c;
        this.c = i + 1;
        return bArr[i];
    }

    /* renamed from: a  reason: collision with other method in class */
    public int m144a() {
        if (m155b()) {
            this.d = 0;
            return 0;
        }
        this.d = d();
        if (this.d == 0) {
            throw d.d();
        }
        return this.d;
    }

    public int a(int i) {
        if (i < 0) {
            throw d.b();
        }
        int i2 = this.e + this.c + i;
        int i3 = this.f;
        if (i2 > i3) {
            throw d.a();
        }
        this.f = i2;
        b();
        return i3;
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m145a() {
        return m156c();
    }

    /* renamed from: a  reason: collision with other method in class */
    public a m146a() {
        int d = d();
        if (d > this.f4804a - this.c || d <= 0) {
            return a.a(m152a(d));
        }
        a a2 = a.a(this.f117a, this.c, d);
        this.c = d + this.c;
        return a2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m147a() {
        int d = d();
        if (d > this.f4804a - this.c || d <= 0) {
            return new String(m152a(d), "UTF-8");
        }
        String str = new String(this.f117a, this.c, d, "UTF-8");
        this.c = d + this.c;
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
    public void m149a(int i) {
        if (this.d != i) {
            throw d.e();
        }
    }

    public void a(e eVar) {
        int d = d();
        if (this.g >= this.h) {
            throw d.g();
        }
        int a2 = a(d);
        this.g++;
        eVar.a(this);
        m149a(0);
        this.g--;
        b(a2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m150a() {
        return d() != 0;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m151a(int i) {
        switch (f.a(i)) {
            case 0:
                m153b();
                return true;
            case 1:
                m157d();
                return true;
            case 2:
                c(d());
                return true;
            case 3:
                m148a();
                m149a(f.a(f.b(i), 4));
                return true;
            case 4:
                return false;
            case 5:
                e();
                return true;
            default:
                throw d.f();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m152a(int i) {
        if (i < 0) {
            throw d.b();
        }
        if (this.e + this.c + i > this.f) {
            c((this.f - this.e) - this.c);
            throw d.a();
        } else if (i <= this.f4804a - this.c) {
            byte[] bArr = new byte[i];
            System.arraycopy(this.f117a, this.c, bArr, 0, i);
            this.c += i;
            return bArr;
        } else if (i < 4096) {
            byte[] bArr2 = new byte[i];
            int i2 = this.f4804a - this.c;
            System.arraycopy(this.f117a, this.c, bArr2, 0, i2);
            this.c = this.f4804a;
            a(true);
            while (i - i2 > this.f4804a) {
                System.arraycopy(this.f117a, 0, bArr2, i2, this.f4804a);
                i2 += this.f4804a;
                this.c = this.f4804a;
                a(true);
            }
            System.arraycopy(this.f117a, 0, bArr2, i2, i - i2);
            this.c = i - i2;
            return bArr2;
        } else {
            int i3 = this.c;
            int i4 = this.f4804a;
            this.e += this.f4804a;
            this.c = 0;
            this.f4804a = 0;
            Vector vector = new Vector();
            int i5 = i - (i4 - i3);
            while (i5 > 0) {
                byte[] bArr3 = new byte[Math.min(i5, 4096)];
                int i6 = 0;
                while (i6 < bArr3.length) {
                    int read = this.f116a == null ? -1 : this.f116a.read(bArr3, i6, bArr3.length - i6);
                    if (read == -1) {
                        throw d.a();
                    }
                    this.e += read;
                    i6 += read;
                }
                vector.addElement(bArr3);
                i5 -= bArr3.length;
            }
            byte[] bArr4 = new byte[i];
            int i7 = i4 - i3;
            System.arraycopy(this.f117a, i3, bArr4, 0, i7);
            int i8 = i7;
            for (int i9 = 0; i9 < vector.size(); i9++) {
                byte[] bArr5 = (byte[]) vector.elementAt(i9);
                System.arraycopy(bArr5, 0, bArr4, i8, bArr5.length);
                i8 += bArr5.length;
            }
            return bArr4;
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

    public void b(int i) {
        this.f = i;
        b();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m155b() {
        return this.c == this.f4804a && !a(false);
    }

    public int c() {
        return d();
    }

    /* renamed from: c  reason: collision with other method in class */
    public long m156c() {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte a2 = a();
            j |= (a2 & Byte.MAX_VALUE) << i;
            if ((a2 & 128) == 0) {
                return j;
            }
        }
        throw d.c();
    }

    public void c(int i) {
        if (i < 0) {
            throw d.b();
        }
        if (this.e + this.c + i > this.f) {
            c((this.f - this.e) - this.c);
            throw d.a();
        } else if (i <= this.f4804a - this.c) {
            this.c += i;
        } else {
            int i2 = this.f4804a - this.c;
            this.e += this.f4804a;
            this.c = 0;
            this.f4804a = 0;
            int i3 = i2;
            while (i3 < i) {
                int skip = this.f116a == null ? -1 : (int) this.f116a.skip(i - i3);
                if (skip <= 0) {
                    throw d.a();
                }
                i3 += skip;
                this.e = skip + this.e;
            }
        }
    }

    public int d() {
        byte a2 = a();
        if (a2 >= 0) {
            return a2;
        }
        int i = a2 & Byte.MAX_VALUE;
        byte a3 = a();
        if (a3 >= 0) {
            return i | (a3 << 7);
        }
        int i2 = i | ((a3 & Byte.MAX_VALUE) << 7);
        byte a4 = a();
        if (a4 >= 0) {
            return i2 | (a4 << 14);
        }
        int i3 = i2 | ((a4 & Byte.MAX_VALUE) << 14);
        byte a5 = a();
        if (a5 >= 0) {
            return i3 | (a5 << 21);
        }
        int i4 = i3 | ((a5 & Byte.MAX_VALUE) << 21);
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
