package com.kwad.sdk.pngencrypt;
/* loaded from: classes3.dex */
class p {

    /* renamed from: a  reason: collision with root package name */
    public final k f6932a;
    public final e b;
    public final boolean c;
    int d;
    int e;
    int f;
    int g;
    int h;
    int i;
    int j;
    int k;
    int l;
    int m;
    int n;
    byte[] o;
    int p;

    public p(k kVar, e eVar) {
        this.f6932a = kVar;
        this.b = eVar;
        this.c = eVar != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        this.h = i;
        if (this.c) {
            this.n = this.b.d();
            this.e = this.b.c;
            this.d = this.b.b;
            this.g = this.b.e;
            this.f = this.b.d;
            this.i = this.b.c();
            this.j = this.b.b();
            this.k = this.b.e();
            this.l = this.b.f();
            this.m = ((this.f6932a.i * this.l) + 7) / 8;
            return;
        }
        this.n = 1;
        this.d = 1;
        this.e = 1;
        this.f = 0;
        this.g = 0;
        this.j = i;
        this.i = i;
        this.k = this.f6932a.b;
        this.l = this.f6932a.f6927a;
        this.m = this.f6932a.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(byte[] bArr, int i) {
        this.o = bArr;
        this.p = i;
    }
}
