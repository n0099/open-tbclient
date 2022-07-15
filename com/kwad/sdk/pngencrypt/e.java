package com.kwad.sdk.pngencrypt;
/* loaded from: classes5.dex */
public final class e {
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
        b(1);
        a(0);
    }

    private void a(int i) {
        this.l = i;
        int i2 = (i * this.b) + this.d;
        this.m = i2;
        if (i2 < 0 || i2 >= this.a.b) {
            throw new PngjException("bad row - this should not happen");
        }
    }

    private void b(int i) {
        int i2;
        if (this.i == i) {
            return;
        }
        this.i = i;
        byte[] c = c(i);
        this.c = c[0];
        byte b = c[1];
        this.b = b;
        this.e = c[2];
        byte b2 = c[3];
        this.d = b2;
        int i3 = this.a.b;
        this.j = i3 > b2 ? (((i3 + b) - 1) - b2) / b : 0;
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

    public static byte[] c(int i) {
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

    private int h() {
        return f();
    }

    public final boolean a() {
        int i;
        while (true) {
            this.n++;
            int i2 = this.j;
            if (i2 != 0 && (i = this.l) < i2 - 1) {
                a(i + 1);
                break;
            }
            int i3 = this.i;
            if (i3 != 7) {
                b(i3 + 1);
                if (this.j != 0) {
                    a(0);
                    break;
                }
                this.n--;
            } else {
                this.o = true;
                return false;
            }
        }
        return true;
    }

    public final int b() {
        return this.l;
    }

    public final int c() {
        return this.m;
    }

    public final int d() {
        return this.i;
    }

    public final int e() {
        return this.j;
    }

    public final int f() {
        return this.k;
    }

    public final int g() {
        return ((this.a.i * h()) + 7) / 8;
    }
}
