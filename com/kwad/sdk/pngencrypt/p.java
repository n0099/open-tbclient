package com.kwad.sdk.pngencrypt;
/* loaded from: classes6.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public final k f34305a;

    /* renamed from: b  reason: collision with root package name */
    public final e f34306b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f34307c;

    /* renamed from: d  reason: collision with root package name */
    public int f34308d;

    /* renamed from: e  reason: collision with root package name */
    public int f34309e;

    /* renamed from: f  reason: collision with root package name */
    public int f34310f;

    /* renamed from: g  reason: collision with root package name */
    public int f34311g;

    /* renamed from: h  reason: collision with root package name */
    public int f34312h;

    /* renamed from: i  reason: collision with root package name */
    public int f34313i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public byte[] o;
    public int p;

    public p(k kVar, e eVar) {
        this.f34305a = kVar;
        this.f34306b = eVar;
        this.f34307c = eVar != null;
    }

    public void a(int i2) {
        this.f34312h = i2;
        if (!this.f34307c) {
            this.n = 1;
            this.f34308d = 1;
            this.f34309e = 1;
            this.f34310f = 0;
            this.f34311g = 0;
            this.j = i2;
            this.f34313i = i2;
            k kVar = this.f34305a;
            this.k = kVar.f34283b;
            this.l = kVar.f34282a;
            this.m = kVar.k;
            return;
        }
        this.n = this.f34306b.d();
        e eVar = this.f34306b;
        this.f34309e = eVar.f34271c;
        this.f34308d = eVar.f34270b;
        this.f34311g = eVar.f34273e;
        this.f34310f = eVar.f34272d;
        this.f34313i = eVar.c();
        this.j = this.f34306b.b();
        this.k = this.f34306b.e();
        int f2 = this.f34306b.f();
        this.l = f2;
        this.m = ((this.f34305a.f34290i * f2) + 7) / 8;
    }

    public void a(byte[] bArr, int i2) {
        this.o = bArr;
        this.p = i2;
    }
}
