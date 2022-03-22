package com.kwad.sdk.pngencrypt;
/* loaded from: classes7.dex */
public class p {
    public final k a;

    /* renamed from: b  reason: collision with root package name */
    public final e f40697b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f40698c;

    /* renamed from: d  reason: collision with root package name */
    public int f40699d;

    /* renamed from: e  reason: collision with root package name */
    public int f40700e;

    /* renamed from: f  reason: collision with root package name */
    public int f40701f;

    /* renamed from: g  reason: collision with root package name */
    public int f40702g;

    /* renamed from: h  reason: collision with root package name */
    public int f40703h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public byte[] o;
    public int p;

    public p(k kVar, e eVar) {
        this.a = kVar;
        this.f40697b = eVar;
        this.f40698c = eVar != null;
    }

    public void a(int i) {
        this.f40703h = i;
        if (!this.f40698c) {
            this.n = 1;
            this.f40699d = 1;
            this.f40700e = 1;
            this.f40701f = 0;
            this.f40702g = 0;
            this.j = i;
            this.i = i;
            k kVar = this.a;
            this.k = kVar.f40680b;
            this.l = kVar.a;
            this.m = kVar.k;
            return;
        }
        this.n = this.f40697b.d();
        e eVar = this.f40697b;
        this.f40700e = eVar.f40672c;
        this.f40699d = eVar.f40671b;
        this.f40702g = eVar.f40674e;
        this.f40701f = eVar.f40673d;
        this.i = eVar.c();
        this.j = this.f40697b.b();
        this.k = this.f40697b.e();
        int f2 = this.f40697b.f();
        this.l = f2;
        this.m = ((this.a.i * f2) + 7) / 8;
    }

    public void a(byte[] bArr, int i) {
        this.o = bArr;
        this.p = i;
    }
}
