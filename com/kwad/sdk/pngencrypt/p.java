package com.kwad.sdk.pngencrypt;
/* loaded from: classes3.dex */
public class p {
    public final k a;

    /* renamed from: b  reason: collision with root package name */
    public final e f57195b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f57196c;

    /* renamed from: d  reason: collision with root package name */
    public int f57197d;

    /* renamed from: e  reason: collision with root package name */
    public int f57198e;

    /* renamed from: f  reason: collision with root package name */
    public int f57199f;

    /* renamed from: g  reason: collision with root package name */
    public int f57200g;

    /* renamed from: h  reason: collision with root package name */
    public int f57201h;

    /* renamed from: i  reason: collision with root package name */
    public int f57202i;

    /* renamed from: j  reason: collision with root package name */
    public int f57203j;
    public int k;
    public int l;
    public int m;
    public int n;
    public byte[] o;
    public int p;

    public p(k kVar, e eVar) {
        this.a = kVar;
        this.f57195b = eVar;
        this.f57196c = eVar != null;
    }

    public void a(int i2) {
        this.f57201h = i2;
        if (!this.f57196c) {
            this.n = 1;
            this.f57197d = 1;
            this.f57198e = 1;
            this.f57199f = 0;
            this.f57200g = 0;
            this.f57203j = i2;
            this.f57202i = i2;
            k kVar = this.a;
            this.k = kVar.f57176b;
            this.l = kVar.a;
            this.m = kVar.k;
            return;
        }
        this.n = this.f57195b.d();
        e eVar = this.f57195b;
        this.f57198e = eVar.f57164c;
        this.f57197d = eVar.f57163b;
        this.f57200g = eVar.f57166e;
        this.f57199f = eVar.f57165d;
        this.f57202i = eVar.c();
        this.f57203j = this.f57195b.b();
        this.k = this.f57195b.e();
        int f2 = this.f57195b.f();
        this.l = f2;
        this.m = ((this.a.f57183i * f2) + 7) / 8;
    }

    public void a(byte[] bArr, int i2) {
        this.o = bArr;
        this.p = i2;
    }
}
