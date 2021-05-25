package com.kwad.sdk.pngencrypt;
/* loaded from: classes6.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public final k f33479a;

    /* renamed from: b  reason: collision with root package name */
    public final e f33480b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f33481c;

    /* renamed from: d  reason: collision with root package name */
    public int f33482d;

    /* renamed from: e  reason: collision with root package name */
    public int f33483e;

    /* renamed from: f  reason: collision with root package name */
    public int f33484f;

    /* renamed from: g  reason: collision with root package name */
    public int f33485g;

    /* renamed from: h  reason: collision with root package name */
    public int f33486h;

    /* renamed from: i  reason: collision with root package name */
    public int f33487i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public byte[] o;
    public int p;

    public p(k kVar, e eVar) {
        this.f33479a = kVar;
        this.f33480b = eVar;
        this.f33481c = eVar != null;
    }

    public void a(int i2) {
        this.f33486h = i2;
        if (!this.f33481c) {
            this.n = 1;
            this.f33482d = 1;
            this.f33483e = 1;
            this.f33484f = 0;
            this.f33485g = 0;
            this.j = i2;
            this.f33487i = i2;
            k kVar = this.f33479a;
            this.k = kVar.f33457b;
            this.l = kVar.f33456a;
            this.m = kVar.k;
            return;
        }
        this.n = this.f33480b.d();
        e eVar = this.f33480b;
        this.f33483e = eVar.f33445c;
        this.f33482d = eVar.f33444b;
        this.f33485g = eVar.f33447e;
        this.f33484f = eVar.f33446d;
        this.f33487i = eVar.c();
        this.j = this.f33480b.b();
        this.k = this.f33480b.e();
        int f2 = this.f33480b.f();
        this.l = f2;
        this.m = ((this.f33479a.f33464i * f2) + 7) / 8;
    }

    public void a(byte[] bArr, int i2) {
        this.o = bArr;
        this.p = i2;
    }
}
