package com.kwad.sdk.pngencrypt;
/* loaded from: classes6.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public final k f33550a;

    /* renamed from: b  reason: collision with root package name */
    public final e f33551b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f33552c;

    /* renamed from: d  reason: collision with root package name */
    public int f33553d;

    /* renamed from: e  reason: collision with root package name */
    public int f33554e;

    /* renamed from: f  reason: collision with root package name */
    public int f33555f;

    /* renamed from: g  reason: collision with root package name */
    public int f33556g;

    /* renamed from: h  reason: collision with root package name */
    public int f33557h;

    /* renamed from: i  reason: collision with root package name */
    public int f33558i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public byte[] o;
    public int p;

    public p(k kVar, e eVar) {
        this.f33550a = kVar;
        this.f33551b = eVar;
        this.f33552c = eVar != null;
    }

    public void a(int i2) {
        this.f33557h = i2;
        if (!this.f33552c) {
            this.n = 1;
            this.f33553d = 1;
            this.f33554e = 1;
            this.f33555f = 0;
            this.f33556g = 0;
            this.j = i2;
            this.f33558i = i2;
            k kVar = this.f33550a;
            this.k = kVar.f33528b;
            this.l = kVar.f33527a;
            this.m = kVar.k;
            return;
        }
        this.n = this.f33551b.d();
        e eVar = this.f33551b;
        this.f33554e = eVar.f33516c;
        this.f33553d = eVar.f33515b;
        this.f33556g = eVar.f33518e;
        this.f33555f = eVar.f33517d;
        this.f33558i = eVar.c();
        this.j = this.f33551b.b();
        this.k = this.f33551b.e();
        int f2 = this.f33551b.f();
        this.l = f2;
        this.m = ((this.f33550a.f33535i * f2) + 7) / 8;
    }

    public void a(byte[] bArr, int i2) {
        this.o = bArr;
        this.p = i2;
    }
}
