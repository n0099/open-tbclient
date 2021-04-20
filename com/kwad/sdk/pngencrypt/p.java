package com.kwad.sdk.pngencrypt;
/* loaded from: classes6.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public final k f36496a;

    /* renamed from: b  reason: collision with root package name */
    public final e f36497b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f36498c;

    /* renamed from: d  reason: collision with root package name */
    public int f36499d;

    /* renamed from: e  reason: collision with root package name */
    public int f36500e;

    /* renamed from: f  reason: collision with root package name */
    public int f36501f;

    /* renamed from: g  reason: collision with root package name */
    public int f36502g;

    /* renamed from: h  reason: collision with root package name */
    public int f36503h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public byte[] o;
    public int p;

    public p(k kVar, e eVar) {
        this.f36496a = kVar;
        this.f36497b = eVar;
        this.f36498c = eVar != null;
    }

    public void a(int i) {
        this.f36503h = i;
        if (!this.f36498c) {
            this.n = 1;
            this.f36499d = 1;
            this.f36500e = 1;
            this.f36501f = 0;
            this.f36502g = 0;
            this.j = i;
            this.i = i;
            k kVar = this.f36496a;
            this.k = kVar.f36475b;
            this.l = kVar.f36474a;
            this.m = kVar.k;
            return;
        }
        this.n = this.f36497b.d();
        e eVar = this.f36497b;
        this.f36500e = eVar.f36465c;
        this.f36499d = eVar.f36464b;
        this.f36502g = eVar.f36467e;
        this.f36501f = eVar.f36466d;
        this.i = eVar.c();
        this.j = this.f36497b.b();
        this.k = this.f36497b.e();
        int f2 = this.f36497b.f();
        this.l = f2;
        this.m = ((this.f36496a.i * f2) + 7) / 8;
    }

    public void a(byte[] bArr, int i) {
        this.o = bArr;
        this.p = i;
    }
}
