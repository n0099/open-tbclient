package com.kwad.sdk.pngencrypt;
/* loaded from: classes5.dex */
public class p {
    public final k a;
    public final e b;
    public final boolean c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
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
        this.b = eVar;
        this.c = eVar != null;
    }

    public void a(int i) {
        this.h = i;
        if (!this.c) {
            this.n = 1;
            this.d = 1;
            this.e = 1;
            this.f = 0;
            this.g = 0;
            this.j = i;
            this.i = i;
            k kVar = this.a;
            this.k = kVar.b;
            this.l = kVar.a;
            this.m = kVar.k;
            return;
        }
        this.n = this.b.d();
        e eVar = this.b;
        this.e = eVar.c;
        this.d = eVar.b;
        this.g = eVar.e;
        this.f = eVar.d;
        this.i = eVar.c();
        this.j = this.b.b();
        this.k = this.b.e();
        int f = this.b.f();
        this.l = f;
        this.m = ((this.a.i * f) + 7) / 8;
    }

    public void a(byte[] bArr, int i) {
        this.o = bArr;
        this.p = i;
    }
}
