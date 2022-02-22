package com.kwad.sdk.pngencrypt;
/* loaded from: classes4.dex */
public class p {
    public final k a;

    /* renamed from: b  reason: collision with root package name */
    public final e f57362b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f57363c;

    /* renamed from: d  reason: collision with root package name */
    public int f57364d;

    /* renamed from: e  reason: collision with root package name */
    public int f57365e;

    /* renamed from: f  reason: collision with root package name */
    public int f57366f;

    /* renamed from: g  reason: collision with root package name */
    public int f57367g;

    /* renamed from: h  reason: collision with root package name */
    public int f57368h;

    /* renamed from: i  reason: collision with root package name */
    public int f57369i;

    /* renamed from: j  reason: collision with root package name */
    public int f57370j;
    public int k;
    public int l;
    public int m;
    public int n;
    public byte[] o;
    public int p;

    public p(k kVar, e eVar) {
        this.a = kVar;
        this.f57362b = eVar;
        this.f57363c = eVar != null;
    }

    public void a(int i2) {
        this.f57368h = i2;
        if (!this.f57363c) {
            this.n = 1;
            this.f57364d = 1;
            this.f57365e = 1;
            this.f57366f = 0;
            this.f57367g = 0;
            this.f57370j = i2;
            this.f57369i = i2;
            k kVar = this.a;
            this.k = kVar.f57343b;
            this.l = kVar.a;
            this.m = kVar.k;
            return;
        }
        this.n = this.f57362b.d();
        e eVar = this.f57362b;
        this.f57365e = eVar.f57331c;
        this.f57364d = eVar.f57330b;
        this.f57367g = eVar.f57333e;
        this.f57366f = eVar.f57332d;
        this.f57369i = eVar.c();
        this.f57370j = this.f57362b.b();
        this.k = this.f57362b.e();
        int f2 = this.f57362b.f();
        this.l = f2;
        this.m = ((this.a.f57350i * f2) + 7) / 8;
    }

    public void a(byte[] bArr, int i2) {
        this.o = bArr;
        this.p = i2;
    }
}
