package com.kwad.sdk.pngencrypt;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    final k f10508a;

    /* renamed from: b  reason: collision with root package name */
    int f10509b;
    int c;
    int d;
    int e;
    int f;
    int g;
    private int j;
    private int k;
    private boolean o;
    private int i = 0;
    private int l = -1;
    private int m = -1;
    private int n = 0;
    int h = 0;

    public e(k kVar) {
        this.o = false;
        this.f10508a = kVar;
        this.o = false;
        a(1);
        c(0);
    }

    static byte[] b(int i) {
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
        this.m = (this.f10509b * i) + this.d;
        if (this.m < 0 || this.m >= this.f10508a.f10512b) {
            throw new PngjException("bad row - this should not happen");
        }
    }

    void a(int i) {
        if (this.i == i) {
            return;
        }
        this.i = i;
        byte[] b2 = b(i);
        this.c = b2[0];
        this.f10509b = b2[1];
        this.e = b2[2];
        this.d = b2[3];
        this.j = this.f10508a.f10512b > this.d ? (((this.f10508a.f10512b + this.f10509b) - 1) - this.d) / this.f10509b : 0;
        this.k = this.f10508a.f10511a > this.e ? (((this.f10508a.f10511a + this.c) - 1) - this.e) / this.c : 0;
        if (this.k == 0) {
            this.j = 0;
        }
        this.g = this.c * this.f10508a.d;
        this.f = this.e * this.f10508a.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        this.n++;
        if (this.j != 0 && this.l < this.j - 1) {
            c(this.l + 1);
        } else if (this.i == 7) {
            this.o = true;
            return false;
        } else {
            a(this.i + 1);
            if (this.j == 0) {
                this.n--;
                return a();
            }
            c(0);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.k;
    }

    public int g() {
        return f();
    }

    public int h() {
        return ((this.f10508a.i * g()) + 7) / 8;
    }
}
