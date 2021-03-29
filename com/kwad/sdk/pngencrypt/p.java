package com.kwad.sdk.pngencrypt;
/* loaded from: classes6.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public final k f36207a;

    /* renamed from: b  reason: collision with root package name */
    public final e f36208b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f36209c;

    /* renamed from: d  reason: collision with root package name */
    public int f36210d;

    /* renamed from: e  reason: collision with root package name */
    public int f36211e;

    /* renamed from: f  reason: collision with root package name */
    public int f36212f;

    /* renamed from: g  reason: collision with root package name */
    public int f36213g;

    /* renamed from: h  reason: collision with root package name */
    public int f36214h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public byte[] o;
    public int p;

    public p(k kVar, e eVar) {
        this.f36207a = kVar;
        this.f36208b = eVar;
        this.f36209c = eVar != null;
    }

    public void a(int i) {
        this.f36214h = i;
        if (!this.f36209c) {
            this.n = 1;
            this.f36210d = 1;
            this.f36211e = 1;
            this.f36212f = 0;
            this.f36213g = 0;
            this.j = i;
            this.i = i;
            k kVar = this.f36207a;
            this.k = kVar.f36186b;
            this.l = kVar.f36185a;
            this.m = kVar.k;
            return;
        }
        this.n = this.f36208b.d();
        e eVar = this.f36208b;
        this.f36211e = eVar.f36176c;
        this.f36210d = eVar.f36175b;
        this.f36213g = eVar.f36178e;
        this.f36212f = eVar.f36177d;
        this.i = eVar.c();
        this.j = this.f36208b.b();
        this.k = this.f36208b.e();
        int f2 = this.f36208b.f();
        this.l = f2;
        this.m = ((this.f36207a.i * f2) + 7) / 8;
    }

    public void a(byte[] bArr, int i) {
        this.o = bArr;
        this.p = i;
    }
}
