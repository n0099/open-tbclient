package com.kwad.sdk.pngencrypt;
/* loaded from: classes3.dex */
public class e {
    public final k a;

    /* renamed from: b  reason: collision with root package name */
    public int f59360b;

    /* renamed from: c  reason: collision with root package name */
    public int f59361c;

    /* renamed from: d  reason: collision with root package name */
    public int f59362d;

    /* renamed from: e  reason: collision with root package name */
    public int f59363e;

    /* renamed from: f  reason: collision with root package name */
    public int f59364f;

    /* renamed from: g  reason: collision with root package name */
    public int f59365g;

    /* renamed from: j  reason: collision with root package name */
    public int f59368j;

    /* renamed from: k  reason: collision with root package name */
    public int f59369k;
    public boolean o;

    /* renamed from: i  reason: collision with root package name */
    public int f59367i = 0;
    public int l = -1;
    public int m = -1;
    public int n = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f59366h = 0;

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
        int i3 = (i2 * this.f59360b) + this.f59362d;
        this.m = i3;
        if (i3 < 0 || i3 >= this.a.f59375b) {
            throw new PngjException("bad row - this should not happen");
        }
    }

    public void a(int i2) {
        int i3;
        if (this.f59367i == i2) {
            return;
        }
        this.f59367i = i2;
        byte[] b2 = b(i2);
        this.f59361c = b2[0];
        byte b3 = b2[1];
        this.f59360b = b3;
        this.f59363e = b2[2];
        byte b4 = b2[3];
        this.f59362d = b4;
        int i4 = this.a.f59375b;
        this.f59368j = i4 > b4 ? (((i4 + b3) - 1) - b4) / b3 : 0;
        int i5 = this.a.a;
        int i6 = this.f59363e;
        if (i5 > i6) {
            int i7 = this.f59361c;
            i3 = (((i5 + i7) - 1) - i6) / i7;
        } else {
            i3 = 0;
        }
        this.f59369k = i3;
        if (i3 == 0) {
            this.f59368j = 0;
        }
        int i8 = this.f59361c;
        int i9 = this.a.f59377d;
        this.f59365g = i8 * i9;
        this.f59364f = this.f59363e * i9;
    }

    public boolean a() {
        int i2;
        this.n++;
        int i3 = this.f59368j;
        if (i3 == 0 || (i2 = this.l) >= i3 - 1) {
            int i4 = this.f59367i;
            if (i4 == 7) {
                this.o = true;
                return false;
            }
            a(i4 + 1);
            if (this.f59368j == 0) {
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
        return this.f59367i;
    }

    public int e() {
        return this.f59368j;
    }

    public int f() {
        return this.f59369k;
    }

    public int g() {
        return f();
    }

    public int h() {
        return ((this.a.f59382i * g()) + 7) / 8;
    }
}
