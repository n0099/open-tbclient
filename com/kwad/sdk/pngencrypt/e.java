package com.kwad.sdk.pngencrypt;
/* loaded from: classes6.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public final k f36174a;

    /* renamed from: b  reason: collision with root package name */
    public int f36175b;

    /* renamed from: c  reason: collision with root package name */
    public int f36176c;

    /* renamed from: d  reason: collision with root package name */
    public int f36177d;

    /* renamed from: e  reason: collision with root package name */
    public int f36178e;

    /* renamed from: f  reason: collision with root package name */
    public int f36179f;

    /* renamed from: g  reason: collision with root package name */
    public int f36180g;
    public int j;
    public int k;
    public boolean o;
    public int i = 0;
    public int l = -1;
    public int m = -1;
    public int n = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f36181h = 0;

    public e(k kVar) {
        this.o = false;
        this.f36174a = kVar;
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
        int i2 = (i * this.f36175b) + this.f36177d;
        this.m = i2;
        if (i2 < 0 || i2 >= this.f36174a.f36186b) {
            throw new PngjException("bad row - this should not happen");
        }
    }

    public void a(int i) {
        int i2;
        if (this.i == i) {
            return;
        }
        this.i = i;
        byte[] b2 = b(i);
        this.f36176c = b2[0];
        byte b3 = b2[1];
        this.f36175b = b3;
        this.f36178e = b2[2];
        byte b4 = b2[3];
        this.f36177d = b4;
        int i3 = this.f36174a.f36186b;
        this.j = i3 > b4 ? (((i3 + b3) - 1) - b4) / b3 : 0;
        int i4 = this.f36174a.f36185a;
        int i5 = this.f36178e;
        if (i4 > i5) {
            int i6 = this.f36176c;
            i2 = (((i4 + i6) - 1) - i5) / i6;
        } else {
            i2 = 0;
        }
        this.k = i2;
        if (i2 == 0) {
            this.j = 0;
        }
        int i7 = this.f36176c;
        int i8 = this.f36174a.f36188d;
        this.f36180g = i7 * i8;
        this.f36179f = this.f36178e * i8;
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
        return ((this.f36174a.i * g()) + 7) / 8;
    }
}
