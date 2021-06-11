package com.kwad.sdk.pngencrypt;
/* loaded from: classes7.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public final k f36939a;

    /* renamed from: b  reason: collision with root package name */
    public final e f36940b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f36941c;

    /* renamed from: d  reason: collision with root package name */
    public int f36942d;

    /* renamed from: e  reason: collision with root package name */
    public int f36943e;

    /* renamed from: f  reason: collision with root package name */
    public int f36944f;

    /* renamed from: g  reason: collision with root package name */
    public int f36945g;

    /* renamed from: h  reason: collision with root package name */
    public int f36946h;

    /* renamed from: i  reason: collision with root package name */
    public int f36947i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public byte[] o;
    public int p;

    public p(k kVar, e eVar) {
        this.f36939a = kVar;
        this.f36940b = eVar;
        this.f36941c = eVar != null;
    }

    public void a(int i2) {
        this.f36946h = i2;
        if (!this.f36941c) {
            this.n = 1;
            this.f36942d = 1;
            this.f36943e = 1;
            this.f36944f = 0;
            this.f36945g = 0;
            this.j = i2;
            this.f36947i = i2;
            k kVar = this.f36939a;
            this.k = kVar.f36917b;
            this.l = kVar.f36916a;
            this.m = kVar.k;
            return;
        }
        this.n = this.f36940b.d();
        e eVar = this.f36940b;
        this.f36943e = eVar.f36905c;
        this.f36942d = eVar.f36904b;
        this.f36945g = eVar.f36907e;
        this.f36944f = eVar.f36906d;
        this.f36947i = eVar.c();
        this.j = this.f36940b.b();
        this.k = this.f36940b.e();
        int f2 = this.f36940b.f();
        this.l = f2;
        this.m = ((this.f36939a.f36924i * f2) + 7) / 8;
    }

    public void a(byte[] bArr, int i2) {
        this.o = bArr;
        this.p = i2;
    }
}
