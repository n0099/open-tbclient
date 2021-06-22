package com.kwad.sdk.pngencrypt;
/* loaded from: classes7.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public final k f37037a;

    /* renamed from: b  reason: collision with root package name */
    public final e f37038b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f37039c;

    /* renamed from: d  reason: collision with root package name */
    public int f37040d;

    /* renamed from: e  reason: collision with root package name */
    public int f37041e;

    /* renamed from: f  reason: collision with root package name */
    public int f37042f;

    /* renamed from: g  reason: collision with root package name */
    public int f37043g;

    /* renamed from: h  reason: collision with root package name */
    public int f37044h;

    /* renamed from: i  reason: collision with root package name */
    public int f37045i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public byte[] o;
    public int p;

    public p(k kVar, e eVar) {
        this.f37037a = kVar;
        this.f37038b = eVar;
        this.f37039c = eVar != null;
    }

    public void a(int i2) {
        this.f37044h = i2;
        if (!this.f37039c) {
            this.n = 1;
            this.f37040d = 1;
            this.f37041e = 1;
            this.f37042f = 0;
            this.f37043g = 0;
            this.j = i2;
            this.f37045i = i2;
            k kVar = this.f37037a;
            this.k = kVar.f37015b;
            this.l = kVar.f37014a;
            this.m = kVar.k;
            return;
        }
        this.n = this.f37038b.d();
        e eVar = this.f37038b;
        this.f37041e = eVar.f37003c;
        this.f37040d = eVar.f37002b;
        this.f37043g = eVar.f37005e;
        this.f37042f = eVar.f37004d;
        this.f37045i = eVar.c();
        this.j = this.f37038b.b();
        this.k = this.f37038b.e();
        int f2 = this.f37038b.f();
        this.l = f2;
        this.m = ((this.f37037a.f37022i * f2) + 7) / 8;
    }

    public void a(byte[] bArr, int i2) {
        this.o = bArr;
        this.p = i2;
    }
}
