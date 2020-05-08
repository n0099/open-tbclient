package com.xiaomi.push;

import android.support.v7.widget.ActivityChooserView;
import java.io.InputStream;
import java.util.Vector;
/* loaded from: classes8.dex */
public final class b {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private final InputStream f117a;

    /* renamed from: a  reason: collision with other field name */
    private final byte[] f118a;
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
        this.f118a = new byte[4096];
        this.a = 0;
        this.c = 0;
        this.f117a = inputStream;
    }

    private b(byte[] bArr, int i, int i2) {
        this.f = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.h = 64;
        this.i = 67108864;
        this.f118a = bArr;
        this.a = i + i2;
        this.c = i;
        this.f117a = null;
    }

    public static b a(InputStream inputStream) {
        return new b(inputStream);
    }

    public static b a(byte[] bArr, int i, int i2) {
        return new b(bArr, i, i2);
    }

    private boolean a(boolean z) {
        if (this.c < this.a) {
            throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
        }
        if (this.e + this.a == this.f) {
            if (z) {
                throw d.a();
            }
            return false;
        }
        this.e += this.a;
        this.c = 0;
        this.a = this.f117a == null ? -1 : this.f117a.read(this.f118a);
        if (this.a == 0 || this.a < -1) {
            throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + this.a + "\nThe InputStream implementation is buggy.");
        }
        if (this.a == -1) {
            this.a = 0;
            if (z) {
                throw d.a();
            }
            return false;
        }
        b();
        int i = this.e + this.a + this.b;
        if (i > this.i || i < 0) {
            throw d.h();
        }
        return true;
    }

    private void b() {
        this.a += this.b;
        int i = this.e + this.a;
        if (i <= this.f) {
            this.b = 0;
            return;
        }
        this.b = i - this.f;
        this.a -= this.b;
    }

    public byte a() {
        if (this.c == this.a) {
            a(true);
        }
        byte[] bArr = this.f118a;
        int i = this.c;
        this.c = i + 1;
        return bArr[i];
    }

    /* renamed from: a  reason: collision with other method in class */
    public int m140a() {
        if (m151b()) {
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
    public long m141a() {
        return m152c();
    }

    /* renamed from: a  reason: collision with other method in class */
    public a m142a() {
        int d = d();
        if (d > this.a - this.c || d <= 0) {
            return a.a(m148a(d));
        }
        a a = a.a(this.f118a, this.c, d);
        this.c = d + this.c;
        return a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m143a() {
        int d = d();
        if (d > this.a - this.c || d <= 0) {
            return new String(m148a(d), "UTF-8");
        }
        String str = new String(this.f118a, this.c, d, "UTF-8");
        this.c = d + this.c;
        return str;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m144a() {
        int m140a;
        do {
            m140a = m140a();
            if (m140a == 0) {
                return;
            }
        } while (m147a(m140a));
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m145a(int i) {
        if (this.d != i) {
            throw d.e();
        }
    }

    public void a(e eVar) {
        int d = d();
        if (this.g >= this.h) {
            throw d.g();
        }
        int a = a(d);
        this.g++;
        eVar.a(this);
        m145a(0);
        this.g--;
        b(a);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m146a() {
        return d() != 0;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m147a(int i) {
        switch (f.a(i)) {
            case 0:
                m149b();
                return true;
            case 1:
                m153d();
                return true;
            case 2:
                c(d());
                return true;
            case 3:
                m144a();
                m145a(f.a(f.b(i), 4));
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
    public byte[] m148a(int i) {
        if (i < 0) {
            throw d.b();
        }
        if (this.e + this.c + i > this.f) {
            c((this.f - this.e) - this.c);
            throw d.a();
        } else if (i <= this.a - this.c) {
            byte[] bArr = new byte[i];
            System.arraycopy(this.f118a, this.c, bArr, 0, i);
            this.c += i;
            return bArr;
        } else if (i < 4096) {
            byte[] bArr2 = new byte[i];
            int i2 = this.a - this.c;
            System.arraycopy(this.f118a, this.c, bArr2, 0, i2);
            this.c = this.a;
            a(true);
            while (i - i2 > this.a) {
                System.arraycopy(this.f118a, 0, bArr2, i2, this.a);
                i2 += this.a;
                this.c = this.a;
                a(true);
            }
            System.arraycopy(this.f118a, 0, bArr2, i2, i - i2);
            this.c = i - i2;
            return bArr2;
        } else {
            int i3 = this.c;
            int i4 = this.a;
            this.e += this.a;
            this.c = 0;
            this.a = 0;
            Vector vector = new Vector();
            int i5 = i - (i4 - i3);
            while (i5 > 0) {
                byte[] bArr3 = new byte[Math.min(i5, 4096)];
                int i6 = 0;
                while (i6 < bArr3.length) {
                    int read = this.f117a == null ? -1 : this.f117a.read(bArr3, i6, bArr3.length - i6);
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
            System.arraycopy(this.f118a, i3, bArr4, 0, i7);
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
    public int m149b() {
        return d();
    }

    /* renamed from: b  reason: collision with other method in class */
    public long m150b() {
        return m152c();
    }

    public void b(int i) {
        this.f = i;
        b();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m151b() {
        return this.c == this.a && !a(false);
    }

    public int c() {
        return d();
    }

    /* renamed from: c  reason: collision with other method in class */
    public long m152c() {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte a = a();
            j |= (a & Byte.MAX_VALUE) << i;
            if ((a & 128) == 0) {
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
        } else if (i <= this.a - this.c) {
            this.c += i;
        } else {
            int i2 = this.a - this.c;
            this.e += this.a;
            this.c = 0;
            this.a = 0;
            int i3 = i2;
            while (i3 < i) {
                int skip = this.f117a == null ? -1 : (int) this.f117a.skip(i - i3);
                if (skip <= 0) {
                    throw d.a();
                }
                i3 += skip;
                this.e = skip + this.e;
            }
        }
    }

    public int d() {
        byte a = a();
        if (a >= 0) {
            return a;
        }
        int i = a & Byte.MAX_VALUE;
        byte a2 = a();
        if (a2 >= 0) {
            return i | (a2 << 7);
        }
        int i2 = i | ((a2 & Byte.MAX_VALUE) << 7);
        byte a3 = a();
        if (a3 >= 0) {
            return i2 | (a3 << 14);
        }
        int i3 = i2 | ((a3 & Byte.MAX_VALUE) << 14);
        byte a4 = a();
        if (a4 >= 0) {
            return i3 | (a4 << 21);
        }
        int i4 = i3 | ((a4 & Byte.MAX_VALUE) << 21);
        byte a5 = a();
        int i5 = i4 | (a5 << 28);
        if (a5 < 0) {
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
    public long m153d() {
        byte a = a();
        byte a2 = a();
        return ((a2 & 255) << 8) | (a & 255) | ((a() & 255) << 16) | ((a() & 255) << 24) | ((a() & 255) << 32) | ((a() & 255) << 40) | ((a() & 255) << 48) | ((a() & 255) << 56);
    }

    public int e() {
        return (a() & 255) | ((a() & 255) << 8) | ((a() & 255) << 16) | ((a() & 255) << 24);
    }
}
