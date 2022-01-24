package com.kwad.sdk.pngencrypt;
/* loaded from: classes3.dex */
public class e {
    public final k a;

    /* renamed from: b  reason: collision with root package name */
    public int f57163b;

    /* renamed from: c  reason: collision with root package name */
    public int f57164c;

    /* renamed from: d  reason: collision with root package name */
    public int f57165d;

    /* renamed from: e  reason: collision with root package name */
    public int f57166e;

    /* renamed from: f  reason: collision with root package name */
    public int f57167f;

    /* renamed from: g  reason: collision with root package name */
    public int f57168g;

    /* renamed from: j  reason: collision with root package name */
    public int f57171j;
    public int k;
    public boolean o;

    /* renamed from: i  reason: collision with root package name */
    public int f57170i = 0;
    public int l = -1;
    public int m = -1;
    public int n = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f57169h = 0;

    public e(k kVar) {
        this.o = false;
        this.a = kVar;
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
        int i3 = (i2 * this.f57163b) + this.f57165d;
        this.m = i3;
        if (i3 < 0 || i3 >= this.a.f57176b) {
            throw new PngjException("bad row - this should not happen");
        }
    }

    public void a(int i2) {
        int i3;
        if (this.f57170i == i2) {
            return;
        }
        this.f57170i = i2;
        byte[] b2 = b(i2);
        this.f57164c = b2[0];
        byte b3 = b2[1];
        this.f57163b = b3;
        this.f57166e = b2[2];
        byte b4 = b2[3];
        this.f57165d = b4;
        int i4 = this.a.f57176b;
        this.f57171j = i4 > b4 ? (((i4 + b3) - 1) - b4) / b3 : 0;
        int i5 = this.a.a;
        int i6 = this.f57166e;
        if (i5 > i6) {
            int i7 = this.f57164c;
            i3 = (((i5 + i7) - 1) - i6) / i7;
        } else {
            i3 = 0;
        }
        this.k = i3;
        if (i3 == 0) {
            this.f57171j = 0;
        }
        int i8 = this.f57164c;
        int i9 = this.a.f57178d;
        this.f57168g = i8 * i9;
        this.f57167f = this.f57166e * i9;
    }

    public boolean a() {
        int i2;
        this.n++;
        int i3 = this.f57171j;
        if (i3 == 0 || (i2 = this.l) >= i3 - 1) {
            int i4 = this.f57170i;
            if (i4 == 7) {
                this.o = true;
                return false;
            }
            a(i4 + 1);
            if (this.f57171j == 0) {
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
        return this.f57170i;
    }

    public int e() {
        return this.f57171j;
    }

    public int f() {
        return this.k;
    }

    public int g() {
        return f();
    }

    public int h() {
        return ((this.a.f57183i * g()) + 7) / 8;
    }
}
