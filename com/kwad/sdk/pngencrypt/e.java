package com.kwad.sdk.pngencrypt;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    final k f6925a;
    int b;
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
        this.f6925a = kVar;
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
        this.m = (this.b * i) + this.d;
        if (this.m < 0 || this.m >= this.f6925a.b) {
            throw new PngjException("bad row - this should not happen");
        }
    }

    void a(int i) {
        if (this.i == i) {
            return;
        }
        this.i = i;
        byte[] b = b(i);
        this.c = b[0];
        this.b = b[1];
        this.e = b[2];
        this.d = b[3];
        this.j = this.f6925a.b > this.d ? (((this.f6925a.b + this.b) - 1) - this.d) / this.b : 0;
        this.k = this.f6925a.f6927a > this.e ? (((this.f6925a.f6927a + this.c) - 1) - this.e) / this.c : 0;
        if (this.k == 0) {
            this.j = 0;
        }
        this.g = this.c * this.f6925a.d;
        this.f = this.e * this.f6925a.d;
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
        return ((this.f6925a.i * g()) + 7) / 8;
    }
}
