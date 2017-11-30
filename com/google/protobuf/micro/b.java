package com.google.protobuf.micro;

import java.io.InputStream;
import java.util.Vector;
/* loaded from: classes2.dex */
public final class b {
    private final byte[] a;
    private int b;
    private int c;
    private int d;
    private final InputStream e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;

    private b(InputStream inputStream) {
        this.h = Integer.MAX_VALUE;
        this.j = 64;
        this.k = 67108864;
        this.a = new byte[4096];
        this.b = 0;
        this.d = 0;
        this.e = inputStream;
    }

    private b(byte[] bArr, int i, int i2) {
        this.h = Integer.MAX_VALUE;
        this.j = 64;
        this.k = 67108864;
        this.a = bArr;
        this.b = i + i2;
        this.d = i;
        this.e = null;
    }

    private boolean a(boolean z) {
        if (this.d < this.b) {
            throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
        }
        if (this.g + this.b == this.h) {
            if (z) {
                throw d.a();
            }
            return false;
        }
        this.g += this.b;
        this.d = 0;
        this.b = this.e == null ? -1 : this.e.read(this.a);
        if (this.b == 0 || this.b < -1) {
            throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + this.b + "\nThe InputStream implementation is buggy.");
        }
        if (this.b == -1) {
            this.b = 0;
            if (z) {
                throw d.a();
            }
            return false;
        }
        p();
        int i = this.g + this.b + this.c;
        if (i > this.k || i < 0) {
            throw d.h();
        }
        return true;
    }

    public static b j(InputStream inputStream) {
        return new b(inputStream);
    }

    public static b m(byte[] bArr, int i, int i2) {
        return new b(bArr, i, i2);
    }

    private void p() {
        this.b += this.c;
        int i = this.g + this.b;
        if (i <= this.h) {
            this.c = 0;
            return;
        }
        this.c = i - this.h;
        this.b -= this.c;
    }

    public int a() {
        if (n()) {
            this.f = 0;
            return 0;
        }
        this.f = j();
        if (this.f == 0) {
            throw d.d();
        }
        return this.f;
    }

    public void a(int i) {
        if (this.f != i) {
            throw d.e();
        }
    }

    public void a(e eVar) {
        int j = j();
        if (this.i >= this.j) {
            throw d.g();
        }
        int c = c(j);
        this.i++;
        eVar.a(this);
        a(0);
        this.i--;
        d(c);
    }

    public void b() {
        int a;
        do {
            a = a();
            if (a == 0) {
                return;
            }
        } while (b(a));
    }

    public boolean b(int i) {
        switch (f.a(i)) {
            case 0:
                e();
                return true;
            case 1:
                m();
                return true;
            case 2:
                f(j());
                return true;
            case 3:
                b();
                a(f.a(f.b(i), 4));
                return true;
            case 4:
                return false;
            case 5:
                l();
                return true;
            default:
                throw d.f();
        }
    }

    public a bMa() {
        int j = j();
        if (j > this.b - this.d || j <= 0) {
            return a.J(wU(j));
        }
        a l = a.l(this.a, this.d, j);
        this.d = j + this.d;
        return l;
    }

    public byte bMb() {
        if (this.d == this.b) {
            a(true);
        }
        byte[] bArr = this.a;
        int i = this.d;
        this.d = i + 1;
        return bArr[i];
    }

    public int c(int i) {
        if (i < 0) {
            throw d.b();
        }
        int i2 = this.g + this.d + i;
        int i3 = this.h;
        if (i2 > i3) {
            throw d.a();
        }
        this.h = i2;
        p();
        return i3;
    }

    public long c() {
        return k();
    }

    public long d() {
        return k();
    }

    public void d(int i) {
        this.h = i;
        p();
    }

    public int e() {
        return j();
    }

    public void f(int i) {
        if (i < 0) {
            throw d.b();
        }
        if (this.g + this.d + i > this.h) {
            f((this.h - this.g) - this.d);
            throw d.a();
        } else if (i <= this.b - this.d) {
            this.d += i;
        } else {
            int i2 = this.b - this.d;
            this.g += this.b;
            this.d = 0;
            this.b = 0;
            int i3 = i2;
            while (i3 < i) {
                int skip = this.e == null ? -1 : (int) this.e.skip(i - i3);
                if (skip <= 0) {
                    throw d.a();
                }
                i3 += skip;
                this.g = skip + this.g;
            }
        }
    }

    public boolean f() {
        return j() != 0;
    }

    public String g() {
        int j = j();
        if (j > this.b - this.d || j <= 0) {
            return new String(wU(j), "UTF-8");
        }
        String str = new String(this.a, this.d, j, "UTF-8");
        this.d = j + this.d;
        return str;
    }

    public int i() {
        return j();
    }

    public int j() {
        byte bMb = bMb();
        if (bMb >= 0) {
            return bMb;
        }
        int i = bMb & Byte.MAX_VALUE;
        byte bMb2 = bMb();
        if (bMb2 >= 0) {
            return i | (bMb2 << 7);
        }
        int i2 = i | ((bMb2 & Byte.MAX_VALUE) << 7);
        byte bMb3 = bMb();
        if (bMb3 >= 0) {
            return i2 | (bMb3 << 14);
        }
        int i3 = i2 | ((bMb3 & Byte.MAX_VALUE) << 14);
        byte bMb4 = bMb();
        if (bMb4 >= 0) {
            return i3 | (bMb4 << 21);
        }
        int i4 = i3 | ((bMb4 & Byte.MAX_VALUE) << 21);
        byte bMb5 = bMb();
        int i5 = i4 | (bMb5 << 28);
        if (bMb5 < 0) {
            for (int i6 = 0; i6 < 5; i6++) {
                if (bMb() >= 0) {
                    return i5;
                }
            }
            throw d.c();
        }
        return i5;
    }

    public long k() {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte bMb = bMb();
            j |= (bMb & Byte.MAX_VALUE) << i;
            if ((bMb & 128) == 0) {
                return j;
            }
        }
        throw d.c();
    }

    public int l() {
        return (bMb() & 255) | ((bMb() & 255) << 8) | ((bMb() & 255) << 16) | ((bMb() & 255) << 24);
    }

    public long m() {
        byte bMb = bMb();
        byte bMb2 = bMb();
        return ((bMb2 & 255) << 8) | (bMb & 255) | ((bMb() & 255) << 16) | ((bMb() & 255) << 24) | ((bMb() & 255) << 32) | ((bMb() & 255) << 40) | ((bMb() & 255) << 48) | ((bMb() & 255) << 56);
    }

    public boolean n() {
        return this.d == this.b && !a(false);
    }

    public byte[] wU(int i) {
        if (i < 0) {
            throw d.b();
        }
        if (this.g + this.d + i > this.h) {
            f((this.h - this.g) - this.d);
            throw d.a();
        } else if (i <= this.b - this.d) {
            byte[] bArr = new byte[i];
            System.arraycopy(this.a, this.d, bArr, 0, i);
            this.d += i;
            return bArr;
        } else if (i < 4096) {
            byte[] bArr2 = new byte[i];
            int i2 = this.b - this.d;
            System.arraycopy(this.a, this.d, bArr2, 0, i2);
            this.d = this.b;
            a(true);
            while (i - i2 > this.b) {
                System.arraycopy(this.a, 0, bArr2, i2, this.b);
                i2 += this.b;
                this.d = this.b;
                a(true);
            }
            System.arraycopy(this.a, 0, bArr2, i2, i - i2);
            this.d = i - i2;
            return bArr2;
        } else {
            int i3 = this.d;
            int i4 = this.b;
            this.g += this.b;
            this.d = 0;
            this.b = 0;
            Vector vector = new Vector();
            int i5 = i - (i4 - i3);
            while (i5 > 0) {
                byte[] bArr3 = new byte[Math.min(i5, 4096)];
                int i6 = 0;
                while (i6 < bArr3.length) {
                    int read = this.e == null ? -1 : this.e.read(bArr3, i6, bArr3.length - i6);
                    if (read == -1) {
                        throw d.a();
                    }
                    this.g += read;
                    i6 += read;
                }
                vector.addElement(bArr3);
                i5 -= bArr3.length;
            }
            byte[] bArr4 = new byte[i];
            int i7 = i4 - i3;
            System.arraycopy(this.a, i3, bArr4, 0, i7);
            int i8 = i7;
            for (int i9 = 0; i9 < vector.size(); i9++) {
                byte[] bArr5 = (byte[]) vector.elementAt(i9);
                System.arraycopy(bArr5, 0, bArr4, i8, bArr5.length);
                i8 += bArr5.length;
            }
            return bArr4;
        }
    }
}
