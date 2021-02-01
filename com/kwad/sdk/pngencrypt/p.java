package com.kwad.sdk.pngencrypt;
/* loaded from: classes3.dex */
class p {

    /* renamed from: a  reason: collision with root package name */
    public final k f10522a;

    /* renamed from: b  reason: collision with root package name */
    public final e f10523b;
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
        this.f10522a = kVar;
        this.f10523b = eVar;
        this.c = eVar != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        this.h = i;
        if (this.c) {
            this.n = this.f10523b.d();
            this.e = this.f10523b.c;
            this.d = this.f10523b.f10511b;
            this.g = this.f10523b.e;
            this.f = this.f10523b.d;
            this.i = this.f10523b.c();
            this.j = this.f10523b.b();
            this.k = this.f10523b.e();
            this.l = this.f10523b.f();
            this.m = ((this.f10522a.i * this.l) + 7) / 8;
            return;
        }
        this.n = 1;
        this.d = 1;
        this.e = 1;
        this.f = 0;
        this.g = 0;
        this.j = i;
        this.i = i;
        this.k = this.f10522a.f10514b;
        this.l = this.f10522a.f10513a;
        this.m = this.f10522a.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(byte[] bArr, int i) {
        this.o = bArr;
        this.p = i;
    }
}
