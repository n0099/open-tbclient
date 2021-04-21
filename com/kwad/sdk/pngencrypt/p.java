package com.kwad.sdk.pngencrypt;
/* loaded from: classes6.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public final k f36591a;

    /* renamed from: b  reason: collision with root package name */
    public final e f36592b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f36593c;

    /* renamed from: d  reason: collision with root package name */
    public int f36594d;

    /* renamed from: e  reason: collision with root package name */
    public int f36595e;

    /* renamed from: f  reason: collision with root package name */
    public int f36596f;

    /* renamed from: g  reason: collision with root package name */
    public int f36597g;

    /* renamed from: h  reason: collision with root package name */
    public int f36598h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public byte[] o;
    public int p;

    public p(k kVar, e eVar) {
        this.f36591a = kVar;
        this.f36592b = eVar;
        this.f36593c = eVar != null;
    }

    public void a(int i) {
        this.f36598h = i;
        if (!this.f36593c) {
            this.n = 1;
            this.f36594d = 1;
            this.f36595e = 1;
            this.f36596f = 0;
            this.f36597g = 0;
            this.j = i;
            this.i = i;
            k kVar = this.f36591a;
            this.k = kVar.f36570b;
            this.l = kVar.f36569a;
            this.m = kVar.k;
            return;
        }
        this.n = this.f36592b.d();
        e eVar = this.f36592b;
        this.f36595e = eVar.f36560c;
        this.f36594d = eVar.f36559b;
        this.f36597g = eVar.f36562e;
        this.f36596f = eVar.f36561d;
        this.i = eVar.c();
        this.j = this.f36592b.b();
        this.k = this.f36592b.e();
        int f2 = this.f36592b.f();
        this.l = f2;
        this.m = ((this.f36591a.i * f2) + 7) / 8;
    }

    public void a(byte[] bArr, int i) {
        this.o = bArr;
        this.p = i;
    }
}
