package com.kwad.sdk.pngencrypt;
/* loaded from: classes5.dex */
class p {

    /* renamed from: a  reason: collision with root package name */
    public final k f10819a;

    /* renamed from: b  reason: collision with root package name */
    public final e f10820b;
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
        this.f10819a = kVar;
        this.f10820b = eVar;
        this.c = eVar != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        this.h = i;
        if (this.c) {
            this.n = this.f10820b.d();
            this.e = this.f10820b.c;
            this.d = this.f10820b.f10808b;
            this.g = this.f10820b.e;
            this.f = this.f10820b.d;
            this.i = this.f10820b.c();
            this.j = this.f10820b.b();
            this.k = this.f10820b.e();
            this.l = this.f10820b.f();
            this.m = ((this.f10819a.i * this.l) + 7) / 8;
            return;
        }
        this.n = 1;
        this.d = 1;
        this.e = 1;
        this.f = 0;
        this.g = 0;
        this.j = i;
        this.i = i;
        this.k = this.f10819a.f10811b;
        this.l = this.f10819a.f10810a;
        this.m = this.f10819a.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(byte[] bArr, int i) {
        this.o = bArr;
        this.p = i;
    }
}
