package com.kwad.sdk.pngencrypt;
/* loaded from: classes3.dex */
public class p {
    public final k a;

    /* renamed from: b  reason: collision with root package name */
    public final e f57150b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f57151c;

    /* renamed from: d  reason: collision with root package name */
    public int f57152d;

    /* renamed from: e  reason: collision with root package name */
    public int f57153e;

    /* renamed from: f  reason: collision with root package name */
    public int f57154f;

    /* renamed from: g  reason: collision with root package name */
    public int f57155g;

    /* renamed from: h  reason: collision with root package name */
    public int f57156h;

    /* renamed from: i  reason: collision with root package name */
    public int f57157i;

    /* renamed from: j  reason: collision with root package name */
    public int f57158j;
    public int k;
    public int l;
    public int m;
    public int n;
    public byte[] o;
    public int p;

    public p(k kVar, e eVar) {
        this.a = kVar;
        this.f57150b = eVar;
        this.f57151c = eVar != null;
    }

    public void a(int i2) {
        this.f57156h = i2;
        if (!this.f57151c) {
            this.n = 1;
            this.f57152d = 1;
            this.f57153e = 1;
            this.f57154f = 0;
            this.f57155g = 0;
            this.f57158j = i2;
            this.f57157i = i2;
            k kVar = this.a;
            this.k = kVar.f57131b;
            this.l = kVar.a;
            this.m = kVar.k;
            return;
        }
        this.n = this.f57150b.d();
        e eVar = this.f57150b;
        this.f57153e = eVar.f57119c;
        this.f57152d = eVar.f57118b;
        this.f57155g = eVar.f57121e;
        this.f57154f = eVar.f57120d;
        this.f57157i = eVar.c();
        this.f57158j = this.f57150b.b();
        this.k = this.f57150b.e();
        int f2 = this.f57150b.f();
        this.l = f2;
        this.m = ((this.a.f57138i * f2) + 7) / 8;
    }

    public void a(byte[] bArr, int i2) {
        this.o = bArr;
        this.p = i2;
    }
}
