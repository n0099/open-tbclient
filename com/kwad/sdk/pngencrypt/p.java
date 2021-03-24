package com.kwad.sdk.pngencrypt;
/* loaded from: classes6.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public final k f36206a;

    /* renamed from: b  reason: collision with root package name */
    public final e f36207b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f36208c;

    /* renamed from: d  reason: collision with root package name */
    public int f36209d;

    /* renamed from: e  reason: collision with root package name */
    public int f36210e;

    /* renamed from: f  reason: collision with root package name */
    public int f36211f;

    /* renamed from: g  reason: collision with root package name */
    public int f36212g;

    /* renamed from: h  reason: collision with root package name */
    public int f36213h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public byte[] o;
    public int p;

    public p(k kVar, e eVar) {
        this.f36206a = kVar;
        this.f36207b = eVar;
        this.f36208c = eVar != null;
    }

    public void a(int i) {
        this.f36213h = i;
        if (!this.f36208c) {
            this.n = 1;
            this.f36209d = 1;
            this.f36210e = 1;
            this.f36211f = 0;
            this.f36212g = 0;
            this.j = i;
            this.i = i;
            k kVar = this.f36206a;
            this.k = kVar.f36185b;
            this.l = kVar.f36184a;
            this.m = kVar.k;
            return;
        }
        this.n = this.f36207b.d();
        e eVar = this.f36207b;
        this.f36210e = eVar.f36175c;
        this.f36209d = eVar.f36174b;
        this.f36212g = eVar.f36177e;
        this.f36211f = eVar.f36176d;
        this.i = eVar.c();
        this.j = this.f36207b.b();
        this.k = this.f36207b.e();
        int f2 = this.f36207b.f();
        this.l = f2;
        this.m = ((this.f36206a.i * f2) + 7) / 8;
    }

    public void a(byte[] bArr, int i) {
        this.o = bArr;
        this.p = i;
    }
}
