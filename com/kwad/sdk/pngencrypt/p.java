package com.kwad.sdk.pngencrypt;
/* loaded from: classes8.dex */
public class p {
    public final k a;

    /* renamed from: b  reason: collision with root package name */
    public final e f55712b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f55713c;

    /* renamed from: d  reason: collision with root package name */
    public int f55714d;

    /* renamed from: e  reason: collision with root package name */
    public int f55715e;

    /* renamed from: f  reason: collision with root package name */
    public int f55716f;

    /* renamed from: g  reason: collision with root package name */
    public int f55717g;

    /* renamed from: h  reason: collision with root package name */
    public int f55718h;

    /* renamed from: i  reason: collision with root package name */
    public int f55719i;

    /* renamed from: j  reason: collision with root package name */
    public int f55720j;
    public int k;
    public int l;
    public int m;
    public int n;
    public byte[] o;
    public int p;

    public p(k kVar, e eVar) {
        this.a = kVar;
        this.f55712b = eVar;
        this.f55713c = eVar != null;
    }

    public void a(int i2) {
        this.f55718h = i2;
        if (!this.f55713c) {
            this.n = 1;
            this.f55714d = 1;
            this.f55715e = 1;
            this.f55716f = 0;
            this.f55717g = 0;
            this.f55720j = i2;
            this.f55719i = i2;
            k kVar = this.a;
            this.k = kVar.f55693b;
            this.l = kVar.a;
            this.m = kVar.k;
            return;
        }
        this.n = this.f55712b.d();
        e eVar = this.f55712b;
        this.f55715e = eVar.f55681c;
        this.f55714d = eVar.f55680b;
        this.f55717g = eVar.f55683e;
        this.f55716f = eVar.f55682d;
        this.f55719i = eVar.c();
        this.f55720j = this.f55712b.b();
        this.k = this.f55712b.e();
        int f2 = this.f55712b.f();
        this.l = f2;
        this.m = ((this.a.f55700i * f2) + 7) / 8;
    }

    public void a(byte[] bArr, int i2) {
        this.o = bArr;
        this.p = i2;
    }
}
