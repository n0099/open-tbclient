package com.kwad.sdk.pngencrypt;
/* loaded from: classes3.dex */
public class p {
    public final k a;

    /* renamed from: b  reason: collision with root package name */
    public final e f59395b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f59396c;

    /* renamed from: d  reason: collision with root package name */
    public int f59397d;

    /* renamed from: e  reason: collision with root package name */
    public int f59398e;

    /* renamed from: f  reason: collision with root package name */
    public int f59399f;

    /* renamed from: g  reason: collision with root package name */
    public int f59400g;

    /* renamed from: h  reason: collision with root package name */
    public int f59401h;

    /* renamed from: i  reason: collision with root package name */
    public int f59402i;

    /* renamed from: j  reason: collision with root package name */
    public int f59403j;

    /* renamed from: k  reason: collision with root package name */
    public int f59404k;
    public int l;
    public int m;
    public int n;
    public byte[] o;
    public int p;

    public p(k kVar, e eVar) {
        this.a = kVar;
        this.f59395b = eVar;
        this.f59396c = eVar != null;
    }

    public void a(int i2) {
        this.f59401h = i2;
        if (!this.f59396c) {
            this.n = 1;
            this.f59397d = 1;
            this.f59398e = 1;
            this.f59399f = 0;
            this.f59400g = 0;
            this.f59403j = i2;
            this.f59402i = i2;
            k kVar = this.a;
            this.f59404k = kVar.f59375b;
            this.l = kVar.a;
            this.m = kVar.f59384k;
            return;
        }
        this.n = this.f59395b.d();
        e eVar = this.f59395b;
        this.f59398e = eVar.f59361c;
        this.f59397d = eVar.f59360b;
        this.f59400g = eVar.f59363e;
        this.f59399f = eVar.f59362d;
        this.f59402i = eVar.c();
        this.f59403j = this.f59395b.b();
        this.f59404k = this.f59395b.e();
        int f2 = this.f59395b.f();
        this.l = f2;
        this.m = ((this.a.f59382i * f2) + 7) / 8;
    }

    public void a(byte[] bArr, int i2) {
        this.o = bArr;
        this.p = i2;
    }
}
