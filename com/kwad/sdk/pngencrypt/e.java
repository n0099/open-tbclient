package com.kwad.sdk.pngencrypt;
/* loaded from: classes6.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public final k f34269a;

    /* renamed from: b  reason: collision with root package name */
    public int f34270b;

    /* renamed from: c  reason: collision with root package name */
    public int f34271c;

    /* renamed from: d  reason: collision with root package name */
    public int f34272d;

    /* renamed from: e  reason: collision with root package name */
    public int f34273e;

    /* renamed from: f  reason: collision with root package name */
    public int f34274f;

    /* renamed from: g  reason: collision with root package name */
    public int f34275g;
    public int j;
    public int k;
    public boolean o;

    /* renamed from: i  reason: collision with root package name */
    public int f34277i = 0;
    public int l = -1;
    public int m = -1;
    public int n = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f34276h = 0;

    public e(k kVar) {
        this.o = false;
        this.f34269a = kVar;
        this.o = false;
        a(1);
        c(0);
    }

    public static byte[] b(int i2) {
        switch (i2) {
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
                throw new PngjException("bad interlace pass" + i2);
        }
    }

    private void c(int i2) {
        this.l = i2;
        int i3 = (i2 * this.f34270b) + this.f34272d;
        this.m = i3;
        if (i3 < 0 || i3 >= this.f34269a.f34283b) {
            throw new PngjException("bad row - this should not happen");
        }
    }

    public void a(int i2) {
        int i3;
        if (this.f34277i == i2) {
            return;
        }
        this.f34277i = i2;
        byte[] b2 = b(i2);
        this.f34271c = b2[0];
        byte b3 = b2[1];
        this.f34270b = b3;
        this.f34273e = b2[2];
        byte b4 = b2[3];
        this.f34272d = b4;
        int i4 = this.f34269a.f34283b;
        this.j = i4 > b4 ? (((i4 + b3) - 1) - b4) / b3 : 0;
        int i5 = this.f34269a.f34282a;
        int i6 = this.f34273e;
        if (i5 > i6) {
            int i7 = this.f34271c;
            i3 = (((i5 + i7) - 1) - i6) / i7;
        } else {
            i3 = 0;
        }
        this.k = i3;
        if (i3 == 0) {
            this.j = 0;
        }
        int i8 = this.f34271c;
        int i9 = this.f34269a.f34285d;
        this.f34275g = i8 * i9;
        this.f34274f = this.f34273e * i9;
    }

    public boolean a() {
        int i2;
        this.n++;
        int i3 = this.j;
        if (i3 == 0 || (i2 = this.l) >= i3 - 1) {
            int i4 = this.f34277i;
            if (i4 == 7) {
                this.o = true;
                return false;
            }
            a(i4 + 1);
            if (this.j == 0) {
                this.n--;
                return a();
            }
            c(0);
        } else {
            c(i2 + 1);
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
        return this.f34277i;
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
        return ((this.f34269a.f34290i * g()) + 7) / 8;
    }
}
