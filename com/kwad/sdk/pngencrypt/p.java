package com.kwad.sdk.pngencrypt;
/* loaded from: classes5.dex */
class p {

    /* renamed from: a  reason: collision with root package name */
    public final k f10820a;

    /* renamed from: b  reason: collision with root package name */
    public final e f10821b;
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
        this.f10820a = kVar;
        this.f10821b = eVar;
        this.c = eVar != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        this.h = i;
        if (this.c) {
            this.n = this.f10821b.d();
            this.e = this.f10821b.c;
            this.d = this.f10821b.f10809b;
            this.g = this.f10821b.e;
            this.f = this.f10821b.d;
            this.i = this.f10821b.c();
            this.j = this.f10821b.b();
            this.k = this.f10821b.e();
            this.l = this.f10821b.f();
            this.m = ((this.f10820a.i * this.l) + 7) / 8;
            return;
        }
        this.n = 1;
        this.d = 1;
        this.e = 1;
        this.f = 0;
        this.g = 0;
        this.j = i;
        this.i = i;
        this.k = this.f10820a.f10812b;
        this.l = this.f10820a.f10811a;
        this.m = this.f10820a.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(byte[] bArr, int i) {
        this.o = bArr;
        this.p = i;
    }
}
