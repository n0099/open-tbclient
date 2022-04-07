package com.kwad.sdk.pngencrypt;
/* loaded from: classes5.dex */
public class e {
    public final k a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int j;
    public int k;
    public boolean o;
    public int i = 0;
    public int l = -1;
    public int m = -1;
    public int n = 0;
    public int h = 0;

    public e(k kVar) {
        this.o = false;
        this.a = kVar;
        this.o = false;
        a(1);
        c(0);
    }

    public static byte[] b(int i) {
        switch (i) {
            case 1:
                return new byte[]{8, 8, 0, 0};
            case 2:
                return new byte[]{8, 8, 4, 0};
            case 3:
                return new byte[]{4, 8, 0, 4};
            case 4:
                return new byte[]{4, 4, 2, 0};
            case 5:
                return new byte[]{2, 4, 0, 2};
            case 6:
                return new byte[]{2, 2, 1, 0};
            case 7:
                return new byte[]{1, 2, 0, 1};
            default:
                throw new PngjException("bad interlace pass" + i);
        }
    }

    private void c(int i) {
        this.l = i;
        int i2 = (i * this.b) + this.d;
        this.m = i2;
        if (i2 < 0 || i2 >= this.a.b) {
            throw new PngjException("bad row - this should not happen");
        }
    }

    public void a(int i) {
        int i2;
        if (this.i == i) {
            return;
        }
        this.i = i;
        byte[] b = b(i);
        this.c = b[0];
        byte b2 = b[1];
        this.b = b2;
        this.e = b[2];
        byte b3 = b[3];
        this.d = b3;
        int i3 = this.a.b;
        this.j = i3 > b3 ? (((i3 + b2) - 1) - b3) / b2 : 0;
        int i4 = this.a.a;
        int i5 = this.e;
        if (i4 > i5) {
            int i6 = this.c;
            i2 = (((i4 + i6) - 1) - i5) / i6;
        } else {
            i2 = 0;
        }
        this.k = i2;
        if (i2 == 0) {
            this.j = 0;
        }
        int i7 = this.c;
        int i8 = this.a.d;
        this.g = i7 * i8;
        this.f = this.e * i8;
    }

    public boolean a() {
        int i;
        this.n++;
        int i2 = this.j;
        if (i2 == 0 || (i = this.l) >= i2 - 1) {
            int i3 = this.i;
            if (i3 == 7) {
                this.o = true;
                return false;
            }
            a(i3 + 1);
            if (this.j == 0) {
                this.n--;
                return a();
            }
            c(0);
        } else {
            c(i + 1);
        }
        return true;
    }

    public int b() {
        return this.l;
    }

    public int c() {
        return this.m;
    }

    public int d() {
        return this.i;
    }

    public int e() {
        return this.j;
    }

    public int f() {
        return this.k;
    }

    public int g() {
        return f();
    }

    public int h() {
        return ((this.a.i * g()) + 7) / 8;
    }
}
